package ThreadsSample;

import CallableSample.SampleCallable;

import java.util.concurrent.*;

public class ThreadCallableSample {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newSingleThreadExecutor();
        Future<Integer> fut = exe.submit(new SampleCallable());

        try {
            System.out.println(fut.get());//hold the program till it gets the result

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

