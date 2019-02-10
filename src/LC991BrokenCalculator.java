public class LC991BrokenCalculator {
    public static int brokenCalc(int X, int Y) {
        int res = 0;
        if (X < Y) {
            while (X != Y) {
                if (X * 2 - 1 == Y) {
                    res += 2;
                    break;
                } else if (X * 2 - 1 > Y) {
                    X--;
                    res++;
                    if (X * 2 == Y) {
                        res++;
                        break;
                    }
                } else if (X * 2 - 1 < Y){
                    X *= 2;
                    res++;
                }
            }
        } else {
            res += (X - Y);
        }

        return res;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 1000000000;
        System.out.println(brokenCalc(x, y));
    }
}
