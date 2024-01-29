package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_20005_보스몬스터전리품_Gold_3 {

    static class Node implements Comparable<Node>{
        char player; int range; int power;

        public Node(char player, int range, int power) {
            this.player = player;
            this.range = range;
            this.power = power;
        }

        @Override
        public int compareTo(Node o) {
            return range - o.range;
        }
    }
    static int N,M,P;
    static char[][]map;
    static Node[]players;
    static int totalPlayer;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        totalPlayer = P;
        map = new char[N][M];
        int si = 0; int sj = 0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='B'){
                    si = i; sj = j;
                    map[i][j] = '.';
                }
            }
        }
        players= new Node[P];
        for(int i=0;i<P;i++){
            st = new StringTokenizer(br.readLine()," ");
            Node now = new Node(st.nextToken().charAt(0),0,Integer.parseInt(st.nextToken()));
            players[i] = now;
        }
        int bossPH = Integer.parseInt(br.readLine());
        bfs(si,sj);
        int range = 0;
        Arrays.sort(players);
        int ans = 0;
        while(true){
            InnerLoop:
            for(int i=0;i<P;i++) {
                if(range<players[i].range) break InnerLoop;
                bossPH -= players[i].power;
                ans = i;
            }
            if(bossPH < 1) break;
            range++;

        }
        System.out.println(ans+1);

    }
    static void bfs(int si,int sj){
        Queue<int[]> q=  new LinkedList<>();
        q.offer(new int[]{si,sj,0});
        boolean[][]visited=  new boolean[N][M];
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            for(int d=0;d<4;d++){
                int ni = i +move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj] && map[ni][nj]!='X'){
                    visited[ni][nj] = true;
                    if(map[ni][nj]!=','){
                        char p = map[ni][nj];
                        for(int t=0;t<P;t++){
                            if(players[t].player==p){
                                players[t].range = cnt;
                                totalPlayer--;
                                break;
                            }
                        }
                        q.offer(new int[]{ni,nj,cnt+1});
                        if(totalPlayer==0) return;
                    }else{
                        q.offer(new int[]{ni,nj,cnt+1});
                    }
                }
            }
        }
    }
}
