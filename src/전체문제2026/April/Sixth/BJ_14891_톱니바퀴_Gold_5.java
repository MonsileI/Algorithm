package 전체문제2026.April.Sixth;

import java.util.*;
import java.io.*;
public class BJ_14891_톱니바퀴_Gold_5 {

    static int N,M;
    static int[][]arr;
    static boolean[]visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 4;
        M = 8;
        arr = new int[N][8];
        for(int i=0;i<N;i++){
            String str= br.readLine();
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(str.charAt(j)+"") ;
            }
        }
        int turn = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int i=0;i<turn;i++){
            visited=  new boolean[N];
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken())-1;
            int act = Integer.parseInt(st.nextToken());
            //시계방향
            execute(num,act);
        }
        int answer = 0;
        for(int i=0;i<N;i++){
            if(arr[i][0]==1) answer += Math.pow(2,i);
        }
        System.out.println(answer);
    }
    static void execute(int num,int act){

        if(visited[num]) return;
        visited[num] = true;


        //비교해주기
        if(num<3){
            //오른쪽
            if(arr[num][2]!=arr[num+1][6]){
                execute(num+1,act==1 ? -1 : 1);
            }
        }
        if(0<num){
            //왼쪽
            if(arr[num][6]!=arr[num-1][2]){
                execute(num-1,act==1 ? -1 : 1);
            }
        }
        //돌려주기

        //시계
        if(act==1) {
            int last = arr[num][M - 1];
            for (int i = M - 1; 0 < i; i--) arr[num][i] = arr[num][i - 1];
            arr[num][0] = last;
        }else {
            //반시계
            int first = arr[num][0];
            for (int i = 0; i < M - 1; i++) arr[num][i] = arr[num][i + 1];
            arr[num][M - 1] = first;
        }
    }
}
