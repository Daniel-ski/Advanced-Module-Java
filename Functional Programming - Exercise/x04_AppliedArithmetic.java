package FunctionalProgramming_Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class x04_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toList();

        UnaryOperator<List<Integer>> add = numbers -> numbers.stream().map(num -> num + 1).toList();
        UnaryOperator<List<Integer>> multiply = numbers -> numbers.stream().map(num -> num * 2).toList();
        UnaryOperator<List<Integer>> subtract = numbers -> numbers.stream().map(num -> num -1).toList();


        String command = scanner.nextLine();

        while (!command.equals("end")){

            switch (command){
                case "add":
                   nums = add.apply(nums);
                    break;
                case "multiply":
                    nums = multiply.apply(nums);
                    break;
                case "subtract":
                  nums = subtract.apply(nums);
                    break;
                case "print":
                    nums.forEach(num -> System.out.print(num + " "));
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
