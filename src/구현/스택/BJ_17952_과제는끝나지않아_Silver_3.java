package 구현.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17952_과제는끝나지않아_Silver_3 {
    static class Node{
        int score; int minute;

        public Node(int score, int minute) {
            this.score = score;
            this.minute = minute;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Stack<Node> stack = new Stack<>();
        int ans = 0;
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine());
            int act = Integer.parseInt(st.nextToken());
            if(act==0){
                if(stack.isEmpty()) continue;
                Node node = stack.peek();
                if(node.minute==1){
                    ans += node.score;
                    stack.pop();
                }else{
                    Node updateNode = stack.pop();
                    updateNode.minute--;
                    stack.push(updateNode);
                }
            }else{
                int score = Integer.parseInt(st.nextToken());
                int minute = Integer.parseInt(st.nextToken());
                if(minute==1) ans += score;
                else{
                    minute--;
                    stack.push(new Node(score,minute));
                }
            }
        }
        System.out.println(ans);

    }
}
