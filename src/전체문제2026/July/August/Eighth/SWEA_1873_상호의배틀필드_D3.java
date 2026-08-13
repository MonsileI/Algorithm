package 전체문제2026.July.August.Eighth;

import java.util.*;
import java.io.*;
public class SWEA_1873_상호의배틀필드_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        char[]header = {'^','>','v','<'};
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            char[][]map = new char[N][M];
            int d = 0;
            int ci = 0; int cj = 0;
            for(int i=0;i<N;i++){
                String str = br.readLine();
                for(int j=0;j<M;j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j]=='^'||map[i][j]=='>' || map[i][j]=='v' || map[i][j] =='<'){
                        switch (map[i][j]){
                            case '^' : d =0;
                            break;
                            case '>': d =1;
                            break;
                            case 'v' : d=2;
                            break;
                            case '<' : d=3;
                            break;
                        }
                        map[i][j] = '.';
                        ci = i; cj = j;
                    }
                }
            }
            int Query = Integer.parseInt(br.readLine());
            char[] qArr = br.readLine().toCharArray();
            for(char ch : qArr){
                if (ch == 'S') {
                    int ni = ci + move[d][0];
                    int nj = cj + move[d][1];
                    while(true){
                        if(!rangeCheck(ni,nj,N,M)) break;
                        if(map[ni][nj]=='#') break;
                        if(map[ni][nj]=='*'){
                            map[ni][nj] = '.';
                            break;
                        }
                        ni += move[d][0];
                        nj += move[d][1];
                    }
                    continue;
                }
                if(ch=='U') d = 0;
                else if(ch=='R') d= 1;
                else if(ch=='D') d= 2;
                else if(ch=='L') d= 3;
                int ni = ci + move[d][0];
                int nj = cj + move[d][1];
                if(!rangeCheck(ni,nj,N,M)) continue;
                if(map[ni][nj]=='.') {
                    ci = ni;
                    cj = nj;
                }
            }
            map[ci][cj] = header[d];
            sb.append("#"+t+" ");
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static boolean rangeCheck(int i,int j,int N,int M){
        if(N-1<i||M-1<j||i<0||j<0) return false;
        return true;
    }
}
