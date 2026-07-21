package 전체문제2026.July.Ninth;

import java.util.*;
import java.io.*;
public class SWEA_2382_미생물격리 {
    static class Node {
        int i; int j; int size; int d;

        public Node(int i, int j, int size, int d) {
            this.i = i;
            this.j = j;
            this.size = size;
            this.d = d;
        }
    }
    public static void main(String[] args) throws Exception {
        /*
        1. 이동
        2. 겹치기 Queue + flag
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int[][]move = {{},{-1,0},{1,0},{0,-1},{0,1}}; //상 하 좌 우
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken()); //맵크기
            int M = Integer.parseInt(st.nextToken()); //break 조건 시간
            int K = Integer.parseInt(st.nextToken()); // 미생물 개수
            Queue<Node> q = new ArrayDeque<>();
            for(int c=0;c<K;c++){
                st = new StringTokenizer(br.readLine()," ");
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                q.offer(new Node(i,j,s,d));
            }
            while(0<M){
                //이동
                int qSize = q.size();
                for(int c=0;c<qSize;c++){
                    Node cur = q.poll();
                    int i = cur.i + move[cur.d][0];
                    int j = cur.j + move[cur.d][1];
                    int d = cur.d;
                    int s = cur.size;
                    boolean flag = false;
                    if(i==N-1) {
                        d = 1; flag = true;
                    }
                    if(i==0) {
                        d = 2; flag = true;
                    }
                    if(j==N-1) {
                        d = 3; flag = true;
                    }
                    if(j==0) {
                        d = 4; flag = true;
                    }
                    if(flag){
                        s /= 2;
                    }
                    if(0 < s){
                        q.offer(new Node(i,j,s,d));
                    }
                }
                //합치기
                qSize = q.size();
                for(int c=0;c<qSize;c++){
                    Node cur = q.poll();
                    int i = cur.i; int j = cur.j; int d = cur.d; int s = cur.size;
                    //토탈 사이즈
                    int totalSize = s;
                    int maxSize = s;
                    int tqSize = q.size();
                    for(int cc=0;cc<tqSize;cc++){
                        Node other = q.poll();
                        if(other.i == i && other.j == j){
                            if(maxSize < other.size){
                                maxSize = other.size;
                                d = other.d;
                            }
                            totalSize += other.size;
                            //안넣어줌!
                        }else{
                            q.offer(new Node(other.i,other.j,other.size,other.d));
                        }
                    }
                    //다시 넣어주기
                    q.offer(new Node(i,j,totalSize,d));
                }
                M--;
            }
            //개수 세기
            int answer = 0;
            while(!q.isEmpty()){
                Node cur = q.poll();
                answer += cur.size;
            }
            sb.append("#"+t+" "+answer+"\n");
        }


        System.out.println(sb.toString());
    }
}
