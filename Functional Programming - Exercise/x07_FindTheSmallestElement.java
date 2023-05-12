package FunctionalProgramming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class x07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toList();

        Function<List<Integer>, Integer> smallestOne = nums -> {
            int min = nums.stream().mapToInt(num -> num).min().getAsInt();
           return nums.lastIndexOf(min);
        };

        System.out.println(smallestOne.apply(numbers));
    }
}
