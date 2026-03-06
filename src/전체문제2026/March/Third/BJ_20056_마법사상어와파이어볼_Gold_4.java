package 전체문제2026.March.Third;

import java.util.*;
import java.io.*;
public class BJ_20056_마법사상어와파이어볼_Gold_4 {
    static class Node {
        int r;
        int c;
        int m;
        int s;
        int d;

        public Node(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); //파이어 볼 개수
        int K = Integer.parseInt(st.nextToken()); //명령 개수

        int[][]move = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

        Queue<Node> q = new ArrayDeque<>(); //파이어볼 저장
        int[][]visited= null; //중복 여부
        Node[][]map = null; //퍼뜨리기 위한 map
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken())-1; //i
            int c = Integer.parseInt(st.nextToken())-1; //j
            int m = Integer.parseInt(st.nextToken());//방향
            int s = Integer.parseInt(st.nextToken());//질량
            int d = Integer.parseInt(st.nextToken());//스피드
            q.offer(new Node(r,c,m,s,d));
        }
        while(0 < K) {
            // 1. 파이어볼 이동 & 뭉치기
            int size = q.size();
            visited = new int[N][N];
            map = new Node[N][N];
            for (int t = 0; t < size; t++) {
                Node cur = q.poll();
                int i = cur.r;
                int j = cur.c;
                int m = cur.m;
                int s = cur.s;
                int d = cur.d;
                int ni = i + (move[d][0]) * s;
                int nj = j + (move[d][1]) * s;
                if (ni < 0) ni = N - (Math.abs(ni) % N);
                if (nj < 0) nj = N - (Math.abs(nj) % N);
                if (N - 1 < ni) ni = ni % N;
                if (N - 1 < nj) nj = nj % N;
                visited[ni][nj]++;
                if (map[ni][nj] == null) {
                    map[ni][nj] = new Node(0, 0, 0, 0, d);
               }
                map[ni][nj].m += m;
                map[ni][nj].s += s;
                if(map[ni][nj].d != -1){
                    if(map[ni][nj].d%2 != d%2){
                        map[ni][nj].d = -1;
                    }
                }
                //1개 이상이면 그냥 그대로 넘어가면 됨
                if (1 < visited[ni][nj]) continue;
                q.offer(new Node(ni, nj, m, s, d));
            }
            // 3. 퍼뜨리기
            size = q.size();
            for (int t = 0; t < size; t++) {
                Node cur = q.poll();
                int i = cur.r;
                int j = cur.c;
                int m = cur.m;
                int s = cur.s;
                int d = cur.d;
                if (visited[i][j] == 1) {
                    q.offer(new Node(i, j, m, s, d));
                    continue;
                }else{
                    m = map[i][j].m;
                    s = map[i][j].s;
                }
                // visited[i][j]의 수가 뭉쳐진거 개수!
                int cnt = visited[i][j];
                // 속도 = 합쳐진 파이어볼의 속도 / 파이어볼 개수
                s = s / cnt;
                // 질량은 합쳐진 파이어볼의 질량 / 5
                m = m / 5;
                if(m==0) continue; // 0이 되면 넘어감
                // 방향 규칙 1. 모두 홀수이거나 짝수이면 0246, 아니면, 1357
                boolean isSame = map[i][j].d == -1 ? false : true;
                int idx = 0;
                if (isSame) idx = 0;
                else idx = 1;
                for (int dir = idx; dir < 8; dir += 2) {
                    q.offer(new Node(i, j, m, s, dir));
                }
            }
            K--;
        }
        int answer = 0;
        while(!q.isEmpty()){
            answer += q.poll().m;
        }
        System.out.println(answer);
    }
}
