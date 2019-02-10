public class LC991BrokenCalculator {
    public static int brokenCalc(int X, int Y) {
        int res = 0;
        while (Y > X) {
            if (Y % 2 == 1) {
                Y++;
            } else {
                Y /= 2;
            }
            res++;
        }
        return res + X - Y;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 1000000000;
        System.out.println(brokenCalc(x, y));
    }
}
