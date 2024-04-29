package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_31778_PPC만들기_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N =  Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        int idx = 0;
        OuterLoop:
        for(int i =N-1;-1<i;i--){
            if(arr[i]=='P'){
                while(true){
                    if(arr[idx]=='C'){
                        arr[idx] = 'P';
                        arr[i] = 'C';
                        K--;
                        if(K==0) break OuterLoop;
                        break;
                    }
                    idx++;
                    if(idx>=i) break OuterLoop;
                }
            }
        }
        long ans =  0;
        int cnt = 0;
        long[]dp = new long[200001];
        if(N<3) System.out.println(0);
        else {
            for (int i = 2; i < 200001; i++) dp[i] = dp[i - 1] + (i - 1);
            for (int i = 0; i < N; i++) {
                if (arr[i] == 'C') {
                    ans += dp[cnt];
                } else cnt++;
            }
            System.out.println(ans);
        }
    }
}
