/**
 * TODO implement abstract methods of CountDownLatch
 */
public class MyCountDownLatch extends CountDownLatch {

    /** Constructs a CountDownLatch initialized with the given count. */
    public MyCountDownLatch(int count) {
    }

    @Override
    public void await() throws InterruptedException {
    }

    @Override
    public boolean await(long timeout) throws InterruptedException {
        return false;
    }

    @Override
    public void countDown() {
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("not implemented yet");
    }
}
