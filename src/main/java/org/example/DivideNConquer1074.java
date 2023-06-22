package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class DivideNConquer1074 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int row= Integer.parseInt(st.nextToken());
        int col= Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        divide(size ,row,col);
        System.out.println(cnt);
    }

    private static void divide(int n,int row, int col){
        int newSize = n/2;
        if (n==1)
            return;
        if (row<newSize){
//          2사분면
            if(col<newSize) {
                divide(newSize,row, col);
//          1사분면
            } else{
                cnt+= (n*n)/4;
                divide(newSize,row, col - newSize);
            };
        } else{
//            3사분면
            if(col<newSize) {
                cnt+= n*n/4*2;
                divide(newSize ,row - newSize, col);
//          4사분면
            } else {
//                (n*n*3) -> Integer overFlow, /4 먼저 해줘야함
                cnt+= (n*n)/4*3;
                divide(newSize, row - newSize, col - newSize);
            }
        }

    }
}
