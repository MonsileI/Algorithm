package 전체문제.fourth_month_2024_03.fourteenth_2024_03_19;
import java.util.*;
import java.io.*;
public class BJ_202_보석도둑_Gold_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        int[]beg = new int[M];
        //0이 무게, 1이 가격
        for(int i=0;i<M;i++) beg[i] = Integer.parseInt(br.readLine());
        Arrays.sort(beg);
        Arrays.sort(arr,(o1,o2)-> o1[0]==o2[0] ? -(o1[1]-o2[1]) : o1[0] - o2[0]);
        long sum = 0;
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1-o2));
        for(int i=0;i<M;i++){
            int b = beg[i];
            while( idx<N && arr[idx][0]<=b){
                pq.offer(arr[idx][1]);
                idx++;
            }
            if(!pq.isEmpty()){
                sum += pq.poll();
            }
        }
        System.out.println(sum);
    }
}
