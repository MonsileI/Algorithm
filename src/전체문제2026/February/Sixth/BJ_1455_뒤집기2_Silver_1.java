package 전체문제2026.February.Sixth;

import java.util.*;
import java.io.*;
public class BJ_1455_뒤집기2_Silver_1 {
    static char[][]map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer = 0;
        map = new char[N][M];
        for(int i=0;i<N;i++) map[i] = br.readLine().toCharArray();
        for(int i=N-1;-1<i;i--){
            for(int j=M-1;-1<j;j--){
                if(map[i][j]=='1'){
                    changeMap(i,j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
    static void changeMap(int y,int x){
        for(int i=y;-1<i;i--){
            for(int j=x;-1<j;j--){
                map[i][j] = map[i][j] == '1' ? '0' : '1';
            }
        }
    }
}
