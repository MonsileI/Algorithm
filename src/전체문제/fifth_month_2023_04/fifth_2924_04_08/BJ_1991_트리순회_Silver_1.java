package 전체문제.fifth_month_2023_04.fifth_2924_04_08;

import java.util.*;
import java.io.*;
public class BJ_1991_트리순회_Silver_1 {
    static class Node{
        char head; Node left; Node right;

        public Node(char head) {
            this.head = head;
        }

        public Node(char head, Node left, Node right) {
            this.head = head;
            this.left = left;
            this.right = right;
        }

        void insert(Node node,char head,char left,char right){
            if(node.head==head){
                if(left=='.') node.left = null;
                else node.left = new Node(left);
                if(right=='.') node.right = null;
                else node.right = new Node(right);
            }else{
                if(node.left!=null) insert(node.left,head,left,right);
                if(node.right!=null) insert(node.right,head,left,right);
            }

        }
    }
    static int N;
    static Node root = new Node('A');
    static StringBuilder sb=  new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            char head = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            root.insert(root,head,left,right);
        }
        fir(root);
        sb.append("\n");
        sec(root);
        sb.append("\n");
        thir(root);
        System.out.println(sb.toString());
    }
    static void fir(Node head){
        if(head==null) return;
        sb.append(head.head);
        fir(head.left);
        fir(head.right);
    }
    static void sec(Node head){
        if(head==null) return;
        sec(head.left);
        sb.append(head.head);
        sec(head.right);
    }
    static void thir(Node head){
        if(head==null) return;
        thir(head.left);
        thir(head.right);
        sb.append(head.head);
    }
}
