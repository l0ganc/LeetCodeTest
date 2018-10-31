import java.util.Scanner;

public class HeavyWaterOA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("please input your number : ");
        int num = sc.nextInt();
        System.out.println(num >> 4);
        System.out.println("4th bit of " + num + " is " + ((num >> 3) & 1));
    }
}
