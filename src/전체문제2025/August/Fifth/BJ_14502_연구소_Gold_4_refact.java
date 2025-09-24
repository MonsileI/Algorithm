package 전체문제2025.August.Fifth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_14502_연구소_Gold_4_refact {
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
    static void initialize() throws Exception{

        // ====================================
        // input 메서드 생성
        // ====================================
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // ====================================
        // 맵 크기 초기화, 새로운 벽을 세울 배열 초기화
        // ====================================
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map  =new int[N][M];
        walls = new int[3];

        // ====================================
        // 각 배열 초기화
        // ====================================
        virus = new ArrayList<>();
        zero = new ArrayList<>();
        comb = new ArrayList<>();

        // ====================================
        // 맵 input
        // ====================================
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
        // ====================================
        // 기존 0 사이즈 초기화, answer 초기화
        // ====================================
        zeroLen = zero.size();
        answer = 0;

    }
    static void makeCombination(int depth,int start){
        // ====================================
        // 3개의 새로운 벽을 세울 combination 완성시, comb 배열 채워주기, 재귀 종료
        // ====================================
        if(depth==3){
            comb.add(new int[]{walls[0],walls[1],walls[2]});
            return;
        }
        // ====================================
        // zeroLen 만큼 돌며 벽을 세울 0 좌표 조합 생성
        // ====================================
        for(int i=start;i<zeroLen;i++){
            walls[depth] = i;
            makeCombination(depth+1,i+1);
        }
    }
    static void executeMainLogic(){
        // ====================================
        // copyMap, cnt, q, visited(방문표시) 생성
        // ====================================
        int[][]copyMap = null;
        int cnt = 0;
        Queue<int[]> q = null;
        boolean[][]visited = null;
        for(int [] c : comb) {
            // ====================================
            // 새로 벽을 세우기 때문에 초기화 -3
            // ====================================
            cnt = (zeroLen - 3);

            // ====================================
            // copyMap, cnt, q, visited(방문표시) 초기화
            // ====================================
            copyMap = new int[N][M];
            q = new ArrayDeque<>();
            visited = new boolean[N][M];

            // ====================================
            // copyMap 초기화
            // ====================================

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            // ====================================
            // 새로운 벽 세워주기
            // ====================================
            for(int d : c){
                int i = zero.get(d)[0];
                int j = zero.get(d)[1];
                copyMap[i][j] = 1;
            }
            // ====================================
            // virus q에 넣어주기
            // ====================================
            for(int[]v : virus){
                int i = v[0]; int j = v[1];
                q.offer(new int[]{i,j});
                visited[i][j] = true;
            }
            // ====================================
            // virus bfs 실행, answer 갱신
            // ====================================
            answer = Math.max(answer,virusBfs(copyMap,cnt,q,visited));
        }
    }
    static int virusBfs(int[][]copyMap,int cnt, Queue<int[]> q,boolean[][]visited){

        while(!q.isEmpty()){
            int[]cur = q.poll();
            int i = cur[0]; int j = cur[1];
            // ====================================
            // 4방 탐색
            // ====================================
            for(int d=0;d<4;d++){
                int ni = i +move[d][0];
                int nj = j +move[d][1];

                // ====================================
                // bfs 진행 여부 체크
                // ====================================
                if(!checkBfs(ni,nj,copyMap,visited)){
                    continue;
                }
                // ====================================
                // 방문표시
                // ====================================
                visited[ni][nj] = true;

                // ====================================
                // 0일 경우 2로 배열 갱신, cnt 줄여주기
                // ====================================
                if(copyMap[ni][nj]==0){
                    copyMap[ni][nj] = 2;
                    cnt--;
                    // ====================================
                    // cnt가 answer보다 작아지면 break (나머지 연산 수행 안함)
                    // ====================================
                    if(cnt <= answer){
                        break;
                    }
                }
                q.offer(new int[]{ni,nj});
            }
        }
        return cnt;
    }
    static boolean checkBfs(int ni,int nj,int[][]copyMap,boolean[][]visited){
        // ====================================
        // early return
        // 1. 배열을 벗어나면, 2. 배열값이 1(벽)이면, 3. 방문 하였으면
        // ====================================
        if(ni<0||nj<0||N-1<ni||M-1<nj){
            return false;
        }
        if(copyMap[ni][nj] == 1){
            return false;
        }
        if(visited[ni][nj]){
            return false;
        }
        return true;
    }
    static void printOutput(){
        System.out.println(answer);
    }
}
