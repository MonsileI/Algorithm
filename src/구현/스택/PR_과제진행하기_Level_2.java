package 구현.스택;

import java.util.Arrays;
import java.util.Stack;

public class PR_과제진행하기_Level_2 {

    static class Node implements Comparable<Node>{
        String subject;
        int start;
        int take;

        public Node(String subject, int start, int take) {
            this.subject = subject;
            this.start = start;
            this.take = take;
        }

        @Override
        public int compareTo(Node o) {
            return start - o.start;
        }
    }
    static String[] solution(String[][] plans) {
        int N = plans.length;
        String[] answer = new String[N];
        Node[]arr = new Node[N];
        for(int i=0;i<N;i++){
            int start = change(plans[i][1]);
            arr[i] = new Node(plans[i][0],start,Integer.parseInt(plans[i][2]));
        }
        Arrays.sort(arr);
        Stack<Node> stack  = new Stack<>();
        int start = 0;
        int idx = 0;
        for(int i=0;i<N;i++){
            if(!stack.isEmpty()){
                while(!stack.isEmpty()){
                    if(stack.peek().take+start <= arr[i].start){
                        answer[idx++] = stack.peek().subject;
                        start += stack.pop().take;
                    }else {
                        Node node = stack.pop();
                        node.take -= (arr[i].start - start);
                        stack.push(node);
                        break;
                    }
                }
            }
            start = arr[i].start;
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()) answer[idx++] = stack.pop().subject;
        return answer;
    }
    static int change(String time){
        String[]tmp = time.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
    public static void main(String[] args) {
       /*
       TEST CASE
       1.
       String[][]plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
       String[]result = {"korean", "english", "math"};

       2.
       String[][]plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
       String[]result = {"science", "history", "computer", "music"};

       3.
        String[][]plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
       String[]result = {"bbb", "ccc", "aaa"};
       * */
        String[][]plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        System.out.println(Arrays.toString(solution(plans)));
    }
}
