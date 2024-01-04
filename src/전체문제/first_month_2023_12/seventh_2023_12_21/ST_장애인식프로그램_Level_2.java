package 전체문제.first_month_2023_12.seventh_2023_12_21;
import java.util.*;
import java.io.*;
public class ST_장애인식프로그램_Level_2 {
    static int N;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static char[][]map;
    static List<Integer>list;
    static boolean[][]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++)map[i] = br.readLine().toCharArray();
        int cnt = 0;
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]=='1'&&!visited[i][j]){
                    visited[i][j] = true;
                    cnt++;
                    list.add(bfs(i,j));
                }
            }
        }
        Collections.sort(list);
        StringBuilder sb=  new StringBuilder();
        sb.append(cnt+"\n");
        for(int i : list) sb.append(i+"\n");
        System.out.println(sb.toString());
    }
        static int bfs(int y,int x){
            int cnt = 1;
            Queue<int[]>q = new ArrayDeque<>();
            q.offer(new int[]{y,x});
            while(!q.isEmpty()){
                int[]c = q.poll();
                int i  = c[0]; int j = c[1];
                for(int d=0;d<4;d++){
                    int ni = i + move[d][0];
                    int nj = j + move[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if(map[ni][nj]=='1'&&!visited[ni][nj]){
                        visited[ni][nj] = true;
                        cnt++;
                        q.offer(new int[]{ni,nj});
                    }
                }
            }
            return cnt;
        }
}
