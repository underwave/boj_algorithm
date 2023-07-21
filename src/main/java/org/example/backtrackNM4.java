package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class backtrackNM4 {

    public static int[] arr;
    public static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        arr= new int[m];
        dfs(1,0);
    }

    public static void dfs(int at, int depth){
        if(depth == m){
            for (int i : arr) {
                System.out.print(i+ " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i <=n ; i++) {
            arr[depth] = i;
            dfs(i,depth+1);
        }
    }
}