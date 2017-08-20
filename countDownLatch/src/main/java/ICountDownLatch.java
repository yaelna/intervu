import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch overview
 *
 * A synchronization aid that allows a set of threads to all wait for each other
 * to reach a common bridge point.
 *
 * CountDownLatchs are useful in programs involving a fixed sized party of threads
 * that must occasionally wait for each other.
 */
public interface ICountDownLatch {

    /**
     * Causes the current thread to wait until the latch has counted down to zero,
     * unless the thread is interrupted.
     *
     * @throws InterruptedException if the current thread is interrupted while waiting
     */
    abstract public void await() throws InterruptedException;

    /**
     * Causes the current thread to wait until the latch has counted down to zero,
     * unless the thread is interrupted, or the specified waiting time elapses.
     *
     * @param timeout the maximum time to wait in milliseconds
     * @return {@code true} if the count reached zero and {@code false}
     *         if the waiting time elapsed before the count reached zero
     * @throws InterruptedException if the current thread is interrupted
     *         while waiting
     */
    abstract public boolean await(long timeout) throws InterruptedException;

    /**
     * Decrements the count of the latch, releasing all waiting threads if
     * the count reaches zero.
     *
     * If the current count is greater than zero then it is decremented.
     * If the new count is zero then all waiting threads are re-enabled for
     * thread scheduling purposes.
     *
     * If the current count equals zero then nothing happens.
     */
    abstract public void countDown();

    /**
     * @return the current count.
     */
    abstract public int getCount();
}
