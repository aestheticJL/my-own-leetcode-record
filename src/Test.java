public class Test implements Comparable{
    public static void main(String[] args) {
        boolean[] b = new boolean[1];
        System.out.println(b[0]);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
