package ThreadsSample;

public class ThreadSleepSample implements Runnable{
    @Override
    public void run() {
        //make the thread to sleep for 1s
        System.out.println("starting the thread");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("this is sample thread");
    }

    public static void main(String[] args) {
        ThreadSleepSample obj = new ThreadSleepSample();
        Thread th = new Thread(obj);
        th.start();
        //will create an interrupt exception
        th.interrupt();//will not allow thread to sleep. Active thread will not interrupt
    }
}
