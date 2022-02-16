package CallableSample;

import java.util.concurrent.Callable;

public class SampleCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("this is callable thread");
        return 10;
    }
}