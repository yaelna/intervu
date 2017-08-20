
public class MyNumber implements Comparable<MyNumber>{

    private int n;

    public MyNumber(int n) {
        this.n = n;
    }

    public int compareTo(MyNumber o) {
        return n - o.n;
    }
}
