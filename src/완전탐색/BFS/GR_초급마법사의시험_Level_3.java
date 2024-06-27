package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class GR_초급마법사의시험_Level_3 {
    static class Node{
        int i; int j; int k; int cnt;

        public Node(int i, int j, int k,int cnt) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.cnt = cnt;
        }
    }
    static int N,M,K;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        System.out.println(bfs());
    }
    static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        boolean[][][]visited = new boolean[N][M][K+1];
        visited[0][0][K] = true;
        q.offer(new Node(0,0,K,0));
        while(!q.isEmpty()){
            Node node = q.poll();
            int i = node.i; int j = node.j; int cnt = node.cnt; int k = node.k;
            if(i==N-1 && j==M-1) return cnt;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]==0 && !visited[ni][nj][k]){
                    visited[ni][nj][k] = true;
                    q.offer(new Node(ni,nj,k,cnt+1));
                }else if(map[ni][nj]==1 && !visited[ni][nj][k] && k>=10){
                    int nni = ni + move[d][0];
                    int nnj = nj + move[d][1];
                    if(nni<0||nnj<0||N-1<nni||M-1<nnj) continue;
                    if(map[nni][nnj]==1) continue;
                    visited[nni][nnj][k-10] = visited[ni][nj][k] = true;
                    q.offer(new Node(nni,nnj,k-10,cnt+1));
                }

            }
        }
        return -1;
    }
}
