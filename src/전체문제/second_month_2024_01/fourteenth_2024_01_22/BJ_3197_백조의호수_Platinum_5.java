package 전체문제.second_month_2024_01.fourteenth_2024_01_22;
import java.util.*;
import java.io.*;
public class BJ_3197_백조의호수_Platinum_5 {
    static int N,M;
    static boolean[][]visited;
    static char[][]map;
    static int ei,ej,si,sj;
    static int[][]move=  {{-1,0},{0,1},{1,0},{0,-1}};
    static Queue<int[]> swanQ;
    static Queue<int[]> waterQ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        swanQ = new ArrayDeque<>();
        waterQ = new ArrayDeque<>();
        map = new char[N][M];
        si = 0; sj = 0;
        boolean flag = false;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j]= str.charAt(j);
                if(map[i][j]=='L'){
                    if(!flag) {
                        si = i;
                        sj = j;
                        flag = true;
                    }else{
                        ei = i ; ej = j;
                    }
                     map[i][j] = '.';
                    waterQ.offer(new int[]{i,j});
                }else if(map[i][j]=='.'){
                    waterQ.offer(new int[]{i,j});
                }

            }
        }
        swanQ.offer(new int[]{si,sj});
        visited[si][sj] = true;
        while(true){
            if(bfs())break;
            melt();
            ans++;
        }
        System.out.println(ans);
    }
    static void melt(){
        int size = waterQ.size();
        for(int t=0;t<size;t++){
            int[]c = waterQ.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]=='X'){
                    map[ni][nj] = '.';
                    waterQ.offer(new int[]{ni,nj});
                }
            }
        }
    }

    static boolean bfs(){
        Queue<int[]> q= new ArrayDeque<>();
        while(!swanQ.isEmpty()){
            int[]c = swanQ.poll();
            int i = c[0]; int j = c[1];
            if(i==ei&&j==ej) return true;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]){
                    visited[ni][nj] = true;
                    if(map[ni][nj]=='X'){
                        q.offer(new int[]{ni,nj});
                    }
                    else swanQ.offer(new int[]{ni,nj});
                }
            }
        }
        swanQ = q;
        return false;
    }
}
