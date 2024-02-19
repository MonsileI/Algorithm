package 전체문제.third_month_2024_02.tenth_2024_02_19;
import java.util.*;
import java.io.*;
public class BJ_3184_양_Silver_1 {
    static char[][]map;
    static int s,w;
    static int N,M;
    static boolean[][]visited;
    static int[][]dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            String str =br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='o') s++;
                if(map[i][j]=='v') w++;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&(map[i][j]=='o'||map[i][j]=='v')){
                    visited[i][j] = true;
                    bfs(i,j);
                }
            }
        }
        System.out.println(s+" "+w);
    }
    static void bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        int sheep = 0; int wolf = 0;
        if(map[y][x]=='o')sheep++;
        else wolf++;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i =c[0]; int j=c[1];
            for(int d=0;d<4;d++){
                int ni = i + dir[d][0];
                int nj = j + dir[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) return;
                if(map[ni][nj]!='#'&&!visited[ni][nj]){
                    visited[ni][nj] = true;
                    if(map[ni][nj]=='v')wolf++;
                    if(map[ni][nj]=='o')sheep++;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        if(wolf>=sheep) s -= sheep;
        else w -= wolf;
    }
}
