package 전체문제2026.April.Eleventh;

import java.util.*;
public class LC_LetterCombinationsOfAPhoneNumber_Medium {
    static List<String> answer;
    static char[][]num;
    static String D;
    static int len;
    static char[]tmp;
    public static void main(String[] args){
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    static List<String> letterCombinations(String digits) {
        answer=  new ArrayList<>();
        D = digits;
        len = digits.length();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        num = new char[10][4];
        int idx = 0;
        for(int i=2;i<10;i++){
            for(int j=0;j<3;j++) {
                num[i][j] = alpha.charAt(idx++);
            }
            if(i==7) num[i][4] = alpha.charAt(idx++);
            if(i==9) num[i][3] = alpha.charAt(idx);
        }
        tmp = new char[len];
        comb(0,0);
        return answer;
    }
    static void comb(int depth,int start){
        if(depth==len){
            String str = "";
            for(int i=0;i<depth;i++){
                str += tmp[i];
            }
            answer.add(str);
            return;
        }
        for(int i=start;i<len;i++){
            int ch = D.charAt(i) - '0';
            int end = 3;
            if(ch==9|| ch==7) end = 4;
            for(int j=0;j<end;j++) {
                tmp[depth] = num[ch][j];
                comb(depth+1,i+1);
            }
        }
    }
}
