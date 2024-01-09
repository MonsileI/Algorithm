package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class GR_뒤통수가따가워_Level_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        for(int i=0;i<N;i++)arr[i] = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(stack.size()+" ");
            while(!stack.isEmpty()){
                if(arr[i]>=stack.peek()) stack.pop();
                else break;
            }
            stack.push(arr[i]);
        }
        System.out.println(sb.toString());
    }
}
