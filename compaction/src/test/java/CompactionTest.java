import org.junit.Assert;
import org.junit.Test;

public class CompactionTest {

    @Test //no compaction
    public void test_no_compaction() {
        int[] source = new int[] {1,2,3,4,5,0};
        int[] expected = new int[] {1,2,3,4,5,0};
        Compaction.compact(source);
        assertEquals(expected, source);
    }

    @Test //full compaction
    public void test_full_compaction() {
        int[] source = new int[] {1,1,1,1,1,1,0};
        int[] expected = new int[] {1,0};
        Compaction.compact(source);
        assertEquals(expected, source);
    }

    @Test //single compaction
    public void test_single_compaction() {
        int[] source = new int[] {3,1,1,5,5,1,8,9,9,0};
        int[] expected = new int[] {3,1,5,5,1,8,9,9,0};
        Compaction.compact(source);
        assertEquals(expected, source);
    }

    @Test //double compaction
    public void test_double_compaction() {
        int[] source = new int[] {1,1,1,3,5,5,1,1,1,2,0};
        int[] expected = new int[] {1,3,5,5,1,2,0};
        Compaction.compact(source);
        assertEquals(expected, source);
    }

    @Test //triple compaction
    public void test_triple_compaction() {
        int[] source = new int[] {4,1,1,1,1,3,1,1,2,1,1,1,0};
        int[] expected = new int[] {4,1,3,1,2,1,0};
        Compaction.compact(source);
        assertEquals(expected, source);
    }

    private void assertEquals(int[] expected, int[] actual) {
        for (int i=0; i<expected.length; i++) {
            if (i >= actual.length) {
                Assert.fail("Expected: " + expected[i] + " actual: out of bounds");
            }
            Assert.assertEquals(expected[i], actual[i]);
        }
    }
}
