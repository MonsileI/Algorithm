package 문자열.KMP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BJ_16916_부분문자열_Bronze_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String pattern = br.readLine();
        int strLen = str.length();
        int pLen = pattern.length();
        int j = 0; // j = 접두사, i = 접미사
        int[]table = new int[pLen];
        for(int i=1;i<pLen;i++){
            while(0<j && pattern.charAt(i)!=pattern.charAt(j)){
                j = table[j-1];
            }
            if(pattern.charAt(i)==pattern.charAt(j)) table[i] = ++j;
        }
        int answer = 0;
        j = 0; //pattern index
        for(int i=0;i<strLen;i++){
            while(0<j && str.charAt(i) != pattern.charAt(j)){
                j = table[j-1];
            }
            if(pattern.charAt(j)==str.charAt(i)){
                if(j==pLen-1){
                    answer = 1;
                    break;
                }else j++;
            }
        }
        System.out.println(answer);
    }
}
