package CallableSample;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAnySample {
        public static void invokeAny(){
        try{
        ExecutorService exe = Executors.newSingleThreadExecutor();
        List<Callable<Integer>> threadsList = new ArrayList<>();
        threadsList.add(new Callable<Integer>(){
            @Override
            public Integer call() throws Exception{
                return 15;
            }
        });
        threadsList.add(new SampleCallable());
        //only execute one thread from collection
        exe.invokeAny(threadsList);
    }catch(Exception e){
        e.printStackTrace();
    }
        System.out.println("After Completion");
        }
    public static void main(String[] args){
            }
}

