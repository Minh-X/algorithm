import java.util.HashMap;
import java.util.HashSet;
import java.util.WeakHashMap;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: permission
 * @Date: 2023/2/27 10:14
 * @Version: 1.0
 * @ClassName: HeapTest
 * @Description:
 */
public class HeapTest extends AbstractQueuedSynchronizer {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        new String();
//        int[] a;
//        int b[];
//        new HashMap<Integer, String>().put(1, "x");
//        new HashSet<String>().add("X");
//
//        new ConcurrentHashMap<>();
        ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();
//        threadPoolExecutor.execute(() -> {
//            int a = 1/0;
//        });

        Future<?> submit = threadPoolExecutor.submit(() -> {
            return 1/0;
        });

        System.out.println(1);

//        System.out.println(submit.get());

//        WeakHashMap<Integer, String> map = new WeakHashMap<>();
////        HashMap<Integer,String> map = new HashMap<>();
//        int i = 0;
//        while (true) {
////            System.out.println(++i);
//            if (map.containsKey(0)) {
////                continue;
//                break;
//            } else {
//                map.put(0, "bytes");
//            }
////            Thread.sleep(100);
//
//        }
    }
}