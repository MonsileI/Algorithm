package 전체문제2026.November.Fourteenth;

import java.util.*;
import java.io.*;
public class BJ_2931_회의실배정_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i][0] = start;
            arr[i][1] = end;
        }
        Arrays.sort(arr,(o1,o2) -> o1[1]==o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int answer = 1;
        int end = arr[0][1];
        for(int i=1;i<N;i++){
            if(arr[i][0]<end) continue;
            answer++;
            end = arr[i][1];
        }
        System.out.println(answer);
    }
}
