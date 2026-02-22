package 전체문제2026.February.Eleventh;

import java.util.*;
import java.io.*;
public class BJ_12789_도키도키간식드리미_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Stack<Integer> stack = new Stack<>();
        int node = 1;
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            if(num==node) {
                node++;
                continue;
            }
            while(!stack.isEmpty()){
                if(stack.peek()==node){
                    stack.pop();
                    node++;
                }else break;
            }
            if(num==node) {
                node++;
                continue;
            }
            stack.push(num);
        }
        while(!stack.isEmpty()){
            if(stack.peek()==node){
                stack.pop();
                node++;
            }else{
                break;
            }
        }
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}
