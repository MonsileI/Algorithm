package 전체문제2025.November.Ninth;

import java.util.*;
import java.io.*;
public class BJ_1938_통나무옮기기_Gold_2 {
    static int N;
    static char[][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        int[][]garoMove = {{0,-1},{0,1}}; //좌 우
        int[][]seroMove = {{-1,0},{1,0}}; //상 하
        int[][]checkGaro = {{0,-2},{0,2}};
        int[][]checkSero = {{-2,0},{2,0}};
        int[][]checkGaroSero = {{-1,-1},{-1,1},{1,-1},{1,1}}; //가로일때 세로 이동
        int[][]checkSeroGaro = {{-1,-1},{1,-1},{-1,1},{1,1}}; //세로일때 가로 이동

        int[][]checkTurn = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

        int si = 0; int sj = 0; int sd = 0;
        int ei = 0; int ej = 0; int ed = 0;
        int sCnt = 0; int eCnt = 0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='B'){
                    sCnt++;
                    if(sCnt==2){
                        si = i ; sj = j;
                        if(i!=0 && map[i-1][j]=='B'){
                            sd = 1;
                        }
                    }
                }
                if(map[i][j]=='E'){
                    eCnt++;
                    if(eCnt==2){
                        ei = i ; ej = j;
                        if(i!=0 && map[i-1][j]=='E'){
                            ed = 1;
                        }
                    }
                }
            }
        }
        boolean[][][]visited = new boolean[N][N][2];
        visited[si][sj][sd] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si,sj, 0, sd}); //가운데 위치 , cnt , 방향(0 가로, 1 세로)
        int ans = 0;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1]; int cnt = c[2]; int d= c[3];
            if(i==ei&&j==ej&&d==ed){
                ans = cnt;
                break;
            }
            //가로
            OuterLoop:
            for(int garo=0;garo<2;garo++){
                int ni = i + garoMove[garo][0];
                int nj = j + garoMove[garo][1];
                if(!checkRange(ni,nj)) continue;
                //가로일 때 가로 이동
                if(d==0) {
                    int ci = i + checkGaro[garo][0];
                    int cj = j + checkGaro[garo][1];
                    if (!checkRange(ci, cj)) continue;
                }
                //세로일 때 가로 이동
                if(d==1){
                    int start = 0; int end = 2;
                   if(garo==1){
                       start = 2;
                       end = 4;
                   }
                    for(start = start; start < end; start++){
                        int ci = i + checkSeroGaro[start][0];
                        int cj = j + checkSeroGaro[start][1];
                        if(!checkRange(ci,cj)) continue OuterLoop;
                    }
                }
                if(!visited[ni][nj][d]){
                    visited[ni][nj][d] = true;
                    q.offer(new int[]{ni, nj,cnt+1,d});
                }
            }
            //세로
            OuterLoop:
            for(int sero=0;sero<2;sero++){
                int ni = i + seroMove[sero][0];
                int nj = j + seroMove[sero][1];
                if(!checkRange(ni,nj)) continue;
                if(d==1) {
                    int ci = i + checkSero[sero][0];
                    int cj = j + checkSero[sero][1];
                    if (!checkRange(ci, cj)) continue;
                }

                //가로일 때 세로 이동
                if(d==0){
                    int start = 0; int end = 2;
                    if(sero==1){
                        start = 2;
                        end = 4;
                    }

                    for(start = start; start < end; start++){
                        int ci = i + checkGaroSero[start][0];
                        int cj = j + checkGaroSero[start][1];
                        if(!checkRange(ci,cj)) continue OuterLoop;
                    }
                }
                if(!visited[ni][nj][d]){
                    visited[ni][nj][d] = true;
                    q.offer(new int[]{ni, nj,cnt+1,d});
                }
            }
            //회전
            boolean flag = true;
            for(int turn = 0; turn < 8 ; turn++){
                int ni = i + checkTurn[turn][0];
                int nj = j + checkTurn[turn][1];
                if(!checkRange(ni,nj)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                int nd = d == 0 ? 1 : 0;
                if(!visited[i][j][nd]){
                    visited[i][j][nd] = true;
                    q.offer(new int[]{i,j,cnt+1,nd});
                }
            }
        }
        System.out.println(ans);
    }
    static boolean checkRange(int i,int j){
        if(i<0||j<0||N-1<i||N-1<j) return false;
        if(map[i][j]=='1') return false;
        return true;
    }
}
