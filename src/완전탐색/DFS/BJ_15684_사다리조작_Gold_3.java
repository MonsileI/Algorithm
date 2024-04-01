package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15684_사다리조작_Gold_3 {
    static boolean flag;
    static int ans;
    static int N,M;
    static int [][]info;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken()); //가로 (j)
        int T = Integer.parseInt(st.nextToken()); //가로선 개수
        N = Integer.parseInt(st.nextToken()); //높이 (i)
        info = new int[N+1][M+1];
        for(int i=0;i<T;i++){
            st= new StringTokenizer(br.readLine()," ");
            int sero = Integer.parseInt(st.nextToken());
            int garo = Integer.parseInt(st.nextToken());
            info[sero][garo] = 1;
            info[sero][garo+1] = 2;
        }

        for(int i=0;i<4;i++) {
            dfs(0, i);
            if(flag) break;
        }
        System.out.println(flag ? ans : -1);
    }

    static void dfs(int depth,int count){
        if(flag) return;
        if(depth==count) {
            if (check()) {
                flag = true;
                ans = depth;
            }
            return;
        }
        for(int i=1;i<N+1;i++){
            for(int j=1;j<M;j++){
                if(info[i][j]==0&&info[i][j+1]==0){
                    info[i][j] = 1;
                    info[i][j+1] = 2;
                    dfs(depth+1,count);
                    info[i][j] = info[i][j+1] = 0;
                }
            }
        }
    }
    static boolean check(){

        for(int j=1;j<M+1;j++){
            int now = j;
            for(int i=1;i<N+1;i++){
                if(info[i][now]==1) now++;
                else if(info[i][now]==2)now--;
            }
            if(now!=j) return false;
        }
        return true;
    }
}
