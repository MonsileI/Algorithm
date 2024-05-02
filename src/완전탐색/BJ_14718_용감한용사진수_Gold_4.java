package 완전탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14718_용감한용사진수_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][]arr = new int[N][3];
        int min = 3000000;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a; arr[i][1] =b; arr[i][2] = c;
        }
        int[]ans = new int[3];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int l=0;l<N;l++){
                    int cnt = 0;
                    for(int k=0;k<N;k++){
                        if(arr[i][0]>=arr[k][0] && arr[j][1] >= arr[k][1] && arr[l][2] >= arr[k][2]){
                            cnt++;
                        }
                    }
                    if(K<=cnt) min = Math.min(min,arr[i][0]+arr[j][1]+arr[l][2]);
                }
            }
        }
        System.out.println(min);


    }
}
