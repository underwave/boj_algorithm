package org.example;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinHeap {
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0)
                System.out.println(minHeap.isEmpty()?0:minHeap.poll());

            else
                minHeap.add(x);


        }
    }
}
