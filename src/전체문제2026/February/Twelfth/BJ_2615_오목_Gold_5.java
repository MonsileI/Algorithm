package 전체문제2026.February.Twelfth;

import java.util.*;
import java.io.*;
public class BJ_2615_오목_Gold_5 {

    static int [][]map;
    static int N;
    static int answerFlag;
    static int[]answer;
    static boolean[][][]visited;
    static int[][]move = {{1,0},{0,1},{1,1},{-1,1}};
    static int[][][]memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = 19;
        map = new int[N][N];
        memo = new int[N][N][4];
        answerFlag = -1;
        answer= new int[2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][N][4]; //가로 세로 대각선위 대각선 아래
        OuterLoop:
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]!=0){
                    for(int d=0;d<4;d++) {
                        if(memo[i][j][d] == 0 && calc(i, j, map[i][j],d) ==5){
                            int pi = i - move[d][0];
                            int pj = j - move[d][1];

                            int ei = i + move[d][0] * 5;
                            int ej = j + move[d][1] * 5;

                            boolean prevOk = (pi < 0 || pj < 0 || pi >= N || pj >= N || map[pi][pj] != map[i][j]);
                            boolean nextOk = (ei < 0 || ej < 0 || ei >= N || ej >= N || map[ei][ej] != map[i][j]);

                            if(prevOk && nextOk){
                                answer[0] = (i+1); answer[1] = (j+1);
                                answerFlag = map[i][j];
                                break OuterLoop;
                            }

                        };
                    }
                }
            }
        }
        if(answerFlag==-1){
            System.out.println(0);
        }else{
            System.out.println(answerFlag+"\n"+(answer[0])+" "+(answer[1]));
        }
    }
    static int calc(int i,int j,int num,int d){
        if(memo[i][j][d] != 0) return memo[i][j][d];

        int ni = i + move[d][0];
        int nj = j + move[d][1];

        if(ni < 0 || nj < 0 || ni >= N || nj >= N) {
            return memo[i][j][d] = 1;
        }

        if (map[ni][nj] == num) {
            return memo[i][j][d] = calc(ni, nj, num, d) + 1;
        }

        return memo[i][j][d] = 1;
    }
}
