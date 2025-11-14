package 전체문제2025.November.Fifth;

import java.util.*;
import java.io.*;
public class BJ_15683_감시_Gold_3 {
    static int N,M;
    static int [][] map;
    static int [][] move = {{},{-1,0},{0,1},{1,0},{0,-1}};
    static List<int[]> list;
    static int Size;
    static int[]tmp;
    static int sum;
    static int answer;
    static boolean[][]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=6 && map[i][j] !=0){
                    // 좌표, 모양
                    list.add(new int[]{i,j,map[i][j]});
                }
                if(map[i][j]==0) sum++;
            }
        }
        Size = list.size();
        tmp = new int[Size];
        comb(0,0);
        System.out.println(answer);
    }
    static void calc(){
        int cnt = 0;
        visited = new boolean[N][M];
        for(int tc=0;tc<Size;tc++){
            int dir = tmp[tc];
            int i = list.get(tc)[0]; int j = list.get(tc)[1]; int cctv = list.get(tc)[2];
            cnt += calcEvent(dir,cctv,i,j);
        }
        //사각 지대의 최소 크기 -> 최초 0(sum)에서 0을 지운 크기

        answer = Math.min(answer,(sum-cnt));
    }
    static int executeCCTV(int i,int j,int shape){
        int result = 0;
        while(true) {
            int ni = i + move[shape][0];
            int nj = j + move[shape][1];
            if (ni < 0 || nj < 0 || N - 1 < ni || M - 1 < nj) break;
            if(map[ni][nj]==6) break;
            if(!visited[ni][nj] && map[ni][nj]==0){
                visited[ni][nj] = true;
                result++;
            }
            i = ni; j = nj;
        }
        return result;
    }
    static int calcEvent(int dir,int cctv, int i, int j){
        int result = 0;
        if(cctv==1){
            result = executeCCTV(i,j,dir);
        }
        if(cctv==2){
                //상하
                if(dir==1){
                   result += executeCCTV(i,j,1);
                   result += executeCCTV(i,j,3);
               }else{
                    result += executeCCTV(i,j,2);
                    result += executeCCTV(i,j,4);
               }
        }
        if(cctv==3){
           //상우
            if(dir==1){
                result += executeCCTV(i,j,1);
                result += executeCCTV(i,j,2);
            }
           //우하
            if(dir==2)
            {
                result += executeCCTV(i,j,2);
                result += executeCCTV(i,j,3);
            }
           //하좌
            if(dir==3){
                result += executeCCTV(i,j,3);
                result += executeCCTV(i,j,4);
            }
           //좌상
            if(dir==4){
                result += executeCCTV(i,j,4);
                result += executeCCTV(i,j,1);
            }
        }
        if(cctv==4){
            //상우
            if(dir==1){
                result += executeCCTV(i,j,1);
                result += executeCCTV(i,j,2);
                result += executeCCTV(i,j,3);
            }
            //우하
            if(dir==2)
            {
                result += executeCCTV(i,j,2);
                result += executeCCTV(i,j,3);
                result += executeCCTV(i,j,4);
            }
            //하좌
            if(dir==3){
                result += executeCCTV(i,j,3);
                result += executeCCTV(i,j,4);
                result += executeCCTV(i,j,1);
            }
            //좌상
            if(dir==4){
                result += executeCCTV(i,j,4);
                result += executeCCTV(i,j,1);
                result += executeCCTV(i,j,2);
            }
        }
        if(cctv==5){
            result += executeCCTV(i,j,1);
            result += executeCCTV(i,j,2);
            result += executeCCTV(i,j,3);
            result += executeCCTV(i,j,4);
        }
        return result;
    }

    static void comb(int depth,int start){
        if(depth==Size){
            calc();
            return;
        }
        for(int i=start;i<Size;i++){
            int cctv = list.get(i)[2];
            if(cctv==1 || cctv==3||cctv==4){
                for(int j=1;j<5;j++){
                    tmp[depth] = j;
                    comb(depth+1,i+1);
                }
            }else if(cctv==2){
                for(int j=1;j<3;j++){
                    tmp[depth] = j;
                    comb(depth+1,i+1);
                }
            }else{
                tmp[depth] = 1;
                comb(depth+1,i+1);
            }
        }
    }
}
