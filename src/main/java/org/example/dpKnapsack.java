package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class dpKnapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            String[] wv = br.readLine().split(" ");
            int w  = Integer.parseInt(wv[0]);
            int v = Integer.parseInt(wv[1]);
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if (j-w>=0)  dp[i][j] = Math.max(dp[i][j],dp[i-1][j-w]+v);
            }
        }
        System.out.println(dp[n][k]);
    }
}