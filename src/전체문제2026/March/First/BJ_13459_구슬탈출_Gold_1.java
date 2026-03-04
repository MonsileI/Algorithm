package 전체문제2026.March.First;

import java.util.*;
import java.io.*;
public class BJ_13459_구슬탈출_Gold_1 {
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static char[][]map;
    static int N,M;
    static int gi,gj;
    static boolean flag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int ri = 0; int rj = 0;
        int bi = 0; int bj = 0;
        for(int i=0;i<N;i++) {
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='R'){
                    ri = i;
                    rj = j;
                    map[i][j] = '.';
                }
                if(map[i][j]=='B'){
                    bi = i;
                    bj = j;
                    map[i][j] = '.';
                }
                if(map[i][j]=='O'){
                    gi = i;
                    gj = j;
                    map[i][j] = '.';
                }
            }
        }
        for(int d=0;d<4;d++) {
            dfs(ri, rj, bi, bj, d,0);
        }
        //파란 구슬을 구멍에 넣지 않으면서 빨간 구슬을 10번 이하
        System.out.println(flag ? 1 : 0);
    }
    static void dfs(int ri,int rj, int bi,int bj, int d,int depth){
        if(10<depth) return;
        if(flag) return;
        //위쪽일땐 i가 더 작은것
        //오른쪽일 땐, 더 j가 큰 것
        //아래쪽일땐 i가 더 큰 것
        //왼쪽일 땐, 더 j가 작은것

        switch (d){
            case 0 :{
                if(ri<=bi){
                    int [] rc = moveRed(ri,rj,-1,-1,d);
                    ri = rc[0]; rj = rc[1];
                    int [] bc = moveBlue(ri,rj,bi,bj,d);
                    bi = bc[0]; bj = bc[1];
                }else{
                    int [] bc = moveBlue(-1,-1,bi,bj,d);
                    bi = bc[0]; bj = bc[1];
                    int [] rc = moveRed(ri,rj,bi,bj,d);
                    ri = rc[0]; rj = rc[1];
                }
            }
            break;
            case 1 :{
                if(bj<=rj){
                    int [] rc = moveRed(ri,rj,-1,-1,d);
                    ri = rc[0]; rj = rc[1];
                    int [] bc = moveBlue(ri,rj,bi,bj,d);
                    bi = bc[0]; bj = bc[1];
                }else{
                    int [] bc = moveBlue(-1,-1,bi,bj,d);
                    bi = bc[0]; bj = bc[1];
                    int [] rc = moveRed(ri,rj,bi,bj,d);
                    ri = rc[0]; rj = rc[1];
                }
            }
            break;
            case 2 : {
                if(bi<=ri){
                    int [] rc = moveRed(ri,rj,-1,-1,d);
                    ri = rc[0]; rj = rc[1];
                    int [] bc = moveBlue(ri,rj,bi,bj,d);
                    bi = bc[0]; bj = bc[1];
                }else{
                    int [] bc = moveBlue(-1,-1,bi,bj,d);
                    bi = bc[0]; bj = bc[1];
                    int [] rc = moveRed(ri,rj,bi,bj,d);
                    ri = rc[0]; rj = rc[1];
                }
            }
            break;
            case 3 : {
                if(rj<=bj){
                    int [] rc = moveRed(ri,rj,-1,-1,d);
                    ri = rc[0]; rj = rc[1];
                    int [] bc = moveBlue(ri,rj,bi,bj,d);
                    bi = bc[0]; bj = bc[1];
                }else{
                    int [] bc = moveBlue(-1,-1,bi,bj,d);
                    bi = bc[0]; bj = bc[1];
                    int [] rc = moveRed(ri,rj,bi,bj,d);
                    ri = rc[0]; rj = rc[1];
                }
            }
            break;
        }


        if(bi==gi && bj==gj) return;
        if(ri ==gi && rj == gj){
            flag = true;
            return;
        }
        for(int dir=0;dir<4;dir++){
            dfs(ri,rj,bi,bj,dir,depth+1);
        }
    }
    static int[] moveRed(int ri,int rj,int bi,int bj,int d){
        while(true){
            int ni = ri + move[d][0];
            int nj = rj + move[d][1];
            if(map[ni][nj]=='#') break;
            if(ni==gi && nj==gj){
                ri = ni;
                rj = nj;
                break;
            }
            if(bi!=-1){
                if(ni==bi&&nj==bj) break;
            }
            ri = ni;
            rj = nj;
        }
        return new int[]{ri,rj};
    }
    static int[] moveBlue(int ri,int rj,int bi,int bj,int d){
        while(true){
            int ni = bi + move[d][0];
            int nj = bj + move[d][1];
            if(map[ni][nj]=='#') break;
            if(ni==gi && nj==gj){
                bi = ni;
                bj = nj;
                break;
            }
            if(ri!=-1){
                if(ni==ri&&nj==rj) break;
            }
            bi = ni;
            bj = nj;
        }
        return new int[]{bi,bj};
    }
}
