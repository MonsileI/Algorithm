package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
public class BJ_1251_단어나누기_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = str.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = null;
        List<String> list = new ArrayList<>();
        for(int i=0;i<N-2;i++){
            for(int j=i+1;j<N-1;j++){
                for(int l=j+1;l<N;l++){
                    sb = new StringBuilder();
                    char[] f = (str.substring(0,i)+str.substring(i,j)).toCharArray();
                    char[] s = str.substring(j,l).toCharArray();
                    char[] t = str.substring(l).toCharArray();
                    for(char ch : f) stack.push(ch);
                    while(!stack.isEmpty()) sb.append(stack.pop());
                    for(char ch : s) stack.push(ch);
                    while(!stack.isEmpty()) sb.append(stack.pop());
                    for(char ch : t) stack.push(ch);
                    while(!stack.isEmpty()) sb.append(stack.pop());
                    list.add(sb.toString());
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.get(0));

    }
}
