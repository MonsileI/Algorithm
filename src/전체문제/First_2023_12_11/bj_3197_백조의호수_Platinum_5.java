package 전체문제.First_2023_12_11;
import java.util.*;
import java.io.*;
public class bj_3197_백조의호수_Platinum_5 {
    static int N,M;
    static Queue<int[]> waterQueue,swanQueue;
    static char[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        int pi =-1;int pj=-1;
        int si = 0;int sj = 0;
        waterQueue = new ArrayDeque<>();
        swanQueue = new ArrayDeque<>();
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                char ch = str.charAt(j);
                map[i][j] = ch;
                if(ch=='L'){
                    if (pi == -1) {
                        pi = i;
                        pj = j;
                    }else {
                        si = i;
                        sj = j;
                    }
                    map[i][j] = '.';
                    waterQueue.offer(new int[]{i,j});
                }else if(ch=='.') waterQueue.offer(new int[]{i,j});
            }
        }
        int ans = 0;
        swanQueue.offer(new int[]{si,sj});
        visited[si][sj] = true;
        while(true){
            if(searchSwan(pi,pj)) break;
            melt();
            ans++;

        }
        System.out.println(ans);
    }
    static void melt(){
        int size = waterQueue.size();
        for(int tc=0;tc<size;tc++){
            int[]c = waterQueue.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]=='X'){
                    map[ni][nj] = '.';
                    waterQueue.offer(new int[]{ni,nj});
                }
            }
        }
    }
    static boolean searchSwan(int pi,int pj){
        Queue<int[]> q = new ArrayDeque<>();
        while(!swanQueue.isEmpty()){
            int[]c = swanQueue.poll();
            int i = c[0]; int j = c[1];
            if(i==pi&&j==pj) return true;
            for(int d=0;d<4;d++){
                int ni = i +move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj]){
                    visited[ni][nj] = true;
                    if(map[ni][nj]=='.'){
                        swanQueue.offer(new int[]{ni,nj});
                    }else if(map[ni][nj]=='X'){
                        q.offer(new int[]{ni,nj}); //다음 탐색을 위한 q offer()
                    }
                }
            }
        }

        swanQueue = q; //다음 swanQueue의 Searching은 바로 녹는 X 지점부터 하면 저렴해진다!
        return false;
    }
}
