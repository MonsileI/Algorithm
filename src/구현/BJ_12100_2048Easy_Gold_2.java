package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_12100_2048Easy_Gold_2 {
    static int N;
    static int [][]map;
    static int[] tmp;
    static boolean[][]visited;
    static int [][]origin;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        origin = new int[N][N];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                origin[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        tmp = new int[5];
        comb(0);
        System.out.println(answer);
    }
    static void calc(){
        map = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = origin[i][j];
            }
        }
        for(int i=0;i<5;i++){

            switch (tmp[i]){
                case 0 : up();
                break;
                case 1 : right();
                    break;
                case 2 : down();
                    break;
                case 3 : left();
                    break;
            }
        }
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) answer = Math.max(answer,map[i][j]);
    }
    static void left(){
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=1;j<N;j++){
                if(map[i][j-1]!=0) {
                    if (map[i][j] == map[i][j - 1] && !visited[i][j - 1]) {
                        map[i][j - 1] *= 2;
                        visited[i][j - 1] = true;
                        map[i][j] = 0;
                    }
                    continue;
                }
                int cj = j;
                while(0<cj){
                    int nj = cj - 1;
                    if(map[i][nj]!=0){
                        if (map[i][cj] == map[i][nj] && !visited[i][nj]) {
                            map[i][nj] *= 2;
                            visited[i][nj] = true;
                            map[i][cj] = 0;
                        }
                        break;
                    }
                    map[i][nj] = map[i][cj];
                    map[i][cj] = 0;
                    cj = nj;
                }
            }
        }

    }
    static void down(){
        visited = new boolean[N][N];

        for(int j=0;j<N;j++){
            for(int i=N-2;-1<i;i--){
                if(map[i+1][j]!=0) {
                    if (map[i][j] == map[i+1][j] && !visited[i+1][j]) {
                        map[i+1][j] *= 2;
                        visited[i+1][j] = true;
                        map[i][j] = 0;
                    }
                    continue;
                }
                int ci = i;
                while(ci<N-1){
                    int ni = ci + 1;
                    if(map[ni][j]!=0){
                        if (map[ci][j] == map[ni][j] && !visited[ni][j]) {
                            map[ni][j] *= 2;
                            visited[ni][j] = true;
                            map[ci][j] = 0;
                        }
                        break;
                    }
                    map[ni][j] = map[ci][j];
                    map[ci][j] = 0;
                    ci = ni;
                }
            }
        }
    }
    static void right(){
        visited = new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=N-2;-1<j;j--){
                if(map[i][j+1]!=0) {
                    if (map[i][j] == map[i][j+1] && !visited[i][j+1]) {
                        map[i][j+1] *= 2;
                        visited[i][j+1] = true;
                        map[i][j] = 0;
                    }
                    continue;
                }
                int cj = j;
                while(cj<N-1){
                    int nj = cj + 1;
                    if(map[i][nj]!=0){
                        if (map[i][cj] == map[i][nj] && !visited[i][nj]) {
                            map[i][nj] *= 2;
                            visited[i][nj] = true;
                            map[i][cj] = 0;
                        }
                        break;
                    }
                    map[i][nj] = map[i][cj];
                    map[i][cj] = 0;
                    cj = nj;
                }
            }
        }

    }
    static void up(){

        visited = new boolean[N][N];
        for(int j=0;j<N;j++){
            for(int i=1;i<N;i++){
                if(map[i-1][j]!=0) {
                    if (map[i][j] == map[i - 1][j] && !visited[i - 1][j]) {
                        map[i - 1][j] *= 2;
                        visited[i - 1][j] = true;
                        map[i][j] = 0;
                    }
                    continue;
                }
                int ci = i;
                while(0<ci){
                    int ni = ci - 1;
                    if(map[ni][j]!=0){
                        if (map[ci][j] == map[ni][j] && !visited[ni][j]) {
                            map[ni][j] *= 2;
                            visited[ni][j] = true;
                            map[ci][j] = 0;
                        }
                        break;
                    }
                    map[ni][j] = map[ci][j];
                    map[ci][j] = 0;
                    ci = ni;
                }
            }
        }
    }
    static void comb(int depth){
        if(depth==5){
            calc();
            return;
        }
        for(int i=0;i<5;i++){
            tmp[depth] = i;
            comb(depth+1);
        }
    }
}
