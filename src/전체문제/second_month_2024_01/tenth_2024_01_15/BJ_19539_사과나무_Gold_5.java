package 전체문제.second_month_2024_01.tenth_2024_01_15;
import java.util.*;
import java.io.*;
public class BJ_19539_사과나무_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int num = 0;
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            int tmp = Integer.parseInt(st.nextToken());
            sum += tmp;
            if(tmp%2==1) num++;
        }
        if(sum%3==0 && num <= sum/3) System.out.println("YES");
        else System.out.println("NO");
    }
}
