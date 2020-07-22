public class Test {
    volatile static int a = 0;

    public static void main(String[] args) {
        int b = a;
        a++;
        System.out.println(b);
    }
}
