package 전체문제2026.February.First;

import java.util.*;
import java.io.*;
public class BJ_2580_스도쿠_Gold_4 {
    static int N;
    static int[][]map;
    static boolean flag;
    static List<int[]> zeroList;
    static int len;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = 9;
        map = new int[N][N];
        zeroList = new ArrayList<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0){
                    zeroList.add(new int[]{i,j});
                }
            }
        }
        sb = new StringBuilder();
        len = zeroList.size();
        dfs(0);
        System.out.println(sb.toString());
    }
    static void dfs(int depth){

        if(flag) return;
        if(depth==len){
            flag = true;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++){
                    sb.append(map[i][j]+" ");
                }
                sb.append("\n");
            }
            return;
        }
        int y = zeroList.get(depth)[0];
        int x = zeroList.get(depth)[1];
        boolean[]isPossible = new boolean[N+1];
        //가로,세로 체크
        for(int t=0;t<N;t++){
            isPossible[map[t][x]] =  isPossible[map[y][t]] = true;
        }
        int ny = 0;
        int nx = 0;
        //아홉개 체크
        if(y<3) ny = 0;
        else if(y<6) ny=3;
        else ny=6;
        if(x<3) nx= 0;
        else if(x<6) nx = 3;
        else nx = 6;
        for(int i=ny;i<ny+3;i++){
            for(int j=nx;j<nx+3;j++){
                isPossible[map[i][j]] = true;
            }
        }
        for(int i=1;i<N+1;i++){
            if(!isPossible[i]){
                map[y][x] = i;
                dfs(depth+1);
                map[y][x] = 0;
            }
        }
    }
}
