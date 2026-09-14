package 전체문제2026.September.Sixth;

import java.util.*;
import java.io.*;
public class GR_단풍나무_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]dir = {{-1,0},{0,1},{1,0},{0,-1}};
        int[][]map = new int[N][N];
        Queue<int[]> q= new ArrayDeque<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]!=0) q.offer(new int[]{i,j});
            }
        }
        int day = 0;

        while(true){
            int size = q.size();
            if(size==0) break;
            List<int[]> list = new ArrayList<>();
            for(int t=0;t<size;t++){
                int[]c = q.poll();
                int i = c[0]; int j =c[1];
                int cnt = 0;
                for(int d=0;d<4;d++){
                    int ni = i + dir[d][0];
                    int nj = j + dir[d][1];
                    if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                    if(map[ni][nj]==0) cnt++;
                }
                if(cnt < map[i][j]) q.offer(new int[]{i,j});
                list.add(new int[]{i,j,cnt});
            }
            for(int [] node: list){
                map[node[0]][node[1]] = Math.max(0,map[node[0]][node[1]] - node[2]);
            }
            day++;
        }
        System.out.println(day);
    }
}
