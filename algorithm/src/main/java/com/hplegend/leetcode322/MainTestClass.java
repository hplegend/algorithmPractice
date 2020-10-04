package com.hplegend.leetcode322;

/**
 * @author hp.he
 * @date 2020/10/4 16:19
 */
public class MainTestClass {

    public static void main(String[] args) {

        Leetcode322 leetcode322 = new Leetcode322();

        int[] coins = new int[]{1, 3};
        int amount = 11;

        int minCoins = leetcode322.oridinaryRecuersive(coins, amount);

        System.out.println(minCoins);

        minCoins = leetcode322.tableRecuersive(coins, amount);

        System.out.println(minCoins);

        minCoins = leetcode322.dp(coins, amount);

        System.out.println(minCoins);

    }

}
