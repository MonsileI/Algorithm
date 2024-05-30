package 전체문제.sixth_month_2024_05.twentieth_2024_05_30;

import java.util.*;
import java.io.*;
public class BJ_20207_달력_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][]arr =new int[N][2];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int start = arr[0][0];
        int end = arr[0][1];
        int ans = 0;
        pq.offer(arr[0][1]);
        for(int i=1;i<N;i++){
            if(end+1<arr[i][0]) {
                ans += (pq.size()*(end-start+1));
                pq.clear();
                start = arr[i][0];
            }
            if(!pq.isEmpty()&&pq.peek()<arr[i][0]) pq.poll();
            pq.offer(arr[i][1]);
            end = Math.max(end,arr[i][1]);
        }
        if(!pq.isEmpty()){
            ans += (pq.size()*(end-start+1));
        }
        System.out.println(ans);
    }
}
