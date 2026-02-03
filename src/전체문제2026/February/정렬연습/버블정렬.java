package 전체문제2026.February.정렬연습;

import java.util.Arrays;

public class 버블정렬 {
    public static void main(String[] args) {

        int[]arr = {9,6,7,3,5};

        int N = arr.length;
        for(int i=0;i<N;i++){
            boolean flag = false;
            for(int j=0;j<N-1;j++){
                if(arr[j+1]<arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag= true;
                }
            }
            if(!flag) break;
        }
        System.out.println(Arrays.toString(arr));
    }
}
