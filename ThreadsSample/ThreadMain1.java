package ThreadsSample;

public class ThreadMain1 extends Thread{

    @Override
    public void run(){
        super.run();

        for (int i = 0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("this is sample thread");
        }
    }
    public static void main(String[] args) {
        ThreadMain1 thobj = new ThreadMain1();
        thobj.start();//starts the thread. it will create a thread and execute
        //thobj.run();//it will not create a thread

    }
}
