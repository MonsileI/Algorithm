package 전체문제2026.September.Seventh;

import java.util.*;
import java.io.*;
public class GR_Stack_D3 {

    static class thisStack {

        List<Integer> stack;
        int idx;
        int size;

        public thisStack(List<Integer> stack, int idx, int size) {
            this.stack = stack;
            this.idx = idx;
            this.size = size;
        }

        public boolean push(int num){
            idx++;
            if(size<=idx) {
                idx--;
                return false;
            }
            stack.add(num);
            return true;
        }
        public int pop(){
            if(idx<0) return -1;
            return stack.remove(idx--);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        thisStack stack = new thisStack(new ArrayList<>(),-1,S);
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine()," ");
            String act = st.nextToken();
            if(act.equals("pop")){
                int result = stack.pop();
                if(result==-1) sb.append("Underflow\n");
                else sb.append(result+"\n");
            }else{
                int num = Integer.parseInt(st.nextToken());
                boolean result = stack.push(num);
                if(!result) sb.append("Overflow\n");
            }
        }
        System.out.println(sb.toString());

    }
    //Overflow -> 사이즈 넘
    //Underflow -> 비었

}
