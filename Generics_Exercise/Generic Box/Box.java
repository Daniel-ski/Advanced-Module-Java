package Generics_Exercise.GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {

    private List<T> elements;

    public Box(){
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        this.elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : elements) {
           sb.append(String.format("%s: %s%n",element.getClass().getName(),element));
        }
       return sb.toString();
    }
}
