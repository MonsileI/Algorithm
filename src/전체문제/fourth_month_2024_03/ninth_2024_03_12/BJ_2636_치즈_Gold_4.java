package 전체문제.fourth_month_2024_03.ninth_2024_03_12;
import java.util.*;
import java.io.*;
public class BJ_2636_치즈_Gold_4 {
    static int N,M;
    static int[][]map;
    static int cz;
    static int [][]move ={{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)cz++;
            }
        }
        int time = 0;
        int last = 0;
        while(true){
            time++;
            last = bfs(0,0);
            if(cz==0) break;
        }
        System.out.println(time+"\n"+last);
    }
    static int bfs(int y,int x){
        Queue<int[]> q= new ArrayDeque<>();
        boolean[][]visited=  new boolean[N][M];
        List<int[]> list = new ArrayList<>();
        int cnt = 0;
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0];int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]){
                    visited[ni][nj] = true;
                    if(map[ni][nj]==1){
                        map[ni][nj] = 2;
                        cnt++;
                        cz--;
                        list.add(new int[]{ni,nj});
                    }
                    if(map[ni][nj]==0){
                        q.offer(new int[]{ni,nj});
                    }
                }
            }
        }
        for(int [] i : list) map[i[0]][i[1]] =0;
        return cnt;
    }
}
