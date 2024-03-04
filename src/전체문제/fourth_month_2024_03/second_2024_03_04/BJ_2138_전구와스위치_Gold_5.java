package 전체문제.fourth_month_2024_03.second_2024_03_04;
import java.util.*;
import java.io.*;
public class BJ_2138_전구와스위치_Gold_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[]arrA = new boolean[N];
        boolean[]arrB = new boolean[N];
        String a  = br.readLine();
        String b  = br.readLine();
        boolean [] tmpA = new boolean[N];
        for(int i=0;i<N;i++){
            char f = a.charAt(i);
            char s = b.charAt(i);
            tmpA[i] = arrA[i] = (f=='0' ? false : true);
            arrB[i] = (s=='0' ? false : true);
        }
        int cnt = Integer.MAX_VALUE;
        //처음을 무조건 누르는 형태
        tmpA[0] = !tmpA[0];
        tmpA[1] = !tmpA[1];
        int sumA = check(tmpA,arrB,N);
        int sumB = check(arrA,arrB,N);
        if(sumA==-1){
            System.out.println(sumB);
        }else {
            sumA++;
            if(sumB==-1) System.out.println(sumA);
            else System.out.println(Math.min(sumA,sumB));
        }
    }
    static int check(boolean[]a,boolean[]b,int N){
        int cnt = 0;
        for(int i=0;i<N-1;i++){
            if(a[i]!=b[i]){
                cnt++;
                a[i] = !a[i];
                a[i+1] = !a[i+1];
                if(i!=N-2){
                    a[i+2] = !a[i+2];
                }
            }
        }
        return a[N-1]!=b[N-1] ? -1 : cnt;


    }
}
