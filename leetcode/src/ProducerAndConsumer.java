import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerAndConsumer {

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[10];

    int putAdr = 0;
    int takeAdr = 0;
    int count = 0;


    public void put(Object o) {
        lock.lock();
        try {
            if (count == items.length) {
                notFull.await();
            }
            items[putAdr++] = o;
            count++;
            if (putAdr == items.length - 1) {
                putAdr = 0;
            }
            notEmpty.signal();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    public Object take() {
        lock.lock();
        try {
            if (count == 0) {
                notEmpty.await();
            }
            Object o = items[takeAdr++];
            count--;
            if (takeAdr == items.length) {
                takeAdr = 0;
            }
            notFull.signal();
            return o;
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
        return null;
    }

}
