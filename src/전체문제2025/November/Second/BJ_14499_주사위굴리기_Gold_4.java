package 전체문제2025.November.Second;

import java.util.*;
import java.io.*;
public class BJ_14499_주사위굴리기_Gold_4 {
    static int N,M;
    static int ci,cj;
    static int[][]map;
    static int[] dice = {0,0,0,0,0,0}; //위,북,동,남,서, 아래
    static int[][]move = {{},{0,1},{0,-1},{-1,0},{1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N= Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ci = Integer.parseInt(st.nextToken());
        cj = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        while(0<tc){
            int ord = Integer.parseInt(st.nextToken());
            int result = calc(ord);
            if(result!=-1) sb.append(result+"\n");
            tc--;
        }
        System.out.println(sb.toString());
    }
    static int calc(int ord){
        /*
        1. 이동
            ㄴ 이동한 칸에 쓰여 있는 수가 0이면, 주사위의 바닥면에 쓰여 있는 수가 복사
            ㄴ 0이 아니면, 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사, 칸은 0
        2. 상단에 쓰여 있는 값을 구한다.

        order : 1 동 2 서 4 남 3 북
        * */
        int ni = ci + move[ord][0];
        int nj = cj + move[ord][1];

        if(ni<0||nj<0||N-1<ni||M-1<nj) return -1;

        /*
            동쪽 -> {1,2,3,4,5,6} -> {5,2,1,4,6,3}   0-4, 2-0 , 4-5, 5-2
            서쪽 -> {1,2,3,4,5,6} -> {3,2,6,4,1,5}   0-2,2-5 ,4-0 , 5-4
            남쪽 -> {1,2,3,4,5,6} -> {2,6,3,1,5,4}   0-1, 1-5, 3-0, 5-3
            북쪽 -> {1,2,3,4,5,6} -> {4,1,3,6,5,2}   0-3, 1-0, 3-5, 5-1
        * */
        int[]tmp = new int[6];
        for(int i=0;i<6;i++) tmp[i] = dice[i];
        switch(ord){
            case 1:
                dice[0] = tmp[4];
                dice[2] = tmp[0];
                dice[4] = tmp[5];
                dice[5] = tmp[2];
                break;
            case 2:
                dice[0] = tmp[2];
                dice[2] = tmp[5];
                dice[4] = tmp[0];
                dice[5] = tmp[4];
                break;
            case 3:
                dice[0] = tmp[3];
                dice[1] = tmp[0];
                dice[3] = tmp[5];
                dice[5] = tmp[1];
                break;
            case 4:
                dice[0] = tmp[1];
                dice[1] = tmp[5];
                dice[3] = tmp[0];
                dice[5] = tmp[3];
                break;

        }
        if(map[ni][nj]==0) {
            map[ni][nj] = dice[5];
        }
        else {
            dice[5] = map[ni][nj];
            map[ni][nj] = 0;
        }
        ci = ni;
        cj = nj;

        return dice[0];
    }
}
