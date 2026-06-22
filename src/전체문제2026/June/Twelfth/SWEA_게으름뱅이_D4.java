package 전체문제2026.June.Twelfth;

import java.util.*;
import java.io.*;
public class SWEA_게으름뱅이_D4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb=  new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        while(0<TC){
            int N = Integer.parseInt(br.readLine());
            int[][]arr = new int[N][2];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                arr[i][0] = Integer.parseInt(st.nextToken()); //걸리는 시간
                arr[i][1] = Integer.parseInt(st.nextToken()); //deadLine
            }
            Arrays.sort(arr,(o1,o2) -> Integer.compare(o2[1],o1[1]));
            int end = arr[0][1] - arr[0][0];
            for(int i=1;i<N;i++){
                int takeTime = arr[i][0];
                int deadLine = arr[i][1];
                if(deadLine<end) end = deadLine;
                end -= takeTime;
            }
            sb.append(end+"\n");
            TC--;
        }
        System.out.println(sb.toString());
    }
}
