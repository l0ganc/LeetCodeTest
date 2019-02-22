package Mathworks;

public class GCD {

    public static int gcdfunc(int m,int n) {
        if (m < n) {
            int k = m;
            m = n;
            n = k;
        }
        if (m % n != 0) {
            int temp = m % n;
            return gcdfunc(n, temp);
        } else
            return n;
    }

    public static void main(String[] args) {
        System.out.println(gcdfunc(20, 5));
    }

}
