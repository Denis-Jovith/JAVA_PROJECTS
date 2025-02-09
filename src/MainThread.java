class DenisThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Denis is presenting part " + (i + 1));
            try {
                Thread.sleep(500); // pause for 500ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class SamuelThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " Samuel is presenting part " + (i + 1));
            try {
                Thread.sleep(500); // pause for 500ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class MainThread {
    public static void main(String[] args) {
        DenisThread t1 = new DenisThread();
        SamuelThread t2 = new SamuelThread();

        t1.start(); // Denis starts his presentation
        t2.start(); // Samuel starts his presentation
    }
}
