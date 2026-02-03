package 전체문제2026.February.정렬연습;

import java.util.Arrays;

public class 선택정렬 {
    public static void main(String[] args) {
        int[]arr = {8,3,4,9,7};
        int N  = arr.length;
        for(int i=0;i<N;i++){
            int min = arr[i];
            int idx = i;
            for(int j=i+1;j<N;j++){
                if(arr[j]<min){
                    idx = j;
                    min = arr[j];
                }
            }
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }
    }
}
