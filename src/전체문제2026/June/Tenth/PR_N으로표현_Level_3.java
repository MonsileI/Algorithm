package 전체문제2026.June.Tenth;

import java.util.*;


public class PR_N으로표현_Level_3 {
    public static void main(String[] args) {
        int N =5;
        int number =12;
        System.out.println(solution(N,number));
    }
    static int solution(int N, int number) {
        int answer = -1;
        List<HashSet<Integer>> list = new ArrayList<>();
        int tmpN = N;
        for(int i=0;i<=8;i++){
            list.add(new HashSet<>());
        }
        list.get(1).add(N);
        for(int i=2;i<=8;i++){
            Set<Integer> totalSet = list.get(i);
            for(int j=1;j<i;j++){
                Set<Integer> a = list.get(j);
                Set<Integer> b = list.get(i-j);
                for(int x : a){
                    for(int y : b){
                        totalSet.add(x+y);
                        totalSet.add(x*y);
                        totalSet.add(x-y);
                        if(x!=0 && y!=0){
                            totalSet.add(x/y);
                        }
                    }
                }
            }
            N *= 10;
            N += tmpN;
            totalSet.add(N);
            if(totalSet.contains(number)){
                answer = i;
                break;
            }
        }
        return answer;
    }
}
