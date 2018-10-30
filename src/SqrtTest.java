public class SqrtTest {
    static double sqrt(double t, Double precise) {
        double low = 0;
        double high = t;
        double middle, squre;
        double prec = precise != null ? precise : 1e-7;

        if (t < 0) {
            System.out.println("%%%%%");
        }

        while (high - low > prec) {
            middle = (low + high) / 2;
            squre = middle * middle;

            if (squre > t) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return (low + high) / 2;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(9, null));
    }
}
