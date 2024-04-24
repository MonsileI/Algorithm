package 정렬;

import java.util.Arrays;

public class Selection_sort {
    public static void main(String[] args) {
        int[] arr = {5,6,3,2,7,1,8,4};
        int N = arr.length;
        int min = 0;
        for(int i=0;i<N-1;i++){
            min = i;
            for(int j=i+1;j<N;j++){
                if(arr[j]<arr[min]) min = j;
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
            System.out.println(Arrays.toString(arr));
        }

    }
}
