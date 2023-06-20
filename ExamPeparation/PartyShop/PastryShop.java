package Exercise.PastryShop;

import java.util.*;

public class PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInputLine = scanner.nextLine();

        Queue<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(firstInputLine.split("\\s+")).mapToInt(Integer::parseInt).forEach(liquids::offer);

        String secondInputLine = scanner.nextLine();

        Stack<Integer> ingredient = new Stack<>();
        Arrays.stream(secondInputLine.split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredient::push);

        Map<String,Integer> cookFood = new LinkedHashMap<>();
        cookFood.put("Biscuit",0);
        cookFood.put("Cake",0);
        cookFood.put("Pastry",0);
        cookFood.put("Pie",0);

        while(!liquids.isEmpty() && !ingredient.isEmpty()){
            int mixSum = liquids.peek() + ingredient.peek();

            if (mixSum == 25){
            cookFood.put("Biscuit",cookFood.get("Biscuit") + 1);
            liquids.poll();
            ingredient.pop();
                
            } else if (mixSum == 50) {
                cookFood.put("Cake",cookFood.get("Cake") + 1);
                liquids.poll();
                ingredient.pop();

            } else if (mixSum == 75) {
                cookFood.put("Pastry",cookFood.get("Pastry") + 1);
                liquids.poll();
                ingredient.pop();

            } else if (mixSum == 100) {
                cookFood.put("Pie",cookFood.get("Pie") + 1);
                liquids.poll();
                ingredient.pop();

            }else {
                liquids.poll();
                ingredient.push(ingredient.pop() + 3);
            }
        }
        checkEverythingIsCooked(cookFood);
        printAllLiquids(liquids);
        printAllIngredient(ingredient);
        printAllCookedFood(cookFood);
    }

    public static void checkEverythingIsCooked(Map<String,Integer> cookFood){
        boolean isSucceeded = true;

        for (var entry : cookFood.entrySet()) {
            if (entry.getValue() == 0){
                isSucceeded = false;
                break;
            }
        }

        if (isSucceeded){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

    }

    public static void printAllLiquids(Queue<Integer> liquids){
        if (!liquids.isEmpty()){
            System.out.print("Liquids left: ");
            System.out.print(liquids.toString().replace("[", "").replace("]", ""));
            System.out.println();
        }else {
            System.out.println("Liquids left: none");
        }
    }
    public static void printAllIngredient(Stack<Integer> ingredient) {
        if (!ingredient.isEmpty()){
            System.out.print("Ingredients left: ");

            System.out.print(ingredient.toString().replace("[", "").replace("]", ""));
            System.out.println();
        }else {
            System.out.println("Ingredients left: none");
        }
    }
    public static void  printAllCookedFood(Map<String,Integer> cookFood){
        cookFood.entrySet().forEach(food ->{
            System.out.printf("%s: %d%n",food.getKey(),food.getValue());
        });
    }
}
