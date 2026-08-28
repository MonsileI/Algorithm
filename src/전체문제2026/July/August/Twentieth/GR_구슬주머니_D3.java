package 전체문제2026.July.August.Twentieth;

import java.util.*;
import java.io.*;
public class GR_구슬주머니_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        int[][]arr = new int[N+1][2];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=N;i++){
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
            sum += arr[i][0];
        }
        Arrays.sort(arr,(o1,o2) -> o1[0]-o2[0]);
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=N;i++){
            long tmp = sum - arr[i][0];
            if(i==N){
                if(tmp==(arr[N-1][0]*2)){
                    list.add(arr[i][1]);
                }
            }else{
                if(tmp==(arr[N][0]*2)){
                    list.add(arr[i][1]);
                }
            }
        }
        StringBuilder sb= new StringBuilder();
        sb.append(list.size()+"\n");
        Collections.sort(list);
        for(int num : list) sb.append(num+" ");

        System.out.println(sb.toString());
    }
}
