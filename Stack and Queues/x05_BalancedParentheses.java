package StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class x05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        boolean isBalanced = false;

        if (inputLine.length() % 2 != 0){
            System.out.println("NO");
            return;
        }


        for (char currentBracket : inputLine.toCharArray()) {

            if (currentBracket == ('(') || currentBracket == ('[') || currentBracket == ('{')){
                stack.push(currentBracket);
            }else if (currentBracket == (')') || currentBracket == (']') || currentBracket == ('}')){
                queue.offer(currentBracket);
            }
//            if (inputLine.length / 2 > i) {
//                stack.push(inputLine[i]);
//            } else {
//                queue.offer(inputLine[i]);
//            }
        }

        while (stack.size() != 0 && queue.size() != 0) {
            char currentOpenBracket = stack.pop();
            char currentClosedBracket = queue.poll();
            if ((currentOpenBracket == ('(') && currentClosedBracket == (')')) ||
                 (currentOpenBracket == ('[') && currentClosedBracket == (']')) ||
                 (currentOpenBracket == ('{') && currentClosedBracket == ('}'))) {
                isBalanced = true;

            }else {
                isBalanced = false;
                break;
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
