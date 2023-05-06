package FunctionalProgramming_Exercise;

import java.util.*;
import java.util.function.Function;

public class x03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[],Integer> smallestNum = num -> Arrays.stream(num).min().orElseThrow(IllegalArgumentException::new);

        System.out.println(smallestNum.apply(nums));
    }
}
