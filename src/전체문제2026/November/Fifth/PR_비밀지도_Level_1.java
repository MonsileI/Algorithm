package 전체문제2026.November.Fifth;

import java.util.Arrays;

public class PR_비밀지도_Level_1 {
    public static void main(String[] args) {
        int n = 5;
        int []arr1 = {9, 20, 28, 18, 11};
        int []arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(solution(n,arr1,arr2)));
    }
    static int N;
    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        N = n;
        for(int i=0;i<n;i++){
            String f = changeToBinary(arr1[i]);
            String s = changeToBinary(arr2[i]);
            String str = "";
            for(int j=0;j<n;j++){
                if(f.charAt(j)=='1' || s.charAt(j)=='1') str+="#";
                else str+= " ";
            }
            answer[i] = str;
        }
        return answer;
    }
    static String changeToBinary(int num){
        String str = "";
        while(0<num){
            str = (num%2) + str;
            num /= 2;
        }
        int len = N - str.length();
        while(0<len){
            str = "0" + str;
            len--;
        }
        return str;
    }
}

