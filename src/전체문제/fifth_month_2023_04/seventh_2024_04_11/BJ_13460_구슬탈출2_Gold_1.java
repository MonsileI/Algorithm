package 전체문제.fifth_month_2023_04.seventh_2024_04_11;
import java.util.*;
import java.io.*;
public class BJ_13460_구슬탈출2_Gold_1 {
    static int N,M;
    static char[][]map;
    static int answer = 987654321;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int [][][][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int ri = 0; int rj = 0; int bi = 0; int bj = 0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='R'){
                    ri = i; rj = j;
                    map[i][j] = '.';
                }
                if(map[i][j]=='B'){
                    bi = i ; bj = j;
                    map[i][j] = '.';
                }
            }
        }
        dp = new int[N][M][N][M];
        dfs(ri, rj, bi, bj, 0);
        System.out.println(answer>10 ? -1 : answer);
    }
    static void dfs(int ri,int rj, int bi, int bj, int cnt){
        if(cnt>10) return;
        if(answer<=cnt) return;
        if(map[ri][rj]=='O' && map[bi][bj]=='.'){
            answer = cnt;
            return;
        }
        if(dp[ri][rj][bi][bj]!=0 && dp[ri][rj][bi][bj]<cnt) return;
        dp[ri][rj][bi][bj] = cnt;
        OuterLoop:
        for(int d=0;d<4;d++){
            int nri = ri; int nrj = rj;
            int tri = ri; int trj = rj;
            while(true){
                tri = nri + move[d][0];
                trj = nrj + move[d][1];
                if(map[tri][trj]=='#') break;
                if(map[tri][trj]=='O'){
                    nri = tri; nrj = trj;
                    break;
                }
                nri = tri; nrj = trj;
            }

            int nbi = bi; int nbj = bj;
            int tbi = bi; int tbj = bj;
            while(true){
                tbi = nbi + move[d][0];
                tbj = nbj + move[d][1];
                if(map[tbi][tbj]=='#') break;
                if(map[tbi][tbj]=='O'){
                    nbi = tbi; nbj = tbj;
                    break;
                }
                nbi = tbi; nbj = tbj;
            }
            if(map[nri][nrj]=='O'&&map[nbi][nbj]=='O') continue;
            if(nri==nbi && nrj == nbj){
                switch (d){
                    case 0:
                    if(ri<bi)nbi++;
                    else nri++;
                        break;
                    case 1:
                    if(rj<bj) nrj--;
                    else nbj--;
                        break;
                    case 2:
                    if(ri<bi)nri--;
                    else nbi--;
                        break;
                    case 3:
                    if(rj<bj) nbj++;
                    else nrj++;
                        break;
                }
            }
            if(map[nbi][nbj]=='O') continue;
            if((ri==nri)&&(rj==nrj)&&(bi==nbi)&&(bj==nbj)) continue;
            dfs(nri,nrj,nbi,nbj,cnt+1);
        }

    }
}
