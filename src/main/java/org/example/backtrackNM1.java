package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class backtrackNM1 {

    public static int[] arr;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        arr= new int[m];
        visit= new boolean[n];


        dfs(n,m,0);
    }

    public static void dfs(int n, int m, int depth){
        if(depth == m){
            for (int i : arr) {
                System.out.print(i+ " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n ; i++) {
            if(!visit[i]){
                visit[i]= true;
                arr[depth] = i+1;
                dfs(n,m,depth+1);
                visit[i] = false;
            }
        }
    }
}