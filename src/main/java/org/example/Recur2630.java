package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Recur2630 {
    static int white=0;
    static int blue=0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr= new int [n][n];

        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine()," ");
            for (int j = 0; j <n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,n);

        System.out.println(white);
        System.out.println(blue);

    }

    private static void divide(int r ,int c, int n) {

        boolean check = colorCheck(r, c, n);
        if (check){
            if (arr[r][c]==0)
                white++;
            else
                blue++;
        } else{
            int size= n/2;
            divide( r, c, size);

            divide(r+size,c,size);

            divide(r,c+size,size);

            divide(r+size,c+size,size);
        }
    }

    private static boolean colorCheck(int r, int c, int n){
        int mark = arr[r][c];
        for (int i = r; i < r+n; i++) {
            for (int j = c; j <c + n; j++) {
                if (arr[i][j]!= mark)
                    return false;
            }
        }
        return true;
    }

}
