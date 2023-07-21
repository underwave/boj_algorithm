package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class mazeBfs {
    static int n,m;
    private static boolean[][] visited;

    static Queue<Spot> q= new LinkedList<>();

    static int[] dx = {1,-1,0,0};
    static int[] dy= {0,0,1,-1};

    static int[][] arr,distance;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        Spot start=null;
        arr= new int[n][m];
        distance= new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray(); // 지도를 작성
            if(start==null){
                for (int j = 0; j < m; j++) {
                    if (arr[i][j]== 2){
                        start = new Spot(i,j);
                        break;
                    }
                }
            }
        }
        bfs(start);
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j]==1&&distance[i][j]==0) System.out.print(-1+" ");
                else System.out.print(distance[i][j]+ " ");
            }
            System.out.println();
        }

    }


    public static void bfs(Spot start){
        q.add(start);
        visited[start.x][start.y] = true;
        while(!q.isEmpty()) {
            Spot rear = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = rear.x + dx[i];
                int nextY = rear.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (arr[nextX][nextY] == 0) continue;
                if (visited[nextX][nextY]) continue;

                q.add(new Spot(nextX, nextY));
                distance[nextX][nextY] = distance[rear.x][rear.y] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }


    private static class Spot{
        private int x;
        private int y;

        public Spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}


