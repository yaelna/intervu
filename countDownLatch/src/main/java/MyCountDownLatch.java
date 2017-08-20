/**
 * TODO implement abstract methods of CountDownLatch
 */
public class MyCountDownLatch implements ICountDownLatch {

    /** Constructs a CountDownLatch initialized with the given count. */
    public MyCountDownLatch(int count) {
        //TODO implement
    }

    @Override
    public void await() throws InterruptedException {
        //TODO implement
    }

    @Override
    public boolean await(long timeout) throws InterruptedException {
        //TODO implement
        return false;
    }

    @Override
    public void countDown() {
        //TODO implement
    }

    @Override
    public int getCount() {
        //TODO implement
        return -1;
    }
}
