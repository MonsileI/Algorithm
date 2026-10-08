package 전체문제2026.October.Fourth;

import java.util.*;
import java.io.*;
public class SWEA_1232_사칙연산_D4 {

    static class Node {

        int idx;

        int leftChild;
        int rightChild;

        int numValue;
        char opValue;

        public Node(int idx, int leftChild, int rightChild, int numValue, char opValue) {
            this.idx = idx;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.numValue = numValue;
            this.opValue = opValue;
        }
    }
    static List<Node> list;
    static char[]op = {'+','-','*','/'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;
        StringBuilder sb= new StringBuilder();
        int TC = 10;
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            list.add(new Node(0,1,1,-1,'x')); //head node
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                int node = Integer.parseInt(st.nextToken());
                String next = st.nextToken();
                if(next.equals("+") || next.equals("-") || next.equals("*") || next.equals("/")){
                    int left = Integer.parseInt(st.nextToken());
                    int right = Integer.parseInt(st.nextToken());
                    list.add(new Node(node,left,right,-1,next.charAt(0)));
                }else{
                    list.add(new Node(node,-1,-1,Integer.parseInt(next),'x'));
                }
            }
            int answer = dfs(1);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static int dfs(int node){
        Node cur = list.get(node);
        int sum = 0;
        if(cur.opValue!='x'){
            switch (cur.opValue){
                case '+' : sum = dfs(cur.leftChild) + dfs(cur.rightChild);
                    break;
                case '-' : sum = dfs(cur.leftChild) - dfs(cur.rightChild);
                    break;
                case '*' : sum = dfs(cur.leftChild) * dfs(cur.rightChild);
                    break;
                case '/' : sum = dfs(cur.leftChild) / dfs(cur.rightChild);
                    break;
            }
        }else{
            return cur.numValue;
        }
        return sum;
    }
}
