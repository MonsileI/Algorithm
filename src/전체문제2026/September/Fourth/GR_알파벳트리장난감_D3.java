package 전체문제2026.September.Fourth;

import java.util.*;
import java.io.*;
public class GR_알파벳트리장난감_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] tree = new int[N][];
        int[][]minArr = new int[N][];
        int[][]maxArr = new int[N][];
        int size = 1;
        for(int i=0;i<N;i++){
            tree[i] = new int[size];
            minArr[i] = new int[size];
            maxArr[i] = new int[size];
            String str = br.readLine();
            for(int j=0;j<size;j++){
                tree[i][j] = (str.charAt(j) - 'A') + 1;
            }
            size *= 2;
        }
        size /= 2;
        minArr[0][0] = tree[0][0]; maxArr[0][0] = tree[0][0];

        for(int i=N-1;0<i;i--){
            int jIdx = 0;
            for(int j=0;j<size;j+=2){
                minArr[i][j] += tree[i][j];
                minArr[i][j+1] += tree[i][j+1];
                maxArr[i][j] += tree[i][j];
                maxArr[i][j+1] += tree[i][j+1];
                minArr[i-1][jIdx] += Math.min(minArr[i][j],minArr[i][j+1]);
                maxArr[i-1][jIdx] += Math.max(maxArr[i][j],maxArr[i][j+1]);
                jIdx++;
            }
            size /= 2;
        }
        System.out.println(minArr[0][0]+"\n"+maxArr[0][0]);
    }
}
