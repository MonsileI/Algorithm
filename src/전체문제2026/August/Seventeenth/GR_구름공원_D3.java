package 전체문제2026.August.Seventeenth;

import java.util.*;
import java.io.*;
public class GR_구름공원_D3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        st=  new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int max = arr[N-1];
        long last = 0;
        for(int i=0;i<N-1;i++) last += max - arr[i];
        long minAnswer=  0; int maxAnswer = max+M;
        if(M<=last){
            minAnswer = max;
        }else{
            M -= last;
            minAnswer = (M/N) + max;
            if(M%N!=0) minAnswer++;
        }
        System.out.println(minAnswer+" "+maxAnswer);
    }
}
