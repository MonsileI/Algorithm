package 전체문제2025.September.Ninth;

import java.util.*;
import java.io.*;
public class BJ_6087_레이저통신_Gold_3 {

    static class Node implements Comparable<Node>{
        int i; int j; int dir; int weight;

        public Node(int i, int j, int dir, int weight) {
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static int N,M;
    static char[][]map;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int si =-1;
        int sj =-1;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='C'){
                    if(si==-1){
                        si = i;
                        sj = j;
                    }
                }
            }
        }

        int answer = dijk(si,sj);
        System.out.println(answer);
    }
    static int dijk(int si, int sj){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][]cntMap = new int[N][M];
        for(int i=0;i<N;i++) Arrays.fill(cntMap[i],Integer.MAX_VALUE);
        pq.offer(new Node(si,sj,-1,0));
        int answer = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int i = cur.i;
            int j = cur.j;
            int dir = cur.dir;
            int weight = cur.weight;
            if (weight > cntMap[i][j]) continue;
            if(map[i][j]=='C'){
                if(i!=si || j!=sj) {
                    answer = weight;
                    break;
                }
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj||map[ni][nj]=='*') continue;
                if(d!=dir && dir != -1){
                    if(cntMap[ni][nj] > weight+1){
                        cntMap[ni][nj] = weight+1;
                        pq.offer(new Node(ni,nj,d,weight+1));
                    }
                }else{
                    if(cntMap[ni][nj] >= weight){
                        cntMap[ni][nj] = weight;
                        pq.offer(new Node(ni,nj,d,weight));
                    }
                }
            }

        }
        return answer;
    }
}
