package Exercise.SantasPresentFactory;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Integer> toysData = new LinkedHashMap<>();
        toysData.put("Doll",0);
        toysData.put("Wooden train",0);
        toysData.put("Teddy bear",0);
        toysData.put("Bicycle",0);

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        String[] firstInputLine = scanner.nextLine().split("\\s+");
        for (String num : firstInputLine) {
            materialsStack.push(Integer.valueOf(num));
        }
        //  Queue<Integer> materialsStack = Arrays.stream(firstInputLine.split("\\s+"))
        //                                .map(Integer::parseInt)
        //                                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> magicsQueue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(magicsQueue::offer);

       while (!materialsStack.isEmpty() && !magicsQueue.isEmpty()){
            int currentMultiplication = materialsStack.peek() * magicsQueue.peek();

            if (materialsStack.peek() == 0){
                materialsStack.pop();
            }
            if (magicsQueue.peek() == 0){
                magicsQueue.poll();
            }

            if (currentMultiplication == 150){
                toysData.put("Doll",toysData.get("Doll") + 1);
                materialsStack.remove();
                magicsQueue.remove();
            } else if (currentMultiplication == 250) {
                toysData.put("Wooden train",toysData.get("Wooden train") + 1);
                materialsStack.remove();
                magicsQueue.remove();
            } else if (currentMultiplication == 300) {
                toysData.put("Teddy bear",toysData.get("Teddy bear") + 1);
                materialsStack.remove();
                magicsQueue.remove();
            } else if (currentMultiplication == 400) {
                toysData.put("Bicycle",toysData.get("Bicycle") + 1);
                materialsStack.remove();
                magicsQueue.remove();
            } else if (currentMultiplication < 0) {
                int sum = Math.abs(materialsStack.peek() + magicsQueue.peek());
                materialsStack.remove();
                magicsQueue.remove();
                materialsStack.push(sum);
            } else if (currentMultiplication > 0) {
                magicsQueue.remove();
                int newElementToAdd = materialsStack.pop() + 15;
                materialsStack.push(newElementToAdd);
            }
       }
       if (isSuccessfully(toysData)){
           System.out.println("The presents are crafted! Merry Christmas!");
       }else {
           System.out.println("No presents this Christmas!");
       }

       printLeftMaterials(materialsStack,magicsQueue);

       printCrafted(toysData);


    }
    public static boolean isSuccessfully(Map<String,Integer> toysData){
       if (toysData.get("Doll") > 0 && toysData.get("Wooden train") > 0){
           return true;
        } else if (toysData.get("Teddy bear") > 0 && toysData.get("Bicycle") > 0) {
           return true;
       }
        return false;
    }

    public static void printLeftMaterials(ArrayDeque<Integer> boxWithMaterialsStack,ArrayDeque<Integer> magicLevelQueue ){
        if (!boxWithMaterialsStack.isEmpty()){
            System.out.print("Materials left: ");
            //[3, 4, 5]

            System.out.println(boxWithMaterialsStack.toString().replace("[", "").replace("]", ""));
           /* StringBuilder sb = new StringBuilder();
            sb.append("Materials left: ");
            boxWithMaterialsStack.forEach(e -> sb.append(e+","));
            System.out.println(sb.toString());

            */
          } else if (!magicLevelQueue.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.println(magicLevelQueue.toString().replace("[", "").replace("]", ""));
           /* StringBuilder sb = new StringBuilder();
            sb.append("Magic left: ");
            boxWithMaterialsStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println(sb.toString());

            */
        }
    }

    public static void printCrafted(Map<String,Integer> toysData){
        toysData.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .filter(e -> e.getValue() >= 1).forEach(e -> System.out.printf("%s: %d%n",e.getKey(),e.getValue()));
    }
}
