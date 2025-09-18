package 전체문제2025.August.Third;

import java.awt.*;
import java.util.*;
import java.io.*;
public class BJ_14503_로봇청소기_Gold_5 {

    static class robot {
        int i; int j; int d;

        public robot(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }

    static int N,M;
    static int[][]map;
    static int clear;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int ri = Integer.parseInt(st.nextToken());
        int rj = Integer.parseInt(st.nextToken());
        int rd = Integer.parseInt(st.nextToken());
        robot robot = new robot(ri,rj,rd);
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clear = 0;
        while(true) {
            //1. 현재 칸이 청소되지 않은 경우, 현재 칸을 청소
             clearCurrent(robot);

             boolean checkFourDir = checkFourDir(robot);
            //2. 현재 칸 중 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            if(!checkFourDir) {
                // 1) 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                robot.i = robot.i + move[(robot.d + 2) % 4][0];
                robot.j = robot.j + move[(robot.d + 2) % 4][1];
                // 2) 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                if (map[robot.i][robot.j] == 1) {
                    break;
                }
            }else {
                //3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
                // 1) 반시계 방향으로 90도 회전한다.
                robot.d = (robot.d+3) % 4;
                // 2) 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                int ni = robot.i + move[robot.d][0];
                int nj = robot.j + move[robot.d][1];
                if(map[ni][nj] == 0){
                    robot.i = ni;
                    robot.j = nj;
                }
                // 3) 1번으로 돌아간다.
            }
        }
        System.out.println(clear);
    }
    static boolean checkFourDir(robot robot){
        for(int d=0;d<4;d++){
            int ni = robot.i + move[d][0];
            int nj = robot.j + move[d][1];
            if(map[ni][nj] == 0){
                return true;
            }
        }
        return false;
    }
    static void clearCurrent(robot robot){
        //현재 칸 체크
        if(map[robot.i][robot.j]==0){
            clear++;
            map[robot.i][robot.j] = 2;
        }
    }
}
