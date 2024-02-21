package 두포인터;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13144_ListOfUniqueNumbers_Gold_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N+1];
        int max = 0;
        for(int i=1;i<N+1;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }
        int[]dist = new int[max+1];
        long ans = 0;
        int L = 1; int R = 0;
        while(L<=N){
            while(R+1<=N && dist[arr[R+1]]==0){
                R++;
                dist[arr[R]]++;
            }
            ans += R - L + 1;

            dist[arr[L++]]--;
        }
        System.out.println(ans);

    }
}
