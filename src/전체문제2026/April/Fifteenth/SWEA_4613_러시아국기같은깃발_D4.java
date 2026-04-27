package 전체문제2026.April.Fifteenth;

import java.util.*;
import java.io.*;
public class SWEA_4613_러시아국기같은깃발_D4 {
    static int N,M;
    static char[][]map;
    static int answer;
    static int INF = Integer.MAX_VALUE;
    static int[]tmp;
    static char[]color = {'W','B','R'};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
            answer = INF;
            tmp = new int[3];
            tmp[0]++;tmp[1]++;tmp[2]++;
            dfs(N-3,0);
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void calc(){
        int sum = 0;

        int idx = 0;
        for(int t=0;t<3;t++){
            int range = idx+tmp[t];
            for(int i=idx;i<range;i++) {
                for(int j=0;j<M;j++){
                    if(answer<=sum) return;
                    if(color[t]!=map[i][j]) sum++;
                }
            }
            idx += tmp[t];
        }
        answer = Math.min(answer,sum);
    }
    static void dfs(int depth,int start){
        if(depth==0){
            calc();
            return;
        }
        for(int i=start;i<3;i++){
            for(int j=1;j<=depth;j++){
                tmp[i] += j;
                dfs(depth - j,(i+1));
                tmp[i] -= j;
            }
        }
    }
}
