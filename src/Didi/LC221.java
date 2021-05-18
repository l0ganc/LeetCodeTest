package Didi;

public class LC221 {
    // 典型的dp题
    // dp[i][j] represents the length of the square which lower right corner is located at (i, j)
    // time - O(mn)
    // space = O(mn)

    /**
     matrix:
        1 0 1 0 0
        1 0 1 1 1
        1 1 1 1 1
        1 0 0 1 0

     dp:
      0 0 0 0 0 0
      0 1 0 1 0 0
      0 1 0 1 1 1
      0 1 1 1 2 2
      0 1 0 0 1 0
     */

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int[][] dp = new int[matrix.length + 1][matrix[0].length];
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        return max * max;
    }

}
