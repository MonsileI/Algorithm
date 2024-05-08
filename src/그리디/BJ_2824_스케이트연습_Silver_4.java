package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2824_스케이트연습_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[]arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int after = 0;
        long ans = 0;
        for(int i=N-1;-1<i;i--){
            if(after>=arr[i]) after = arr[i];
            else after++;
            ans += after;
        }
        System.out.println(ans);
    }
}
