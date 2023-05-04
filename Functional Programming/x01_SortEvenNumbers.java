package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;


public class x01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> num = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).filter(n -> n % 2 == 0).toList();

        System.out.println(num.stream().map(String::valueOf).collect(Collectors.joining(", ")));


        System.out.println(num.stream().sorted().map(String::valueOf).collect(Collectors.joining(", ")));

    }
}
