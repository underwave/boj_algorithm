package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CoordinateCompression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr, sorted;
//        arr = sorted = new int[n];
//        같은 참조 가지게됨
        arr = new int[n];
        sorted = new int[n];

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st= new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sorted);

        int rank=0;
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(sorted[i]))
                map.put(sorted[i],rank++);
        }

//        시간이 많이 소요되어 여러 방법 시도 후 sb 이용 통해 정답
        StringBuilder sb = new StringBuilder();

        for (int x : arr) {
            sb.append(map.get(x)).append(' ');
        }
        System.out.println(sb);
    }
}
