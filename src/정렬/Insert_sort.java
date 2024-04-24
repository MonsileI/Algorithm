package 정렬;

import java.util.Arrays;

public class Insert_sort {
    public static void main(String[] args) {
        int[] arr = {5,6,3,2,7,1,8,4};
        int N = arr.length;
        int min = 0;
        int j =0;
        for(int i=1;i<N;i++){
            min = arr[i];
            for(j=i-1;-1<j;j--){
                if(min<arr[j]) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = min;
            System.out.println(Arrays.toString(arr));
        }
    }
}
