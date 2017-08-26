import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * CountDownLatch Test
 */
public class CountDownLatchTest {

    @Test
    public void test_single() throws InterruptedException {
        final ICountDownLatch latch = new MyCountDownLatch(1);

        Assert.assertEquals(1, latch.getCount());

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                latch.countDown();
            }
        });

        t.run();
        latch.await();
        Assert.assertEquals(0, latch.getCount());
    }

    @Test
    public void test_multi() throws  InterruptedException {
        final int nThreads = 3;
        final ICountDownLatch latch = new MyCountDownLatch(nThreads);

        Assert.assertEquals(nThreads, latch.getCount());

        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        List<Future> futures = new ArrayList<Future>();
        for (int i=0; i<nThreads; i++) {
            Future<?> future = executorService.submit(new Runnable() {
                @Override
                public void run() {
                    latch.countDown();
                }
            });
            futures.add(future);
        }

        latch.await();
        Assert.assertEquals(0, latch.getCount());

        for (Future future : futures) {
            Assert.assertTrue(future.isDone());
        }
    }

    @Test
    public void test_timeout() throws  InterruptedException {
        /*
            Write a test that tests latch.await( timeout )
         */
        //TODO implement
    }
}
