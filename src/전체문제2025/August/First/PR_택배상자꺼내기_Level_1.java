package 전체문제2025.August.First;

import java.util.Arrays;

public class PR_택배상자꺼내기_Level_1 {
    public static void main(String[] args) {
        //int n = 22; int w= 6; int num = 8; //return 3;
        int n = 13; int w= 3; int num = 3; //return 4;
        System.out.println(solution(n,w,num));
    }
    static int solution(int n,int w,int num){

        int[]arr = new int[w];
        arr[w-1] = 1;
        for(int i=w-2;-1<i;i--){
            arr[i] = arr[i+1]+2;
        }
        boolean flag = true;
        int target  = num;
        while(true){
            if(target <= w){
                break;
            }
            flag = !flag;
            target -= w;
        }
        int initialIdx = target-1;
        int initialNum = 0;
        int otherNum = 0;
        if(flag){
            initialNum = arr[initialIdx];
            otherNum = arr[w- initialIdx -1];
        }else{
            initialNum = arr[w- initialIdx -1];
            otherNum =  arr[initialIdx];
        }
        int answer = 1;
        while(true){
            if(flag){
                num += initialNum;
            }else{
                num += otherNum;
            }
            if(n < num){
                break;
            }
            flag = !flag;
            answer++;
        }
        return answer;
    }
}
