package Lesson_3.HomeWork;

import java.io.*;
import java.util.*;

public class Lesson_3_HomeWork_Main {
    public static void main(String[] args) {
        try {
            task1();
            task2();
            task3();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void task1() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("1.txt"));
        byte[] arr = new byte[in.available()];
        in.read(arr);
        System.out.println(Arrays.toString(arr));
        in.close();
    }

    public static void task2() throws IOException {
        ArrayList<InputStream> al = new ArrayList<>();
        al.add(new FileInputStream("1.txt"));
        al.add(new FileInputStream("2.txt"));
        al.add(new FileInputStream("3.txt"));
        al.add(new FileInputStream("4.txt"));
        al.add(new FileInputStream("5.txt"));
        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out.txt"));
        int x;
        while ((x = in.read()) != -1) {
            out.write(x);
        }
        in.close();
        out.close();
    }

    public static void task3() throws IOException {
        RandomAccessFile file = new RandomAccessFile("1.txt", "rw");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter page:");
        int page = reader.read();
        file.seek(page * 1800);
        byte[] arr = new byte[1800];
        file.read(arr);
        System.out.println(new String(arr));
        file.close();
    }
}
