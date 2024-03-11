package 전체문제.fourth_month_2024_03.eighth_2024_03_11;

import java.util.*;

public class PR_기능개발_Level_2 {
    static int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        int[] work = new int[N];
        for(int i=0;i<N;i++){
            int w = (100-progresses[i]);
            work[i] = w/speeds[i];
            if(w%speeds[i]!=0) work[i]++;
        }
        Stack<Integer> stack = new Stack<>();
        List<Integer> list=  new ArrayList<>();
        int ans = 1;
        stack.push(work[0]);
        for(int i=1;i<N;i++){
            int w = work[i];
            if(stack.peek()>=w){
                ans++;
            }else{
                list.add(ans);
                stack.pop();
                ans = 1;
                stack.push(w);
            }
        }
        list.add(ans);
        int[]answer = new int[list.size()];
        for(int i=0;i<list.size();i++)answer[i] = list.get(i);
        return answer;
    }
    public static void main(String[] args) {
        /*TEST CASE
        1.
        int[]progresses={93, 30, 55};
        int[]speeds = {1, 30, 5};

        int[]return = {2, 1};

        2.
        int[]progresses={95, 90, 99, 99, 80, 99};
        int[]speeds = {1, 1, 1, 1, 1, 1};

        int[]return = {1,3,2};
        * */
        int[]progresses={93, 30, 55};
        int[]speeds = {1, 30, 5};

        System.out.println(Arrays.toString(solution(progresses,speeds)));
    }
}
