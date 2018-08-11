package Lesson_1.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    ArrayList<T> list;

    public Box(T... fruits) {
        list = new ArrayList<T>(Arrays.asList(fruits));
    }

    public void add(T fruit) {
        list.add(fruit);
    }

    public float getWeight() {
        float w = 0.0f;
        for (Fruit t : list) {
            w += t.getWeight();
        }
        return w;
    }

    public boolean compare(Box<?> box) {
        return Math.abs(getWeight() - box.getWeight()) < 0.0001;
    }

    public void transfer(Box<T> another) {
        another.list.addAll(this.list);
        this.list.clear();
    }
}
