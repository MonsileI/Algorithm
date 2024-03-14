package 전체문제.fourth_month_2024_03.eleventh_2024_03_14;
import java.util.*;
import java.io.*;
public class GR_계수기만들기_Level_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int[][]arr = new int[N][2];
        for(int i=0;i<N;i++)arr[i][0] = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arr[i][1] = Integer.parseInt(st.nextToken());
        //0이 최대값, 1이 초기값
        int turn = Integer.parseInt(br.readLine());
        while(0<turn){
            int idx = N-1;
            while(-1<idx){
                arr[idx][1]++;
                if(arr[idx][1]>arr[idx][0]) {
                    arr[idx][1] = 0;
                    idx--;
                }else break;
            }
            turn--;
        }
        StringBuilder sb=  new StringBuilder();
        for(int i=0;i<N;i++)sb.append(arr[i][1]);
        System.out.println(sb.toString());
    }
}
