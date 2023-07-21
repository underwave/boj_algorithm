package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class dijkstra {
    static List<Node>[] graph;
    static int[] dist;
    static int v,e,s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ve = br.readLine().split(" ");
        v = Integer.parseInt(ve[0]);
        e = Integer.parseInt(ve[1]);
        s = Integer.parseInt(br.readLine());
        dist= new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        graph= new ArrayList[v+1];
        for (int i = 1; i <=v ; i++) {
            graph[i]= new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < e; i++) {
            st= new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[n1].add(new Node(n2,weight));
        }

        dijkstra(s);
        for (int i = 1; i < dist.length; i++) {
            System.out.println(dist[i]!=Integer.MAX_VALUE?dist[i]:"INF");

        }

    }

    static void dijkstra(int s){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(s,0));
        boolean[] fix = new boolean[v+1];
        dist[s] = 0;

        while(!q.isEmpty()){
            Node rear = q.poll();
            int cur = rear.end;
            if (fix[cur]) continue;
            fix[cur] = true;

            for (Node node : graph[cur]) {
                if(dist[node.end]> dist[cur]+node.weight) {
                    dist[node.end] = dist[cur] + node.weight;
                    q.add(new Node(node.end, dist[node.end]));
                }
            }

        }
    }
}
class Node implements Comparable<Node>{
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}