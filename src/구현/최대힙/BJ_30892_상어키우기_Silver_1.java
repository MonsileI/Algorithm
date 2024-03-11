package 구현.최대힙;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_30892_상어키우기_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long ans = Integer.parseInt(st.nextToken());
        int[]arr =new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->-(o1-o2));
        int cnt = 0;
        for(int i=0;i<N;i++){
            while(idx<N && arr[idx]<ans){
                pq.offer(arr[idx++]);
            }
            if(!pq.isEmpty()){
                ans += pq.poll();
                M--;
            }else break;
            if(M==0) break;
        }
        System.out.println(ans);
    }
}
