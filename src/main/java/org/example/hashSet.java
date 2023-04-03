package org.example;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class hashSet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
//        List<String> N = new ArrayList<>();
//        hashSet 사용
        Set<String> N = new HashSet<>();
        List<String> M = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            N.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            String s= br.readLine();
            if((N.contains(s))){
                M.add(s);
            }
        }

        System.out.println(M.size());
        M.sort(Comparator.naturalOrder());
        for (String s : M) {
            System.out.println(s);
        }
    }
}
