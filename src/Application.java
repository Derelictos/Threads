public class Application {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable);
        thread1.start();
    }
}

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Поток класса Thread " + Thread.currentThread().getId() + ": " + i);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int j = 1; j <= 10; j++){
            System.out.println("Поток интерфейса Runnable " + Thread.currentThread().getId() + ": " + j);
        }
    }
}



