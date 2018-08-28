package Lesson_4.HomeWork;

public class Task1 {
    static volatile char str = 'A';

    public static void main(String[] args) {
        Object lock = new Object();

        class RunTask1 implements Runnable{
            private char symb;
            private char nextSymb;

            public RunTask1(char symb, char nextSymb){
                this.symb = symb;
                this.nextSymb = nextSymb;
            }

            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < 5; i++) {
                        try {
                            while (str != symb) {
                                lock.wait();
                            }
                            System.out.print(symb);
                            str = nextSymb;
                            lock.notifyAll();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        new Thread(new RunTask1('A','B')).start();
        new Thread(new RunTask1('B','C')).start();
        new Thread(new RunTask1('C','A')).start();
    }
}
