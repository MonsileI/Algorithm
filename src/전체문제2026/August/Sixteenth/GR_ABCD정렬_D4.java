package 전체문제2026.August.Sixteenth;

import java.util.*;
import java.io.*;
public class GR_ABCD정렬_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String aStr = br.readLine();
        String bStr = br.readLine();
        int N =4;
        int[][]arr = new int[N][N];
        for(int i=0;i<len;i++){
            int aCh = aStr.charAt(i) - 'A';
            int bCh = bStr.charAt(i) - 'A';
            if(aCh==bCh) continue;
            arr[aCh][bCh]++;
        }
        int answer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j] <= arr[j][i]){
                    answer += arr[i][j];
                    arr[j][i] -= arr[i][j];
                    arr[i][j] = 0;
                }else{
                    answer += arr[j][i];
                    arr[i][j] -= arr[j][i];
                    arr[j][i] = 0;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(arr[i][j]==0) continue;
                int cnt = arr[i][j];
                arr[i][j] =0;
                while(0 < cnt) {
                    int node = j;
                    while(node!=i) {
                        for (int l = 0; l < 4; l++) {
                            if (arr[node][l] != 0) {
                                answer++;
                                arr[node][l]--;
                                node = l;
                                break;
                            }
                        }
                    }
                    cnt--;
                }
            }
        }
        System.out.println(answer);
    }
}
