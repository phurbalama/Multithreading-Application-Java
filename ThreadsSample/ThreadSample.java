package ThreadsSample;

public class ThreadSample implements Runnable{
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
        ThreadSample obj = new ThreadSample();
        Thread th = new Thread(obj, "th1");
        th.start();
        try {
            th.join();//when using multi thread it will wait for first thread to complete before going to another
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //will create an interrupt exception
        th.interrupt();//will not allow thread to sleep. Active thread will not interrupt
    }
}
