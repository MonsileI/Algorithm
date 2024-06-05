package 전체문제.seven_month_2024_06.third_2024_06_05;
import java.util.*;
import java.io.*;
public class BJ_16236_아기상어_Gold_3 {
    static class Shark implements Comparable<Shark>{
        int i;int j;int num;

        public Shark(int i, int j, int num) {
            this.i = i;
            this.j = j;
            this.num = num;
        }

        @Override
        public int compareTo(Shark o) {
            return num - o.num;
        }
    }
    static int N;
    static int[][]map;
    static List<Shark> list;
    static int size;
    static int eat;
    static int min;
    static int si,sj;
    static int[][]move ={{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        size = 2;
        eat = 0;
        map = new int[N][N];
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==9){
                    map[i][j] = 0;
                    si = i; sj =j;
                }
                if(map[i][j]!=0){
                    list.add(new Shark(i,j,map[i][j]));
                }
            }
        }
        Collections.sort(list);
        int ans = 0;
        while(true){
            if(list.isEmpty()) break;
            calc();
            if(min==987654321) break;
            ans += min;
            eat++;
            if(size==eat){
                size++;
                eat = 0;
            }
        }
        System.out.println(ans);
    }
    static void calc(){
        min = 987654321;
        int idx = -1;
        int minI = 987654321;
        int minJ = 987654321;
        for(int t=0;t<list.size();t++){
            Shark shark = list.get(t);
            int num = shark.num;
            int i = shark.i; int j = shark.j;
            if(num>=size) break;
            int check = bfs(i,j);
            if(check<=min){
                if(check==min){
                    if(minI==i){
                        if(minJ<j) continue;
                    }else if(minI<i) continue;
                }
                minI = i; minJ = j; idx = t; min = check;
            }
        }
        if(idx==-1) return;
        si = list.get(idx).i; sj = list.get(idx).j;
        map[list.get(idx).i][list.get(idx).j] = 0;
        list.remove(idx);
    }
    static int bfs(int ei,int ej){
        Queue<int[]> q= new ArrayDeque<>();
        boolean[][]visited = new boolean[N][N];
        visited[si][sj] = true;
        q.offer(new int[]{si,sj,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j =c[1]; int cnt = c[2];
            if(cnt>min) return 987654321;
            if(i==ei && j ==ej) return cnt;

            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj] && size>=map[ni][nj]){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni,nj,cnt+1});
                }
            }
        }
        return 987654321;
    }
}
