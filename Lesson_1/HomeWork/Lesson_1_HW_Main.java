package Lesson_1.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;

public class Lesson_1_HW_Main {
    public static void main(String[] args) {
        /*
        //Ex. 1
        Integer[] mass = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(replace(mass, 2, 3)));
        */

        /*
        //Ex. 2
        Integer[] mass = {1, 2, 3, 4};
        ArrayList list = convert(mass);
        System.out.println(list);
        */

        //Ex. 3
        Box<Apple> b1 = new Box<Apple>(new Apple(), new Apple(), new Apple());
        Box<Orange> b2 = new Box<Orange>(new Orange(), new Orange());
        System.out.println(b1.compare(b2));

    }

    //Ex. 1
    public static Object[] replace(Object[] data, int index1, int index2) {
        Object tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
        return data;
    }

    //Ex. 2 v.1
    public static ArrayList convert(Object[] data) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < data.length; i++) {
            list.add(data[i]);
        }
        return list;
    }

    //Ex. 2 v.2
    public static <T> ArrayList<T> convert1(T[] arr) {
        return new ArrayList<T>(Arrays.asList(arr));
    }
}
