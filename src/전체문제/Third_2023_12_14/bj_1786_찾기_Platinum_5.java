package 전체문제.Third_2023_12_14;
import java.util.*;
import java.io.*;
public class bj_1786_찾기_Platinum_5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String pattern = br.readLine();
        int sLen = str.length();
        int pLen = pattern.length();
        int[]table = new int[pLen];
        int j = 0; //j = 접두사, i = 접미사
        for(int i=1;i<pLen;i++){
            while(0<j && pattern.charAt(j)!=pattern.charAt(i)) j = table[j-1];
            if(pattern.charAt(j)==pattern.charAt(i)) table[i] = ++j;
        }
        int cnt = 0;
        j = 0;
        System.out.println(Arrays.toString(table));
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<sLen;i++){
            while(0 < j && pattern.charAt(j)!=str.charAt(i)) j = table[j-1];
            if(pattern.charAt(j)==str.charAt(i)){
                if(j==pLen-1){
                    cnt++;
                    sb.append((i-j+1)+" ");
                    j = table[j];
                }else j++;
            }
        }
        sb.insert(0,cnt+"\n");
        System.out.println(sb.toString());
    }
}
