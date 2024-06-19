package 전체문제.seven_month_2024_06.eleventh_2024_06_19;

import java.util.*;
import java.io.*;
public class BJ_5073_삼각형과세변_Bronze_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb= new StringBuilder();
        int[]arr = new int[3];
        while(true){
            st = new StringTokenizer(br.readLine()," ");
            arr =new int[3];
            for(int i=0;i<3;i++)arr[i] = Integer.parseInt(st.nextToken());
            if(arr[0]==0 && arr[1]==0 && arr[2]==0) break;
            Arrays.sort(arr);
            if(arr[2]>=arr[0]+arr[1]) {
                sb.append("Invalid\n");
                continue;
            }
            if(arr[2]==arr[1]){
                if(arr[1]==arr[0]) sb.append("Equilateral\n");
                else sb.append("Isosceles\n");
            }else{
                if(arr[1]==arr[0]) sb.append("Isosceles\n");
                else sb.append("Scalene\n");
            }
        }
        System.out.println(sb.toString());
    }
}
