package 전체문제2026.June.Seventeenth;

import java.util.*;
import java.io.*;
public class SWEA_4013_특이한자석  {
    static int N;
    static int M;
    static int[][]top;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        N = 4; M = 8;
        for(int t=1;t<=TC;t++){
            int K = Integer.parseInt(br.readLine());
            top = new int[N][M];
            for(int i=0;i<N;i++){
                st=  new StringTokenizer(br.readLine()," ");
                for(int j=0;j<M;j++){
                    top[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine()," ");
                int num = Integer.parseInt(st.nextToken())-1;
                int action = Integer.parseInt(st.nextToken());
                visited = new boolean[N];
                visited[num] = true;
                calc(num,action);
            }
            int answer = 0;
            for(int i=0;i<N;i++){
                if(top[i][0]==1) answer += (int)Math.pow(2,i);
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void calc(int node, int action){

        int leftNode = node-1;
        int rightNode = node+1;

        if(-1<leftNode){
            if(!visited[leftNode]){
                if(top[leftNode][2]!=top[node][6]){
                    visited[leftNode] = true;
                    calc(leftNode,action * -1);
                }
            }
        }
        if(rightNode<4){
            if(!visited[rightNode]){
                if(top[node][2]!=top[rightNode][6]){
                    visited[rightNode] = true;
                    calc(rightNode,action * -1);
                }
            }
        }
        //정방향
        if(action==1){
            int last = top[node][7];
            for(int i=M-1;0<i;i--){
                top[node][i] = top[node][i-1];
            }
            top[node][0] = last;
        }else{
            int first = top[node][0];
            for(int i=0;i<M-1;i++){
                top[node][i] = top[node][i+1];
            }
            top[node][7] = first;
        }

    }
}
