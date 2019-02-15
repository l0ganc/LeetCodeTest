package Cohesity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定目标金额和一个menu（物品可重复，不同物品金额可以相同），
 * 打印出所有可能的组合（等于目标金额，dfs），
 *
 * follow up问了打印出所有可以购买的组合（小于目标金额也可以）
 */
public class CombinationSum {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));

    }


    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j] + (j >= coins[i - 1] ? dp[i][j - coins[i - 1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }






}
