package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class x02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firsInputLine = scanner.nextLine();
        String N = firsInputLine.split("\\s+")[0];  // number of elements in to push in Stack
        String S = firsInputLine.split("\\s+")[1];  // number of elements to pop from the Stack
        String X = firsInputLine.split("\\s+")[2];  // number to check whether is contains in Stack

        ArrayDeque<String> stackOfNums = new ArrayDeque<>();

        String[] secondInputLine = scanner.nextLine().split("\\s+");


        for (int i = 0; i < Integer.parseInt(N); i++) {
            stackOfNums.push(secondInputLine[i]);
        }
        for (int i = 1; i <= Integer.parseInt(S); i++) {
            stackOfNums.pop();
        }

        if (stackOfNums.contains(X)) {
            System.out.println(true);
        } else {
            smallestNum(stackOfNums);
        }
    }

    public static void smallestNum(ArrayDeque<String> stackOfNums) {
        int smallestNum = stackOfNums.size() == 0 ? 0 : Integer.MAX_VALUE;

        for (String num : stackOfNums) {
            boolean check = Integer.parseInt(num) < smallestNum;
            if (check) {
                smallestNum = Integer.parseInt(num);
            }
        }
        System.out.println(smallestNum);
    }
}
