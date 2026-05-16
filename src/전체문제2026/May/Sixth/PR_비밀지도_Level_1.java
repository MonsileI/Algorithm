package 전체문제2026.May.Sixth;

import java.util.*;

public class PR_비밀지도_Level_1 {
    static int N;
    public static void main(String[] args) {
        int n = 5;
        int []arr1 = {9, 20, 28, 18, 11};
        int []arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(solution(n,arr1,arr2)));

    }
    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[]answer = new String[n];
        N = n;
        for(int i=0;i<n;i++){
            char[] f = changeToBinary(arr1[i]);
            char[] s = changeToBinary(arr2[i]);
            String str = "";
            for(int j=0;j<n;j++){
                if(f[j]=='0' && s[j]=='0') str += " ";
                else str += "#";
            }
            answer[i] = str;
        }
        return answer;
    }
    static char[] changeToBinary(int num){
        String str = "";
        while(0<num){
            str = num%2 + str;
            num /= 2;
        }
        int len = str.length();
        for(int i=len;i<N;i++){
            str = "0"+str;
        }
        System.out.println(str);
        return str.toCharArray();
    }
}
