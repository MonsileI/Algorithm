package 전체문제2026.September.Second;

import java.util.*;
import java.io.*;
public class GR_제설작전_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N+1];
        for(int i=1;i<=N;i++)arr[i] = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(br.readLine());
        int[]sop = new int[L];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<L;i++) sop[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(sop);
        int rock = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<rock;i++) {
            int r = Integer.parseInt(st.nextToken());
            arr[r] = -1;
        }
        for(int i=1;i<=N;i++){
            if(arr[i]==-1) continue;
            if(arr[i-1]!=-1) {
                arr[i] += arr[i - 1];
            }
        }
        int max = 0;
        int ans = 0;
        for(int s : sop){
            int cnt=0;
            for(int i=1;i<=N;i++){
                if(arr[i]==-1){
                    cnt = 0;
                    continue;
                }
                cnt++;
                if(cnt==s) {
                    cnt = i;
                    break;
                }
            }
            if(cnt<s) continue;
            for(int i=cnt;i<=N;i++){
                if(arr[i]==-1){
                    i = (i+1);
                    continue;
                }
                int tmp = arr[i-s];
                if(tmp==-1) tmp = 0;
                if(max<(arr[i] - tmp)){
                    max = arr[i] - tmp;
                    ans = s;
                }
            }
        }
        System.out.println(ans+" "+max);
    }
}
