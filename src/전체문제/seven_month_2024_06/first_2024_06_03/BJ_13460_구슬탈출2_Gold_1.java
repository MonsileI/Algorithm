package 전체문제.seventh_month_2024_06.first_2024_06_03;

import java.util.*;
import java.io.*;
public class BJ_13460_구슬탈출2_Gold_1 {
    static int[]tmp;
    static int N,M;
    static char[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int answer = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int ri=0; int rj=0; int bi=0; int bj=0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='R'){
                    ri = i ; rj = j;
                    map[i][j] = '.';
                }
                if(map[i][j]=='B'){
                    bi = i ; bj = j;
                    map[i][j] = '.';
                }
            }
        }
        for(int i=0;i<4;i++) dfs(i,1,ri,rj,bi,bj); //방향, depth
        System.out.println(answer==987654321 ? -1 : answer);
    }
    static void dfs(int d,int depth,int ri,int rj,int bi,int bj){
        if(depth>=answer) return;
        if(depth>10) return;
        int cri= ri; int crj=rj;
        boolean goal = false;
        while(true){
            int ni = cri + move[d][0];
            int nj = crj + move[d][1];
            if(map[ni][nj]=='#') break;
            if(map[ni][nj]=='O'){
                goal = true;
                cri = ni;
                crj = nj;
                break;
            }
            cri = ni; crj = nj;
        }
        int cbi = bi; int cbj = bj;
        while(true){
            int ni  = cbi + move[d][0];
            int nj = cbj + move[d][1];
            if(map[ni][nj]=='#') break;
            if(map[ni][nj]=='O') return;
            cbi = ni; cbj = nj;
        }
        if(cri==cbi && crj==cbj){
            if(d==0){
                if(ri<bi) cbi++;
                else cri++;
            }else if(d==1){
                if(rj<bj) crj--;
                else cbj--;
            }else if(d==2){
                if(ri>bi) cbi--;
                else cri--;
            }else{
                if(rj<bj) cbj++;
                else crj++;
            }
        }

        if(cri==ri&&crj==rj && cbi == bi && cbj == bj) return;
        if(goal){
            answer = depth;
            return;
        }
        for(int i=0;i<4;i++){
            if(i==d) continue;
            dfs(i,depth+1,cri,crj,cbi,cbj); //방향, depth
        }
    }
}
