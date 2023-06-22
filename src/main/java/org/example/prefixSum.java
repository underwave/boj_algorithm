package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class prefixSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        String[] s = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] prefixSum = new int[N];
        prefixSum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i]= prefixSum[i-1]+ arr[i];
        }

        for (int i = 0; i < M; i++) {
            String[] s1 = br.readLine().split(" ");
            int from = Integer.parseInt(s1[0])-1;
            int to = Integer.parseInt(s1[1])-1;

            if (from == 0)
                System.out.println(prefixSum[to]);
            else
                System.out.println(prefixSum[to]- prefixSum[from-1]);
        }
    }
}


