package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class TreeMap7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> dq = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());

                char c = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if(c == 'I') {
                    dq.put(n,dq.getOrDefault(n,0)+1);
                }
                else if(dq.isEmpty())
                    continue;
                else if(c == 'D') {
                    int key = n==1 ?dq.lastKey():dq.firstKey();
                    int count = dq.get(key);

                    if(count == 1)
                        dq.remove(key);
                    else
                        dq.put(key,count-1);
                }
            }
            if(dq.isEmpty())
//                empty, EMPTY 소, 대문자 차이 떄문에 한시간 정도 날린거같은데;
                sb.append("EMPTY\n");
            else
                sb.append(dq.lastKey())
                        .append(" ")
                        .append(dq.firstKey())
                        .append("\n");
        }
        System.out.println(sb);
    }
}