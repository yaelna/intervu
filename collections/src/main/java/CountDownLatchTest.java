import org.junit.Assert;
import org.junit.Test;

/**
 * CountDownLatch Test
 */
public class CountDownLatchTest {

    @Test
    public void test() throws InterruptedException {
        final CountDownLatch latch = new MyCountDownLatch(1);

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
}
