package 전체문제2025.December.Eight;

import java.util.*;
import java.io.*;
public class BJ_4396_지뢰찾기_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        char[][]originMap = new char[N][N];
        for(int i=0;i<N;i++) originMap[i] = br.readLine().toCharArray();
        boolean flag = true;
        char[][]map = new char[N][N];
        int[][]move = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j);
                if(originMap[i][j]=='*' && map[i][j]=='x'){
                    flag = false;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]=='.') {
                    if(flag==false){
                        if(originMap[i][j]=='*'){
                            sb.append('*');
                        }else{
                            sb.append('.');
                        }
                    }else {
                        sb.append('.');
                    }
                }
                else{
                    if(originMap[i][j]=='*'){
                        sb.append('*');
                    }else {
                        int cnt = 0;
                        for (int d = 0; d < 8; d++) {
                            int ni = i + move[d][0];
                            int nj = j + move[d][1];
                            if (ni < 0 || nj < 0 || N - 1 < ni || N - 1 < nj) continue;
                            if (originMap[ni][nj] == '*') cnt++;
                        }
                        sb.append(cnt);
                    }
                }
            }
            if(i==N-1) break;
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
