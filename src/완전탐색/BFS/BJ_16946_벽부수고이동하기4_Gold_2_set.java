package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16946_벽부수고이동하기4_Gold_2_set {
    static int N,M;
    static int[][]map;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;
    static Map<Integer,Integer> hMap;
    static Set<Integer> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++){
            String str =br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        hMap = new HashMap<>();
        visited=  new boolean[N][M];
        int idx = 2;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(!visited[i][j]&&map[i][j]==0){
                    int sum = bfs(i,j,idx);
                    hMap.put(idx,sum);
                    idx++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1){
                    set = new HashSet<>();
                    int sum = 1;
                    for(int d=0;d<4;d++){
                        int ni = i + move[d][0];
                        int nj = j + move[d][1];
                        if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                        if(map[ni][nj]==1) continue;
                        set.add(map[ni][nj]);
                    }
                    for(Integer num : set) sum += hMap.get(num);
                    sb.append((sum%10));
                }else sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int bfs(int y,int x,int idx){
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;
        map[y][x] = idx;
        int cnt = 1;
        while(!q.isEmpty()){
            int[]c = q.poll();
            int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||M-1<nj) continue;
                if(!visited[ni][nj] && map[ni][nj]==0){
                    visited[ni][nj] = true;
                    map[ni][nj] = idx;
                    q.offer(new int[]{ni,nj});
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
