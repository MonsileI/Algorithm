package 전체문제2026.October.Fifth;

import java.util.*;
import java.io.*;
public class SWEA_1231_중위순회_D4 {
    static class Node{
        char value;
        int leftNode;
        int rightNode;

        public Node(char value,int leftNode, int rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
    static List<Node> list;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();
        int TC = 10;
        for(int t=1;t<=TC;t++){
            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            list.add(new Node('-',0,0)); //루트
            for(int i=0;i<N;i++){
                st =new StringTokenizer(br.readLine()," ");
                int num = Integer.parseInt(st.nextToken());
                char v = st.nextToken().charAt(0);
                int left = -1; int right = -1;
                if(st.hasMoreTokens())  left = Integer.parseInt(st.nextToken());
                if(st.hasMoreTokens())  right = Integer.parseInt(st.nextToken());
                list.add(new Node(v,left,right));
            }
            sb.append("#"+t+" ");
            dfs(1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void dfs(int nodeIdx){
            Node cur = list.get(nodeIdx);
            if(cur.leftNode!=-1) dfs(cur.leftNode);
            sb.append(cur.value);
            if(cur.rightNode!=-1) dfs(cur.rightNode);

    }
}
