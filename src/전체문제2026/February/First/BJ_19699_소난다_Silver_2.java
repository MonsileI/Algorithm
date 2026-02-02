package 전체문제2026.February.First;

import java.util.*;
import java.io.*;
public class BJ_19699_소난다_Silver_2 {
    static int N,M;
    static int[]arr;
    static Set<Integer>set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        comb(0,0,0);
        StringBuilder sb = new StringBuilder();
        if(set.isEmpty()) {
            sb.append(-1);
        }else {
            int size = set.size();
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            for (int num : list) sb.append(num + " ");
        }
        System.out.println(sb.toString());

    }
    static void comb(int start,int depth,int sum){

        if(depth==M){
            if(isPrime(sum)) {
                set.add(sum);
            }
            return;
        }

        for(int i=start;i<N;i++){
            comb(i+1,depth+1,sum+arr[i]);
        }
    }
    static boolean isPrime(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
