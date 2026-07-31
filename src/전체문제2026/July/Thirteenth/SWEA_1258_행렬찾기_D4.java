package 전체문제2026.July.Thirteenth;

import java.util.*;
import java.io.*;
public class SWEA_1258_행렬찾기_D4 {
    static int N;
    static int [][]map;
    static int [][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][]visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = null;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //우선순위 : 크기 -> 행
            List<int[]> list = new ArrayList<>();
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j] && map[i][j]!=0){
                        visited[i][j] = true;
                        int []result = bfs(i,j);
                        list.add(new int[]{result[0],result[1],result[2]}); //사이즈 i j (여기서 j가 행의 차이)
                    }
                }
            }
            Collections.sort(list,(o1,o2)->o1[0] == o2[0] ? o1[1] - o2[1] : o1[0]-o2[0]);
            sb.append("#"+t+" "+list.size()+" ");
            for(int i=0;i<list.size();i++){
                sb.append(list.get(i)[1]+" "+list.get(i)[2]);
                if(i==list.size()-1) break;
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static int[] bfs(int y,int x){
        int minI = y; int minJ = x;
        int maxI = y; int maxJ = x;
        Queue<int[]> q= new ArrayDeque<>();
        q.offer(new int[]{y,x});
        while(!q.isEmpty()){
            int[]c = q.poll(); int i = c[0]; int j = c[1];
            for(int d=0;d<4;d++){
                int ni = i + move[d][0];
                int nj = j + move[d][1];
                if(ni<0||nj<0||N-1<ni||N-1<nj) continue;
                if(map[ni][nj]==0) continue;
                if(visited[ni][nj]) continue;
                visited[ni][nj] = true;
                maxI = Math.max(maxI,ni);
                maxJ = Math.max(maxJ,nj);
                q.offer(new int[]{ni,nj});
            }
        }
        int diffI = maxI - minI;
        int diffJ = maxJ - minJ;
        diffI++;
        diffJ++;
        return new int[]{(diffI * diffJ),diffI,diffJ};
    }
}
