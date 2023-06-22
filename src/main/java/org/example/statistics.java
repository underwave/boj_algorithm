package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class statistics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        List<Integer> list= new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        double sum=0;
        for (Integer integer : list) {
            sum+= integer;
        }

        int mean;
        if(sum<0){
            mean = (int) (Math.round(Math.abs(sum)/size)*-1);
        }else{
            mean = (int) Math.round(sum/size);
        }



        int median;
        if (size%2 ==0){
            median = (list.get(size/2)+ list.get((size/2)-1))/2;
        }else{
            median = list.get(size/2);
        }

        int mode ;
        Map<Integer,Integer> counter = new HashMap<>();
        for (Integer integer : list) {
            if(counter.containsKey(integer))
                counter.put(integer,counter.get(integer)+1);
            else {
                counter.put(integer,1);
            }
        }
        ArrayList<Integer> modes = new ArrayList<>();
        int max = Collections.max(counter.values());
        for (Integer integer : counter.keySet()) {
            if (counter.get(integer).equals(max))
                modes.add(integer);
        }
        Collections.sort(modes);
        if (modes.size()==1){
            mode = modes.get(0);
        }else {
            mode = modes.get(1);
        }


        int range = list.get(size - 1) - list.get(0);


        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}


