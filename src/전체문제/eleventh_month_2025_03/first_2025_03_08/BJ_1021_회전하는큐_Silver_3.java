package 전체문제.eleventh_month_2025_03.first_2025_03_08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1021_회전하는큐_Silver_3 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[]arr = new int[N];
        for(int i=1;i<N+1;i++) arr[i-1] = i;

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<M;i++){
            int cur = Integer.parseInt(st.nextToken());

            //왼쪽 오른쪽 확인
            int num = 0;
            for(int j=0;j<N;j++){
                if(arr[j]==cur) break;
                if(arr[j]==-1) continue; //이미 빠진 number면은 num을 더해주지 않음
                num++;
            }
            //왼쪽 크기 오른쪽 크기 확인
            



        }


    }



}
