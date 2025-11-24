package 전체문제2025.November.Seventh;

import java.util.*;
import java.io.*;
public class BJ_1246_온라인판매_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Integer[]arr = new Integer[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr,(o1,o2) -> -(o1-o2));
        int answer = 0;
        int price = 0;
        for(int i=0;i<N;i++){
            int tmp  = 0;
            if(M<(i+1)){
                tmp = arr[i] * M;
            }else {
                tmp = (i + 1) * arr[i];
            }
            if(answer < tmp){
                answer = Math.max(answer,tmp);
                price = arr[i];
            }
        }
        System.out.println(price+" "+answer);
    }
}
