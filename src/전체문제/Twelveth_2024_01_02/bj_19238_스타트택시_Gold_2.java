package 전체문제.Twelveth_2024_01_02;
import java.util.*;
import java.io.*;
public class bj_19238_스타트택시_Gold_2 {
    static class Node implements Comparable<Node>{
        int i; int j; int cnt; int fuel;


        public Node(int i, int j, int cnt,int fuel) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.fuel = fuel;
        }

        @Override
        public int compareTo(Node o) {
            return cnt == o.cnt ? i == o.i ? j - o.j : i - o.i : cnt - o.cnt;
        }
    }
    static int N;
    static int [][]map;
    static Map<Integer,int[]> cMap;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine()," ");
        int si = Integer.parseInt(st.nextToken())-1;
        int sj = Integer.parseInt(st.nextToken())-1;
        cMap = new HashMap<>();
        int idx =3;
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int fi = Integer.parseInt(st.nextToken())-1;
            int fj = Integer.parseInt(st.nextToken())-1;
            int ssi = Integer.parseInt(st.nextToken())-1;
            int ssj = Integer.parseInt(st.nextToken())-1;
            map[fi][fj] = idx;
            cMap.put(idx++,new int[]{ssi,ssj});
        }
        System.out.println(bfs(si,sj,fuel));
    }
    static int bfs(int si,int sj,int f){
        int sum = cMap.size();
        int ans = -1;
        while(true){
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(si,sj,0,f));
            boolean[][]visited= new boolean[N][N];
            visited[si][sj] = true;
            while(!pq.isEmpty()){
                Node now = pq.poll();
                int i = now.i; int j = now.j; int cnt = now.cnt; int fuel = now.fuel;
                if(map[i][j]>2){
                    if(fuel<=cnt) return -1;
                    int ei = cMap.get(map[i][j])[0]; int ej = cMap.get(map[i][j])[1];
                    int arrive = returnBfs(i,j,ei,ej,fuel-cnt); //현재 연료에 cnt를 뺀 남은 연료를 계산한 값
                    if(arrive==-1) return -1;
                    si = ei;
                    sj = ej;
                    f =  arrive + fuel - cnt;
                    ans = f;
                    map[i][j] = 0;
                    break;
                }
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if(!visited[ni][nj]&&map[ni][nj]!=1){
                        visited[ni][nj] = true;
                        pq.offer(new Node(ni,nj,cnt+1,fuel));
                    }
                }
            }
            sum--;
            if(sum==0) break;
        }
        return ans;
    }
    static int returnBfs(int si,int sj,int ei,int ej,int fuel){
        boolean[][]visited=  new boolean[N][N];
        Queue<int[]> q=  new ArrayDeque<>();
        q.offer(new int[]{si,sj,0});
        visited[si][sj] = true;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int cnt = c[2];
            if(i==ei&&j==ej){
                if(fuel<cnt) return -1;
                return cnt;
            }
            for(int d=0;d<4;d++){
                int ni =  i + move[d][0];
                int nj =  j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]&&map[ni][nj]!=1){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }

        return -1;
    }
}
