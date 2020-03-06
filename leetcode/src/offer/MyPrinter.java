package offer;

import java.util.concurrent.Semaphore;

public class MyPrinter {
	
  	volatile static int res = 0;
  	static Semaphore s1 = new Semaphore(1);
  	static Semaphore s2 = new Semaphore(0);
  
  	public static void main(String[] args) {
    	new Thread(new Runnable(){
        	public void run() {
              	while (res < 99) {
                  	try {
              			s1.acquire();
              			System.out.println("Printer1" + "-" + ++res);
              			s2.release();
                    } catch(InterruptedException e) {
                    
                    }
                }
            }
        }).start();
      	new Thread(new Runnable(){
        	public void run() {
            	while (res < 100) {
                  	try {
                		s2.acquire();
              			System.out.println("-" + ++res);
              			s1.release();
                    } catch (InterruptedException e) {
                    	
                    }
                }
            }
        }).start();
    	
    }

}