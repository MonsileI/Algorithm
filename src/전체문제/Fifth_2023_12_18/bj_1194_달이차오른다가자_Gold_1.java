package 전체문제.Fifth_2023_12_18;
import java.util.*;
import java.io.*;
public class bj_1194_달이차오른다가자_Gold_1 {
    static int N;
    static int M;
    static char[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int si=0; int sj=0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='0'){
                    si = i; sj = j;
                    map[i][j] = '.';
                }
            }
        }
        System.out.println(bfs(si,sj));
    }
    static int bfs(int si,int sj){
        boolean [][][]visited = new boolean[N][M][64];
        visited[si][sj][0] = true;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{si,sj,0,0});
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1]; int key = c[2]; int cnt = c[3];
            if(map[i][j]=='1') return cnt;
            for(int d=0;d<4;d++){
                int ni = i + move[d][0]; int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(visited[ni][nj][key]) continue;
                if(map[ni][nj]=='#') continue;
                if(map[ni][nj] >= 'a' && map[ni][nj] <='f'){
                    int newKey = key | (1<<map[ni][nj] - 'a');
                    visited[ni][nj][newKey] = true;
                    q.offer(new int[]{ni,nj,newKey,cnt+1});

                }else if(map[ni][nj]>='A' && map[ni][nj] <='F'){
                    if((key & (1<<map[ni][nj]-'A'))!=0) {
                        visited[ni][nj][key] = true;
                        q.offer(new int[]{ni,nj,key,cnt+1});
                    }
                }else {
                    visited[ni][nj][key] = true;
                    q.offer(new int[]{ni,nj,key,cnt+1});
                }

            }
        }


        return -1;
    }
}

