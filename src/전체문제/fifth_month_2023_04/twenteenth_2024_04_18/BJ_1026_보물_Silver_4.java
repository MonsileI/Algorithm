package 전체문제.fifth_month_2023_04.twenteenth_2024_04_18;

import java.util.*;
import java.io.*;
public class BJ_1026_보물_Silver_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        int [] arrA = new int[N];
        int [] arrB = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arrA[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)arrB[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int ans = 0;
        for(int i=0;i<N;i++) ans += (arrA[i] * arrB[N-i-1]);
        System.out.println(ans);

    }
}
