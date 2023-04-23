package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class x04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();  // number of elements in to push in Queue
        int S = scanner.nextInt();  // number of elements to pop from the Queue
        int X = scanner.nextInt();  // number to check whether is contains in Queue

        ArrayDeque<Integer> queueOfNums = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            queueOfNums.offer(scanner.nextInt());
        }
        for (int i = 1; i <= S; i++) {
            queueOfNums.poll();
        }

        if (queueOfNums.contains(X)) {
            System.out.println(true);
        } else {
            if (queueOfNums.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(queueOfNums));
            }
        }
    }
}
