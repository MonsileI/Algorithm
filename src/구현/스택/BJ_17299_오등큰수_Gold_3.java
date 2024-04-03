package 구현.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17299_오등큰수_Gold_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        int[]arr = new int[N];
        int[]num = new int[1000001];
        int[]ans = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            num[arr[i]]++;
        }
        for(int i=0;i<N;i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            int number = arr[i];
            while(!stack.isEmpty()){
                if(num[arr[stack.peek()]]<num[number] && arr[stack.peek()]!=number){
                    ans[stack.pop()] = number;
                    continue;
                }
                break;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<N;i++) sb.append(ans[i]+" ");
        System.out.println(sb.toString());
    }
}
