class PresentationThread extends Thread {
    private String name;

    public PresentationThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getId() + " " + name + " is presenting part " + (i + 1));
            try {
                Thread.sleep(500); // pause for 500ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }


    public static void main(String[] args) {
        new PresentationThread("Denis").start();
        new PresentationThread("Samuel").start();
    }
}
