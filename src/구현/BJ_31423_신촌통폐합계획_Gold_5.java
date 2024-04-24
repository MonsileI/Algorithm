package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_31423_신촌통폐합계획_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[]arr = new String[N+1];
        int[]next = new int[N+1]; int[] tail = new int[N+1];
        for(int i=1;i<N+1;i++){
            arr[i] = br.readLine();
            tail[i] = i;
        }
        StringTokenizer st=  null;
        int cur = -1; //현재 노드
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            next[tail[a]] = b;
            tail[a] = tail[b];
            cur = a;
        }
        StringBuilder sb = new StringBuilder();
        while(cur!=0){
            sb.append(arr[cur]);
            cur = next[cur];
        }
        System.out.println(sb.toString());
    }
}
