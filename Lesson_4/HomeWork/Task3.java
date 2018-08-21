package Lesson_4.HomeWork;

public class Task3 {
    Object printLock = new Object();
    Object scanLock = new Object();

    public void print(String docName) {
        synchronized (printLock) {
            System.out.println("Начало печати документа " + docName);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Документ " + docName + " напечатан");
        }
    }

    public void scan(String docName) {
        synchronized (scanLock) {
            System.out.println("Начало сканирования документа " + docName);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Документ " + docName + " отсканирован");
        }
    }

}
