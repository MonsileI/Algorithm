package 전체문제2025.September.Tenth;

import java.util.*;
import java.io.*;
public class BJ_1080_행렬_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] originMap = new char[N][M];
        for (int i = 0; i < N; i++) originMap[i] = br.readLine().toCharArray();
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        int cnt = 0;
        boolean flag = true;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (map[i][j] != originMap[i][j]) {
                    cnt++;
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            if (map[k][l] == '0') map[k][l] = '1';
                            else map[k][l] = '0';
                        }
                    }
                }
            }
        }
        OuterLoop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != originMap[i][j]) {
                    flag = false;
                    break OuterLoop;
                }
            }
        }
        if(!flag) cnt = -1;
        System.out.println(cnt);
    }
}
