package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class dpLIS1 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] dp = new int[n];
        A =  Arrays.stream(br.readLine().split(" "))

                .mapToInt(x-> Integer.parseInt(x))
                .toArray();
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(A[i]>A[j]&&dp[i]<=dp[j])
                    dp[i]+=1;
            }
            ans = Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}