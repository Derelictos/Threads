public class Application implements Runnable {

    @Override
    public void run() {
        for(;;) {
            System.out.println("Hello my new Thread:D");

        }
    }

    public static void main(String[] args) {
        (new Thread (new Application())).start();
    }

}

