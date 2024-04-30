package 전체문제.fifth_month_2023_04.twentieth_2024_04_29;

import java.util.*;
import java.io.*;
public class BJ_11650_좌표정렬하기_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int[][]arr= new int[N][2];
        StringTokenizer st = null;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(o1,o2)->o1[0]==o2[0] ? o1[1]-o2[1] : o1[0] - o2[0]);
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(arr[i][0]+" "+arr[i][1]+"\n");
        }
        System.out.println(sb.toString());
    }
}
