package DrawDridge;

/**
 * 输入长度n，输出只用aeiou组成的满足特定规则的不同string个数，mod（10^9 + 7）。
 * 特定规则：
 * "a" must only be followed by "e".
 * "e" must only be followed by "a" or "i".
 * "i" must only be followed by "a", "e", "o", or "u".
 * "o" must only be followed by "i" or "u".
 * "u" must only be followed by "a".
 *
 * 1 < n < 105
 */
public class MagicalString {
    public static int numOfCombStr(int n) {
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;
        for (int x = 1; x < n; x++) {
            int at = e;
            int et = a + i;
            int it = a + e + o + u;
            int ot = i + u;
            int ut = a;
            a = at;
            e = et;
            i = it;
            o = ot;
            u = ut;
        }
        return (a + e + i + o + u);
    }
}
