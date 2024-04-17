package 전체문제.fifth_month_2023_04.eleventh_2024_04_17;

import java.io.*;
public class BJ_10162_전자레인지_Bronze_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        //300 60 10
        int[]answer = new int[3];
        int[]num = {300,60,10};
        if(T % 10 ==0){
            for(int i=0;i<3;i++){
                if(num[i]<=T){
                    answer[i] += (T/num[i]);
                    T = T % num[i];
                }
            }
            System.out.println(answer[0]+" "+answer[1]+" "+answer[2]);
        }else System.out.println(-1);


    }
}
