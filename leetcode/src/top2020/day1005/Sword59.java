package top2020.day1005;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Sword59 {
    Queue<Integer> q1;
    Deque<Integer> q2;

    public Sword59() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public int max_value() {
        return q1.size() == 0 ? -1 : q2.peek();
    }

    public void push_back(int value) {
        q1.add(value);
        while (!q2.isEmpty() && value > q2.peekLast()) {
            q2.pollLast();
        }
        q2.add(value);
    }

    public int pop_front() {
        int res = q1.poll();
        if (res == q2.peek()) {
            q2.poll();
        }
        return res;
    }
}
