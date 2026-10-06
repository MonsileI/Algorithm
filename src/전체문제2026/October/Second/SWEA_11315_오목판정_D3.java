package 전체문제2026.October.Second;

import java.util.*;
import java.io.*;
public class SWEA_11315_오목판정_D3 {
    static int N;
    static char[][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int t=1;t<=TC;t++){
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
            boolean flag = false;
            OuterLoop:
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]=='o'){
                        if(check(i,j)) {
                            flag = true;
                            break OuterLoop;
                        }
                    }
                }
            }
            sb.append("#"+t+" ");
            if(flag) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb.toString());
    }
    static boolean check(int y,int x){
        //가로
        boolean flag = true;
        if(y+4<N) {
            for (int i = 1; i <= 4; i++) {
                if(map[y+i][x]=='.'){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        flag = true;
        //세로
        if(x+4<N){
            for (int j = 1; j <= 4; j++) {
                if(map[y][x+j]=='.'){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        flag = true;
        //왼쪽아래
        if(y+4<N && x+4<N){
            for (int l = 1; l <= 4; l++) {
                if(map[y+l][x+l]=='.'){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        flag = true;
        //왼쪽위
        if(3<y && x+4<N){
            for (int l = 1; l <= 4; l++) {
                if(map[y-l][x+l]=='.'){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
        }
        return false;
    }
}
