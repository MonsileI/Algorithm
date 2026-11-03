package 전체문제2026.November.Second;

import java.util.*;

public class PR_두큐합같게만들기_Level_2 {
    public static void main(String[] args) {
        int[]queue1 = {1,1};
        int[]queue2 = {1,5};
        System.out.println(solution(queue1,queue2));

    }
    static int solution(int[] queue1, int[] queue2) {

        Queue<Integer> fq=  new ArrayDeque<>();
        Queue<Integer> sq=  new ArrayDeque<>();
        int N = queue1.length;
        long sum = 0;
        long fSum = 0;
        long sSum = 0;
        for(int i=0;i<N;i++){
            fq.offer(queue1[i]);
            sq.offer(queue2[i]);
            sum += (queue1[i]+queue2[i]);
            fSum += queue1[i];
            sSum += queue2[i];
        }
        if(sum%2!=0) return -1;
        boolean flag = true;
        int answer = 0;
        while(true){
            if(fSum==sSum) break;
            if(fSum<sSum){
                if(sq.size()<=1){
                    flag = false;
                    break;
                }
                int s = sq.poll();
                fSum += s;
                sSum -= s;
                fq.offer(s);
            }else{
                if(fq.size()<=1){
                    flag = false;
                    break;
                }
                int f = fq.poll();
                fSum -= f;
                sSum += f;
                sq.offer(f);
            }
            answer++;
            if((N*4)<answer) {
                answer = -1;
                break;
            }
        }
        if(!flag) answer = -1;
        return answer;
    }
}
