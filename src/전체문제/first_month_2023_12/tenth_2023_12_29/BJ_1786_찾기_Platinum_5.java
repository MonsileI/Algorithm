package 전체문제.first_month_2023_12.tenth_2023_12_29;
import java.io.*;
public class BJ_1786_찾기_Platinum_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        String pattern = br.readLine();
        int pLen = pattern.length();
        int sLen = str.length();
        int[]table = new int[pLen];
        int j = 0;
        for(int i=1;i<pLen;i++){
            while(0<j && pattern.charAt(i)!=pattern.charAt(j)) j = table[j-1];
            if(pattern.charAt(i)==pattern.charAt(j)) table[i] = ++j;
        }
        j = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sLen;i++){
            while(0<j&&str.charAt(i)!=pattern.charAt(j)) j = table[j-1];
            if(str.charAt(i)==pattern.charAt(j)){
                if(j==pLen-1){
                    cnt++;
                    sb.append((i+2)-pLen+"\n");
                    j = table[j];
                }else j++;
            }
        }
        sb.insert(0,cnt+"\n");
        System.out.println(sb.toString());
    }
}
