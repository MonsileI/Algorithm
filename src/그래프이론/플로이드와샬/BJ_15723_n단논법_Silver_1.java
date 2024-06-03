package 그래프이론.플로이드와샬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15723_n단논법_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] check = new boolean[26][26];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            String[]tmp = br.readLine().split(" ");
            int a = tmp[0].charAt(0) - 'a';
            int b = tmp[2].charAt(0) - 'a';
            check[a][b] = true;
        }
        StringBuilder sb= new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int l=0;l<26;l++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(i==j) check[i][j] = true;
                    if(check[i][l]&&check[l][j]) check[i][j] = true;
                }
            }
        }
        for(int i=0;i<M;i++){
            String [] tmp = br.readLine().split(" ");
            int a = tmp[0].charAt(0) - 'a';
            int b = tmp[2].charAt(0) - 'a';
            if(check[a][b]) sb.append("T");
            else sb.append("F");
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
