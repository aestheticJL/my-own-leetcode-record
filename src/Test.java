import java.util.concurrent.*;

public class Test implements Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future future = new FutureTask(new Test());
        System.out.println(future.get());
    }

    @Override
    public Object call() throws Exception {
        return 1;
    }
}
