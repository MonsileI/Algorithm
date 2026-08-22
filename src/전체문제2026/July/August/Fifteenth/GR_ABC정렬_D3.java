package 전체문제2026.July.August.Fifteenth;

import java.util.*;
import java.io.*;
public class GR_ABC정렬_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int N = 4;
        String aStr = br.readLine();
        String bStr = br.readLine();
        int[][]arr = new int[N][N];

        for(int i=0;i<len;i++){
            int a = aStr.charAt(i) - 'A';
            int b = bStr.charAt(i) - 'A';
            if(a==b) continue;
            arr[a][b]++;
        }
        int answer = 0;
        for(int i=0;i<N;i++){
            //a -> b 이고, b -> a 인 것 마이너스
            // ex) 1->0 , 0 -> 1 arr[i][i-1] = arr[i-1][i]
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
                arr[i][j] = 0;
                while(0<cnt){
                    int node = j;// j번째 노드를 0으로 만들어야 됨 사이클을 찾자!
                    while(node!=i){
                        for(int l=0;l<4;l++){
                            if(arr[node][l]!=0){
                                arr[node][l]--;
                                answer++;
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
