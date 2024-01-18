package 전체문제.second_month_2024_01.twelveth_2024_01_18;

import java.util.*;
import java.io.*;
public class BJ_17281_야구_Gold_4 {
    static boolean[]visited;
    static int[]tmp;
    static int[][]map;
    static int N;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][10];
        visited=  new boolean[10];
        tmp = new int[10];
        tmp[4] = 1;
        StringTokenizer st= null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<10;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        perm(1);
        System.out.println(answer);
    }

    static void calc(){
        int player = 1;
        int out = 0;
        int score = 0;
        boolean[] base = new boolean[3];
        for(int g=0;g<N;g++){
            while(true) {
                int hit = map[g][tmp[player]];
                switch (hit) {
                    case 0:
                        out++;
                        break;
                    case 1:
                        for (int i = 2; -1 < i; i--) {
                            if (base[i]) {
                                if (i == 2) score++;
                                else base[i + 1] = true;
                                base[i] = false;
                            }
                        }
                        base[0] = true;
                        break;
                    case 2:
                        for (int i = 2; -1 < i; i--) {
                            if (base[i]) {
                                if (i == 2 || i == 1) score++;
                                else base[i + 2] = true;
                                base[i] = false;
                            }
                        }
                        base[1] = true;
                        break;
                    case 3:
                        for (int i = 2; -1 < i; i--) {
                            if (base[i]) {
                                score++;
                                base[i] = false;
                            }
                        }
                        base[2] = true;
                        break;
                    case 4:
                        for (int i = 2; -1 < i; i--) {
                            if (base[i]) score++;
                            base[i] = false;
                        }
                        score++;
                        break;
                }
                player++;
                if (player == 10) player = 1;
                if (out == 3) {
                    out = 0;
                    base = new boolean[3];
                    break;
                }
            }
        }
        answer = Math.max(answer,score);
    }
    static void perm(int depth){
        if(depth==4) depth++;
        if(depth==10){
            calc();
            return;
        }

        for(int i=2;i<10;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp[depth] = i;
                perm(depth+1);
                visited[i] = false;
            }
        }

    }
}
