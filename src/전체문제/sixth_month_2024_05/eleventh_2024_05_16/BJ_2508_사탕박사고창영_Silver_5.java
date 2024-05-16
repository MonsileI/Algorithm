package 전체문제.sixth_month_2024_05.eleventh_2024_05_16;

import java.util.*;
import java.io.*;
public class BJ_2508_사탕박사고창영_Silver_5 {
    static int N,M;
    static char[][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=0;t<TC;t++){
            br.readLine();
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
            int ans = 0;
            boolean[][]visited=  new boolean[N][M];
            //가로체크
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]=='o'){
                        if(j==0||j==M-1) continue;
                        if(map[i][j-1]!='>' || map[i][j+1]!='<') continue;
                        ans++;
                        visited[i][j] = true;
                    }
                }
            }
            //세로체크
            for(int j=0;j<M;j++){
                for(int i=0;i<N;i++){
                    if(map[i][j]=='o'){
                        if(i==0||i==N-1) continue;
                        if(map[i-1][j]!='v' || map[i+1][j]!='^') continue;
                        if(visited[i][j]) continue;
                        ans++;
                        visited[i][j] = true;
                    }
                }
            }
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString());
    }
}
