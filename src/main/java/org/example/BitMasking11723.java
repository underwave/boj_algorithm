package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BitMasking11723 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Boolean[] list= new Boolean[20];
        Arrays.fill(list,false);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st= new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("all"))
                for (int j = 0; j <20; j++) {list[j]= true;}
            else if(s.equals("empty"))
                for (int j = 0; j <20; j++) {list[j]= false;}
            else {
                int n = Integer.parseInt(st.nextToken());
                if(s.equals("add"))
                    list[n-1]=true;
                else if (s.equals("remove"))
                    list[n-1]= false;
                else if(s.equals("check"))
                    sb.append(list[n-1]?1:0).append("\n");
                else if(s.equals("toggle"))
                    list[n-1] = list[n-1]?false: true;
            }
        }
        System.out.println(sb);
    }
}