import java.util.concurrent.atomic.AtomicInteger;

/**
 * TODO implement abstract methods of CountDownLatch
 */
public class MyCountDownLatch implements ICountDownLatch {

    private final Object o = new Object();
    private final AtomicInteger count;

    /** Constructs a CountDownLatch initialized with the given count. */
    MyCountDownLatch(int count) {
        //TODO implement
        this.count = new AtomicInteger(count);
    }

    @Override
    public void await() throws InterruptedException {
        //TODO implement
        synchronized (o) {
            while (count.get() > 0) {
                o.wait();
            }
        }
    }

    @Override
    public boolean await(long timeout) throws InterruptedException {
        //TODO implement
        long end = timeout + System.currentTimeMillis();
        synchronized (o) {
            while (count.get() > 0) {
                long leftTime = end - System.currentTimeMillis();
                if (leftTime <= 0) return false;
                o.wait(leftTime);
            }
        }
        return  (count.get() == 0);
    }

    @Override
    public void countDown() {
        if (count.get() > 0) {
            int i = count.decrementAndGet();
            if (i == 0) {
                synchronized (o) {
                    o.notifyAll();
                }
            }
        }
    }

    @Override
    public int getCount() {
        return count.get();
    }
}
