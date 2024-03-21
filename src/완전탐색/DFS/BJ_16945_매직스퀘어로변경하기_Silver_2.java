package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16945_매직스퀘어로변경하기_Silver_2 {
    static int [][]map;
    static boolean [][] visited;
    static int answer = 987654321;
    static int [][] checkMap;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[3][3];
        checkMap = new int[3][3];
        StringTokenizer st=  null;
        for(int i=0;i<3;i++){
            st =new StringTokenizer(br.readLine()," ");
            for(int j=0;j<3;j++){
                checkMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited=  new boolean[3][3];
        dfs(1);
        System.out.println(answer);
    }
    static void dfs(int depth){
        if(depth==10){
            boolean flag = true;
            int origin = map[0][0]+map[0][1]+map[0][2];
            for(int i=1;i<3;i++){
                int garo = 0;
                for(int j=0;j<3;j++){
                    garo += map[i][j];
                }
                if(origin!=garo) return;
            }
            for(int j=0;j<3;j++){
                int sero = 0;
                for(int i=0;i<3;i++){
                    sero += map[i][j];
                }
                if(origin!=sero) return;
            }
            int left = map[0][0] + map[1][1] + map[2][2];
            if(left!=origin) return;
            int right = map[0][2] + map[1][1] + map[2][0];
            if(right!=origin) return;


            int sum = 0;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(map[i][j]!=checkMap[i][j]){
                        sum += Math.abs(map[i][j]-checkMap[i][j]);
                        if(sum>=answer) return;
                    }
                }
            }
            answer = Math.min(answer,sum);
            return;
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    map[i][j] = (depth);
                    dfs(depth+1);
                    visited[i][j] = false;
                }
            }
        }
    }
}
