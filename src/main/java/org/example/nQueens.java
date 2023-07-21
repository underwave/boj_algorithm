package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class nQueens {
    static int[] board;
    static int n;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cnt=0;
        board = new int[n];
        move(0);
        System.out.println(cnt);
    }

    static void move(int depth){
        if (depth== n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[depth] = i;

            if(possibility(depth)){
                move(depth+1);
            }
        }

    }

    static boolean possibility(int depth){

        for (int i = 0; i < depth; i++) {
            if(board[i]== board[depth]) 
                return false;
            else if (Math.abs(board[depth]-board[i])== depth - i) {
                return false;
            }
        }
        return true;
    }
}