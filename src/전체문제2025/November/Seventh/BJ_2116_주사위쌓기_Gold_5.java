package 전체문제2025.November.Seventh;

import java.util.*;
import java.io.*;
public class BJ_2116_주사위쌓기_Gold_5 {
    static int [][] dice;
    static int N;
    static int [] nextPos = {5,3,4,1,2,0}; //0 1 2 3 4 5
    static int[][] tmp;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dice = new int[N][6];
        tmp = new int[N][4];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<6;j++){
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //0 - 5, 1 - 3, 2 - 4        //아래 - 윗면이 같아야 함.
        for(int i=0;i<6;i++) {
            int tmp = 0;
            for(int j=0;j<6;j++){
                if(j==i || j == nextPos[i]) continue;
                tmp = Math.max(tmp,dice[0][j]);
            }
            dfs(tmp,0,i);
        }
        System.out.println(answer);

    }
    static void dfs(int sum,int depth,int pos){
        if(depth==N-1){
            answer = Math.max(answer,sum);
            return;
        }
        int next = nextPos[pos];

        for(int i=0;i<6;i++){
            if(dice[depth][next]==dice[depth+1][i]){
                int tmp = 0;
                for(int j=0;j<6;j++){
                    if(j==i || j == nextPos[i]) continue;
                    tmp = Math.max(tmp,dice[depth+1][j]);
                }
                dfs(sum+tmp,depth+1,i);
            }
        }
    }
}
