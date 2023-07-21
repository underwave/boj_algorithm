package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class treeTraversal {
    static List<Character>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree= new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            tree[a-'A'].add(st.nextToken().charAt(0));
            tree[a-'A'].add(st.nextToken().charAt(0));
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }

    static void preorder(int i){
        System.out.print((char)(i+'A'));
        if(tree[i].get(0)!= '.')
            preorder(tree[i].get(0)- 'A');
        if(tree[i].get(1)!= '.')
            preorder(tree[i].get(1)- 'A');
    }

    static void inorder(int i){
        if(tree[i].get(0)!='.')
            inorder(tree[i].get(0)-'A');
        System.out.print((char) (i + 'A'));
        if(tree[i].get(1)!= '.')
            inorder(tree[i].get(1)-'A');
    }

    static void postorder(int i){
        if(tree[i].get(0)!= '.')
            postorder(tree[i].get(0)- 'A');
        if(tree[i].get(1)!= '.')
            postorder(tree[i].get(1)- 'A');
        System.out.print((char)(i+'A'));

    }
}