package 전체문제.sixth_month_2024_05.fifteenth_2024_05_22;

import java.util.*;
import java.io.*;
public class BJ_14891_톱니바퀴_Gold_5 {
    static int[][]top;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        top = new int[5][8];
        for(int i=1;i<5;i++){
            String str = br.readLine();
            for(int j=0;j<8;j++){
                top[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        int q = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken());
            int turn = Integer.parseInt(st.nextToken());
            //2번이랑 6번
            visited = new boolean[5];
            visited[num] = true;
            dfs(num,turn);
        }

        int ans = 0;

        int[]score = {0,1,2,4,8};

        for(int i=1;i<5;i++){
            if(top[i][0]==1){
                ans += score[i];
            }
        }
        System.out.println(ans);

    }
    static void dfs(int node, int turn){
        if(node!=1) {
            if (top[node-1][2] != top[node][6] && !visited[node-1]) {
                visited[node-1] = true;
                dfs(node -1, turn * -1);
            }
        }
        if(node!=4){
            if (top[node][2] != top[node+1][6] && !visited[node+1]){
                visited[node+1] = true;
                dfs(node + 1, turn * -1);
            }
        }
        //회전
        if(turn==1){
            int last = top[node][7];
            for(int i=7;0<i;i--) top[node][i] = top[node][i-1];
            top[node][0] = last;

        }else{
            int fir = top[node][0];
            for(int i=0;i<7;i++) top[node][i] = top[node][i+1];
            top[node][7] = fir;
        }

    }
}
