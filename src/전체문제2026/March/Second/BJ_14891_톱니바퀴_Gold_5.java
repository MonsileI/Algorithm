package 전체문제2026.March.Second;

import java.util.*;
import java.io.*;
public class BJ_14891_톱니바퀴_Gold_5 {
    static int[][]top;
    static boolean[]visited;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 8;
        top = new int[4][N];
        for(int i=0;i<4;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                top[i][j] = str.charAt(j) - '0';
            }
        }
        int Q = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        while(0<Q){
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken())-1;
            int turn = Integer.parseInt(st.nextToken());
            visited = new boolean[4];
            calc(num,turn);
            Q--;
        }
        int answer = 0;
        //1248
        for(int i=0;i<4;i++){
            if(top[i][0]==0) continue;
            answer += Math.pow(2,i);
        }
        System.out.println(answer);
    }
    static boolean checkBefore(int num){
        if(num<1) return false;
        if(visited[num-1]) return false;
        return top[num][6] != top[num - 1][2];
    }
    static boolean checkNext(int num){
        if(2<num) return false;
        if(visited[num+1]) return false;
        return top[num][2] != top[num + 1][6];
    };
    static void calc(int num,int turn){
        if(num<0 || 3<num || visited[num]) return;
        visited[num] = true;
        int next = turn == 1 ? -1 : 1;

        if(checkNext(num)) calc(num+1,next);
        if(checkBefore(num)) calc(num-1,next);

        //회전시키기
        if(turn==1){
            int eight = top[num][N-1];
            for(int i=N-1;0<i;i--){
                top[num][i] = top[num][i-1];
            }
            top[num][0] = eight;
        }
        if(turn==-1){
            int zero = top[num][0];
            for(int i=0;i<N-1;i++){
                top[num][i] = top[num][i+1];
            }
            top[num][N-1] = zero;
        }

    }
}
