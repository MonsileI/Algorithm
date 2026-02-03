package 전체문제2026.February.정렬연습;

import java.util.Arrays;

public class 삽입정렬 {
    public static void main(String[] args) {
        int[]arr = {8,3,4,9,7};
        int N = arr.length;
        int j =0;
        for(int i=1;i<N;i++){
            int min = arr[i];
            for(j=i-1;-1<j;j--){
                if(min<arr[j]) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = min;
        }
        System.out.println(Arrays.toString(arr));
    }
}
