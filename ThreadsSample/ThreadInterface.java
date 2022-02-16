package ThreadsSample;

public class ThreadInterface implements Runnable{
    @Override
    public void run() {
        for(int i = 0;i< 10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("this is sample thread");
        }
    }

    public static void main(String[] args) {
        ThreadInterface th1 = new ThreadInterface();
        Thread th = new Thread(th1);
        th.start();
    }
}
