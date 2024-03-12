package 전체문제.fourth_month_2024_03.ninth_2024_03_12;
import java.util.*;
import java.io.*;
public class BJ_16234_인구이동_Gold_4 {
    static int N;
    static int L,R;
    static int [][]map;
    static boolean [][]visited;
    static boolean flag;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        while(true){
            flag = false;
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){
                        bfs(i,j);
                    }
                }
            }
            if(!flag) break;
            time++;
        }
        System.out.println(time);
    }
    static void bfs(int y, int x){
        Queue<int[]> q= new ArrayDeque<>();
        visited[y][x] = true;
        List<int[]> list = new ArrayList<>();
        int sum  = map[y][x];
        int cnt = 1;
        list.add(new int[]{y,x});
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int [] c= q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(!visited[ni][nj]){
                    int diff = Math.abs(map[i][j]-map[ni][nj]);
                    if(L<=diff&&diff<=R){
                        cnt++;
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni,nj});
                        list.add(new int[]{ni,nj});
                        sum += map[ni][nj];
                    }
                }
            }
        }
        if(cnt>1){
            flag = true;
            int change = sum/cnt;
            for(int [] i : list) map[i[0]][i[1]] = change;
        }
    }
}
