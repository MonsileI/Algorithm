package 전체문제2026.October.Sixth;

import java.util.Arrays;

public class PR_테이블해시함수_Level_2 {
    public static void main(String[] args) {
        int[][]data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        System.out.println(solution(data,col,row_begin,row_end));
    }
    static int solution(int[][] data, int col, int row_begin, int row_end) {
        int c = col-1;
        Arrays.sort(data,(o1,o2)-> o1[c]==o2[c] ? -(o1[0]-o2[0]) : o1[c]-o2[c]);
        row_begin--; row_end--;
        int num = change(data[row_begin],(row_begin+1));
        for(int i=row_begin+1;i<=row_end;i++){
            num = num ^ change(data[i],(i+1));
        }
        return num;
    }
    static int change(int []num,int mod){
        int result = 0;
        for(int i=0;i<num.length;i++){
            result += num[i]%mod;
        }
        return result;
    }
}
