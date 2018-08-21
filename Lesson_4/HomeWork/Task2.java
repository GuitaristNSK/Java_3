package Lesson_4.HomeWork;

import java.io.IOException;
import java.io.PrintWriter;

public class Task2 {
    public static void main(String[] args) {

        class TextWriter implements Runnable {
            private PrintWriter pw;
            private int tmp;

            public TextWriter(PrintWriter pw, int tmp) {
                this.pw = pw;
                this.tmp = tmp;
            }

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(20);
                        pw.println(tmp);
                        pw.flush();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        PrintWriter pw = null;
        try {
            pw = new PrintWriter("1.txt");
            Thread t1 = new Thread(new TextWriter(pw, 2));
            Thread t2 = new Thread(new TextWriter(pw, 4));
            Thread t3 = new Thread(new TextWriter(pw, 6));
            try {
                t1.start();
                t2.start();
                t3.start();
                t1.join();
                t2.join();
                t3.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
        }
    }
}
