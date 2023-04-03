package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CoordinateCompressionBySet{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr;
        arr = new int[n];
        Set<Integer> set= new TreeSet<>();
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }



        Map<Integer, Integer> map = new HashMap<>();
        Iterator<Integer> iter = set.iterator();


        for (int i = 0; i < set.size(); i++) {
            map.put(iter.next(),i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <n ; i++) {
            sb.append(map.get(arr[i])).append(' ');
        }
        System.out.println(sb);


    }
}
