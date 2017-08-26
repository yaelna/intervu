
/**
 * TODO implement abstract methods of CountDownLatch
 */
public class MyCountDownLatch implements ICountDownLatch {

    /** Constructs a CountDownLatch initialized with the given count. */
    MyCountDownLatch(int count) {
        //TODO implement
    }

    @Override
    public void await() throws InterruptedException {
        //TODO implement
    }

    @Override
    public boolean await(long timeout) throws InterruptedException {
        return false; //TODO implement
    }

    @Override
    public void countDown() {
        //TODO implement
    }

    @Override
    public int getCount() {
        return -1; //TODO implement
    }
}
