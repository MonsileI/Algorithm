package 전체문제2025.November.Fourth;

import java.util.*;
import java.io.*;
public class BJ_14891_톱니바퀴_Gold_5 {

    static int[][]top;
    static boolean[]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        top = new int[4][8];
        for(int i=0;i<4;i++){
            String str = br.readLine();
            for(int j=0;j<8;j++){
                top[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        while(0<K){
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken())-1;
            int act = Integer.parseInt(st.nextToken());
            visited = new boolean[4];
            dfs(num,act);
            K--;

        }

        int ans = top[0][0] + top[1][0] * 2 + top[2][0] * 4 + top[3][0] * 8;
        System.out.println(ans);

    }
    static void dfs(int cur,int act){

        visited[cur] = true;
        int left = cur - 1;
        int right = cur + 1;
        if(-1<left){
            if(!visited[left] && top[cur][6]!=top[left][2]){
                dfs(left,act == 1 ? -1 : 1);
            }
        }
        if(right<4){
            if(!visited[right] && top[right][6]!=top[cur][2]){
                dfs(right,act == 1 ? -1 : 1);
            }
        }

        //자기 자신 돌리기
        //정방향
        if(act==1) {
            int tmp = top[cur][7];
            for (int i = 7; 0 < i; i--) {
                top[cur][i] = top[cur][i - 1];
            }
            top[cur][0] = tmp;
        //역방향
        }else{
            int tmp = top[cur][0];
            for (int i = 0;  i < 7; i++) {
                top[cur][i] = top[cur][i + 1];
            }
            top[cur][7] = tmp;
        }
    }
}
