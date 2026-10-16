package 전체문제2026.October.Ninth;

import java.util.*;
import java.io.*;
public class SWEA_1767_프로세서연결하기 {
    static int N;
    static int[][]map;
    static int answer;
    static int INF = Integer.MAX_VALUE;
    static List<int[]> list;
    static int size;
    static int[][]move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int maxLen;
    static boolean[]visited;
    static int maxDepth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= null;
        StringBuilder sb= new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            answer = INF;
            list = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==1 && i!=0 && j!=0 && i!=N-1 && j!=N-1) list.add(new int[]{i,j});
                }
            }
            size = list.size();
            visited = new boolean[size];
            dfs(0,0);
            if(answer==INF){
                maxDepth = 0;
                visited=  new boolean[size];
                subDfs(0,0);
            }
            sb.append("#"+t+" "+answer+"\n");
        }
        System.out.println(sb.toString());
    }
    static void subDfs(int depth,int sum) {
        if (answer <= sum && depth < maxDepth) return;
        if (maxDepth  <= depth) {
            if(maxDepth<depth){
                answer = sum;
            }else{
                answer = Math.min(answer,sum);
            }
            maxDepth = depth;
        }
        for(int t=0;t<size;t++) {
            if (visited[t]) continue;
            int [] c = list.get(t);
            for (int d = 0; d < 4; d++) {
                int i = c[0];
                int j = c[1];
                boolean flag = true;
                int cnt = 0;
                while (true) {
                    i += move[d][0];
                    j += move[d][1];
                    if (i < 0 || j < 0 || N - 1 < i || N - 1 < j) break;
                    if (map[i][j] != 0) {
                        flag = false;
                        break;
                    }
                    cnt++;
                }
                if (flag) {
                    i = c[0];
                    j = c[1];
                    while (true) {
                        i += move[d][0];
                        j += move[d][1];
                        if (i < 0 || j < 0 || N - 1 < i || N - 1 < j) break;
                        map[i][j] = 2;
                    }
                    visited[t] = true;
                    subDfs(depth + 1, sum + cnt);
                    visited[t] = false;
                    i = c[0];
                    j = c[1];
                    while (true) {
                        i += move[d][0];
                        j += move[d][1];
                        if (i < 0 || j < 0 || N - 1 < i || N - 1 < j) break;
                        map[i][j] = 0;
                    }
                }
            }
        }
    }
    static void dfs(int depth,int sum){
        if(answer<=sum) return;
        if(depth==size){
            answer = sum;
            return;
        }
        int[] c = list.get(depth);
        for (int d = 0; d < 4; d++) {
            int i = c[0];
            int j = c[1];
            boolean flag = true;
            int cnt = 0;
            while (true) {
                i += move[d][0];
                j += move[d][1];
                if (i < 0 || j < 0 || N - 1 < i || N - 1 < j) break;
                if (map[i][j] != 0) {
                    flag = false;
                    break;
                }
                cnt++;
            }
            if (flag) {
                i = c[0];
                j = c[1];
                while (true) {
                    i += move[d][0];
                    j += move[d][1];
                    if (i < 0 || j < 0 || N - 1 < i || N - 1 < j) break;
                    map[i][j] = 2;
                }
                dfs(depth + 1, sum + cnt);
                i = c[0];
                j = c[1];
                while (true) {
                    i += move[d][0];
                    j += move[d][1];
                    if (i < 0 || j < 0 || N - 1 < i || N - 1 < j) break;
                    map[i][j] = 0;
                }
            }
        }
    }
}
