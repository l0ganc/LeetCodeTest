import java.util.Scanner;

public class DiverseDeputation {


    private static int getRes(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (m < 2 && n < 2) {
            return 0;
        }

        if (m < 2 && n > 2) {
            return (int) comb(n, 2);
        }

        if (n < 2 && m > 2) {
            return (int) comb(m, 2);
        }

        return (int) (comb(m, 1) * comb(n, 2) + comb(m, 2) * comb(n, 1));

    }
    private static long comb(int m,int n){
        if(n==0)
            return 1;
        if (n==1)
            return m;
        if(n>m/2)
            return comb(m,m-n);
        if(n>1)
            return comb(m-1,n-1)+comb(m-1,n);
         return -1; //通过编译需要，数字无实际意义
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("please input m : ");
        int m = sc.nextInt();

        System.out.print("please input n : " );
        int n = sc.nextInt();

        System.out.println("result is : " + getRes(m, n));

    }


}
