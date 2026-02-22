package 전체문제2026.February.Eleventh;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalTime;
import java.util.*;
import java.io.*;
public class BJ_1644_소수의연속합_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime , true);
        isPrime [0] = isPrime [1] = false;
        for(int i=2; i*i<=N; i++){
            if(isPrime[i]){
                for(int j=i*i; j<=N; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i=1; i<=N; i++) {
            if(isPrime[i]) {
                list.add(i);
            }
        }
        list.add(0);
        int size = list.size();
        int answer = 0;
        int L = 0; int R = 0; int sum  =0;
        while(L<=R && R<size){
            if(sum<N){
                sum += list.get(R++);
            }else{
                if(sum==N) answer++;
                sum -= list.get(L++);
            }
        }
        System.out.println(answer);
    }
}
