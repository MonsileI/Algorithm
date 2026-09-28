package 전체문제2026.September.Twelfth;

import java.util.Arrays;

public class sort {
    public static void main(String[] args) {
        int[]arr = {6,1,8,9,2,10};
        System.out.println("bubble");
        bubbleSort(arr, arr.length);
        System.out.println("insert");
        insertSort(arr, arr.length);
        System.out.println("select");
        selectedSort(arr, arr.length);
    }
    static void insertSort(int[]arr,int N){
        int[]tmp = new int[N];
        for(int i=0;i<N;i++)tmp[i] = arr[i];
        for(int i=1;i<N;i++){
            System.out.println(Arrays.toString(tmp));
            int target = tmp[i];
            int j = i - 1;
            while(-1<j &&  target < tmp[j]){
                tmp[j+1] = tmp[j];
                j--;
            }
            tmp[j+1] = target;
        }
    }
    static void selectedSort(int []arr,int N){
        int[]tmp = new int[N];
        for(int i=0;i<N;i++)tmp[i] = arr[i];
        for(int i=0;i<N-1;i++){
            System.out.println(Arrays.toString(tmp));
            boolean flag = false;
            int minIdx = i;
            for(int j=i+1;j<N;j++){
                if(tmp[j]<tmp[minIdx]){
                    minIdx = j;
                    flag = true;
                }
            }
            if(!flag) break;
            int t = tmp[i];
            tmp[i] = tmp[minIdx];
            tmp[minIdx] = t;
        }
    }
    static void bubbleSort(int []arr,int N){
        int[]tmp = new int[N];
        for(int i=0;i<N;i++)tmp[i] = arr[i];
        for(int i=0;i<N;i++){
            boolean flag = false;
            System.out.println(Arrays.toString(tmp));
            for(int j=0;j<N-1;j++){
                if(tmp[j+1]<tmp[j]){
                    flag = true;
                    int t = arr[j+1];
                    tmp[j+1] = tmp[j];
                    tmp[j] = t;
                }
            }
            if(!flag) break;
        }
    }
}
