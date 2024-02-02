package 전체문제.third_month_2024_02.second_2024_02_02;
import java.util.*;
import java.io.*;
public class BJ_17503_맥주축제_Silver_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][]arr = new int[K][2];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->o1[1]==o2[1] ? -(o1[0]-o2[0]) : o1[1]-o2[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int total = 0;
        int ans = -1;
        for(int i=0;i<K;i++){
            pq.offer(arr[i][0]);
            total += arr[i][0];

            if(pq.size()>N){
                total -= pq.poll();
            }
            if(pq.size()==N && total >= M){
                ans = arr[i][1];
                break;
            }
        }
        System.out.println(ans);
    }
}
