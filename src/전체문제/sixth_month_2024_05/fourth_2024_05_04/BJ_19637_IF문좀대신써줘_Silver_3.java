package 전체문제.sixth_month_2024_05.fourth_2024_05_04;

import java.util.*;
import java.io.*;
public class BJ_19637_IF문좀대신써줘_Silver_3 {
    static int []scores;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[]words = new String[N];
        scores = new int[N];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            words[i] = st.nextToken();
            scores[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<M;i++){
            int score = calc(Integer.parseInt(br.readLine()));
            sb.append(words[score]+"\n");
        }
        System.out.println(sb.toString());
    }
    static int calc(int num){
        int L = 0; int R = N;
        while(L<R){
            int mid = (L+R)/2;
            if(scores[mid]<num) L = mid+1;
            else  R = mid;
        }
        return L;
    }
}
