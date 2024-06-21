package array_empty_time;

import java.util.*;

class ArrayEmptyTime {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            q1.add(sc.nextInt());
        }
        for (int i = 0; i < size; i++) {
            q2.add(sc.nextInt());
        }
        int res = 0;
        while (!q1.isEmpty()) {
            boolean condition = Objects.equals(q1.peek(), q2.peek());
            if (!condition) {
                q1.add(q1.poll());
            } else {
                q1.remove();
                q2.remove();
            }
            res++;
        }
        System.out.println(res);
    }
}