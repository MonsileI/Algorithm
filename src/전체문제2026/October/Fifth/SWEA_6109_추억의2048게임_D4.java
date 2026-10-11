package 전체문제2026.October.Fifth;

import java.util.*;
import java.io.*;
public class SWEA_6109_추억의2048게임_D4 {
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int N;
    static int[][]map;
    static boolean[][]isDone;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            String act  =st.nextToken();
            map = new int[N][N];
            isDone = new boolean[N][N];
            for(int i=0;i<N;i++){
                st =new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            switch (act){
                case "up":
                    up(0);
                break;
                case "down":
                    down(2);
                break;
                case "left":
                    left(3);
                break;
                case "right":
                    right(1);
                break;
            }
            sb.append("#"+t+"\n");
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static void up(int dir){
        for(int j=0;j<N;j++){
            for(int i=1;i<N;i++){
                if(map[i][j]!=0){
                    int ni = i + move[dir][0];
                    while(-1<ni){
                        if(ni==0 && map[ni][j]==0){
                            map[ni][j] = map[i][j];
                            map[i][j] = 0;
                        }
                        if(map[ni][j]!=0){
                           if(map[ni][j]==map[i][j] && !isDone[ni][j]){
                               isDone[ni][j] = true;
                               map[ni][j] *= 2;
                               map[i][j] = 0;
                           }else{
                               if(ni+1!=i) {
                                   map[ni + 1][j] = map[i][j];
                                   map[i][j] = 0;
                               }
                           }
                           break;
                       }
                       ni += move[dir][0];
                    }
                }
            }
        }

    }
    static void down(int dir){
        for(int j=0;j<N;j++){
            for(int i=N-2;-1<i;i--){
                if(map[i][j]!=0){
                    int ni = i + move[dir][0];
                    while(ni<N){
                        if(ni==N-1 && map[ni][j]==0){
                            map[ni][j] = map[i][j];
                            map[i][j] = 0;
                        }
                        if(map[ni][j]!=0){
                            if(map[ni][j]==map[i][j] && !isDone[ni][j]){
                                isDone[ni][j] = true;
                                map[ni][j] *= 2;
                                map[i][j] = 0;
                            }else{
                                if(ni-1!=i) {
                                    map[ni - 1][j] = map[i][j];
                                    map[i][j] = 0;
                                }
                            }
                            break;
                        }
                        ni += move[dir][0];
                    }
                }
            }
        }

    }
    static void left(int dir){
        for(int i=0;i<N;i++){
            for(int j=1;j<N;j++){
                if(map[i][j]!=0){
                    int nj = j + move[dir][1];
                    while(-1<nj){
                        if(nj==0 && map[i][nj]==0){
                            map[i][nj] = map[i][j];
                            map[i][j] = 0;
                        }
                        if(map[i][nj]!=0){
                            if(map[i][nj]==map[i][j] && !isDone[i][nj]){
                                isDone[i][nj] = true;
                                map[i][nj] *= 2;
                                map[i][j] = 0;
                            }else{
                                if(nj+1!=j) {
                                    map[i][nj+1] = map[i][j];
                                    map[i][j] = 0;
                                }
                            }
                            break;
                        }
                        nj += move[dir][1];
                    }
                }
            }
        }

    }
    static void right(int dir){

        for(int i=0;i<N;i++){
            for(int j=N-2;-1<j;j--){
                if(map[i][j]!=0){
                    int nj = j + move[dir][1];
                    while(nj<N){
                        if(nj==N-1 && map[i][nj]==0){
                            map[i][nj] = map[i][j];
                            map[i][j] = 0;
                        }
                        if(map[i][nj]!=0){
                            if(map[i][nj]==map[i][j] && !isDone[i][nj]){
                                isDone[i][nj] = true;
                                map[i][nj] *= 2;
                                map[i][j] = 0;
                            }else{
                                if(nj-1!=j) {
                                    map[i][nj-1] = map[i][j];
                                    map[i][j] = 0;
                                }
                            }
                            break;
                        }
                        nj += move[dir][1];
                    }
                }
            }
        }

    }

}
