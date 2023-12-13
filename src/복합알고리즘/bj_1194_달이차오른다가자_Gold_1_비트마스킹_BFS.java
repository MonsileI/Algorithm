package 복합알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1194_달이차오른다가자_Gold_1_비트마스킹_BFS {
    public static void main(String[] args) throws Exception {
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][]map = new char[N][M];
        int si = 0 ; int sj = 0;
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(map[i][j]=='0'){
                    map[i][j] = '.';
                    si = i ; sj = j;
                }
            }
        }
        int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
        boolean[][][]visited = new boolean[N][M][64]; //63가지 ABCDEF
        Queue<int[]> q =new ArrayDeque<>();
        q.offer(new int[]{si,sj,0,0});
        int answer = -1;
        while(!q.isEmpty()){
            int []c = q.poll();
            int i = c[0]; int j = c[1]; int key = c[2];int cnt = c[3];
            if(map[i][j]=='1'){
                answer = cnt;
                break;
            }
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(map[ni][nj]=='#') continue;
                if(visited[ni][nj][key]) continue;
                //열쇠일 경우
                if('a'<=map[ni][nj]&&map[ni][nj]<='f'){
                    int newKey = key | (1<<(map[ni][nj]-'a'));
                    visited[ni][nj][newKey] = true;
                    q.offer(new int[]{ni,nj,newKey,cnt+1});
                    //문일 경우
                }else if('A'<=map[ni][nj]&&map[ni][nj]<='F'){
                    if((key & (1<<map[ni][nj]-'A'))!=0){
                        visited[ni][nj][key] = true;
                        q.offer(new int[]{ni,nj,key,cnt+1});
                    }
                }else {
                    visited[ni][nj][key] = true;
                    q.offer(new int[]{ni, nj, key, cnt + 1});
                }
            }

        }
        System.out.println(answer);
    }
}
