package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class dfsFindRoot {
    static int n;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree= new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken())-1;
            int v = Integer.parseInt(st.nextToken())-1;
            tree[u].add(v);
            tree[v].add(u);
        }


        parent= new int[n];
        visited= new boolean[n];
        dfs(0);


//        for (List<Integer> integers : tree) {
//            for (Integer integer : integers) {
//                System.out.print(integer+" ");
//            }
//            System.out.println();
//        }
        for (int i = 1; i <n ; i++) {
            System.out.println(parent[i]);
        }
    }
    static int[] parent;
    static boolean[] visited;

    private static void dfs(int x){
        visited[x] = true;
        for (Integer i : tree[x]) {
            if(!visited[i]) {
                parent[i]= x+1;
                dfs(i);
            }

        }
    }

}
