package 구현.누적합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_외계인과용돈기입장_Level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[]arr = new long[N+1];
        long sum = 0;
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<N+1;i++){
            String value = st.nextToken();
            if(value.charAt(0)=='+') {
                sum += Integer.parseInt(value.substring(1,value.length()));
            }else sum -= Integer.parseInt(value.substring(1,value.length()));
            arr[i] = sum;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            long value = 0;
            if(s==0) value = arr[e];
            else value = arr[e] - arr[s-1];
            if(value>0) sb.append("+");
            sb.append(value+"\n");
        }
        System.out.println(sb.toString());
    }
}
