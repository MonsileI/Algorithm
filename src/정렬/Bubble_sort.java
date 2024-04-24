package 정렬;

import java.util.Arrays;

public class Bubble_sort {
    public static void main(String[] args) {
        int[] arr = {5,6,3,2,7,1,8,4};
        int N = arr.length;
        for(int i=0;i<N-1;i++){
            for(int j=0;j<N-1;j++){
                if(arr[j+1]<arr[j]){
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
