package zijie;

public class Main {
    public static void main(String[] args) {
        String a = new String("ab");
        String b = new String("ab");
        String aa = "ab";
        String bb = "ab";
        System.out.println(aa == bb);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(42 == 42.0);
    }
}
