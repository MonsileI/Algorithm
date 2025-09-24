package 전체문제2025.August.Fifth;

import java.util.*;
import java.io.*;
public class BJ_14502_연구소_Gold_4 {
    static int N,M;
    static int [][] map;
    static List<int[]> virus;
    static List<int[]> zero;
    static List<int[]> comb;
    static int zeroLen;
    static int[] walls;
    static int answer;
    static int [][] move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        initialize();
        makeCombination(0,0);
        executeMainLogic();
        printOutput();
    }
    static void printOutput(){
        System.out.println(answer);
    }
    static void executeMainLogic(){
        int[][]copyMap = null;
        int cnt = 0;
        Queue<int[]> q = null;
        boolean[][]visited = null;
        for(int [] c : comb) {
            cnt = (zeroLen - 3);
            copyMap = new int[N][M];
            q = new ArrayDeque<>();
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            for(int d : c){
                int i = zero.get(d)[0];
                int j = zero.get(d)[1];
                copyMap[i][j] = 1;
            }

            for(int[]v : virus){
                int i = v[0]; int j = v[1];
                q.offer(new int[]{i,j});
                visited[i][j] = true;
            }

            boolean flag = false;

            while(!q.isEmpty()){
                int[]cur = q.poll();
                int i = cur[0]; int j = cur[1];
                for(int d=0;d<4;d++){
                    int ni = i +move[d][0];
                    int nj = j +move[d][1];
                    if(ni<0||nj<0||N-1<ni||M-1<nj){
                        continue;
                    }
                    if(copyMap[ni][nj] == 1){
                        continue;
                    }
                    if(visited[ni][nj]){
                        continue;
                    }
                    visited[ni][nj] = true;
                    if(copyMap[ni][nj]==0){
                        copyMap[ni][nj] = 2;
                        cnt--;
                        if(cnt <= answer){
                            flag = true;
                            break;
                        }
                    }
                    q.offer(new int[]{ni,nj});
                }
            }

             if(flag){
                continue;
            }
            answer = cnt;
        }
    }
    static void makeCombination(int depth,int start){
        if(depth==3){
            comb.add(new int[]{walls[0],walls[1],walls[2]});
            return;
        }
        for(int i=start;i<zeroLen;i++){
            walls[depth] = i;
            makeCombination(depth+1,i+1);
        }
    }

    static void initialize() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map  =new int[N][M];
        walls = new int[3];

        virus = new ArrayList<>();
        zero = new ArrayList<>();
        comb = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                 if(map[i][j]== 2){
                    virus.add(new int[]{i,j});
                }
                if(map[i][j]== 0){
                    zero.add(new int[]{i,j});
                }
            }
        }
        zeroLen = zero.size();
        answer = 0;

    }
}
