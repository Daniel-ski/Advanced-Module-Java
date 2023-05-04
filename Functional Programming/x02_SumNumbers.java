package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class x02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[],String> funcCount = nums -> "Count = " + Arrays.stream(nums).count();
        Function<int[],String> funcSum = nums -> "Sum = " + Arrays.stream(nums).sum();

        int[] nums = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(funcCount.apply(nums));
        System.out.println(funcSum.apply(nums));


    }
}
