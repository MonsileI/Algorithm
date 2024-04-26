package 전체문제.fifth_month_2023_04.eighteenth_2024_04_26;

import java.util.*;
import java.io.*;
public class BJ_15702_중간고사채점_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int Q =Integer.parseInt(st.nextToken());
        int N =Integer.parseInt(st.nextToken());
        int [] score = new int[Q+1];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=1;i<Q+1;i++) score[i] = Integer.parseInt(st.nextToken());
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            for(int j=1;j<Q+1;j++){
                char ch = st.nextToken().charAt(0);
                if(ch=='O') arr[i][1] += (score[j]);
            }
        }
        Arrays.sort(arr,(o1,o2)->o1[1]==o2[1] ? o1[0] - o2[0] : -(o1[1]-o2[1]));
        System.out.println(arr[0][0]+" "+arr[0][1]);
    }
}
