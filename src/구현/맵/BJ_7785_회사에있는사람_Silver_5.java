package 구현.맵;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeMap;
public class BJ_7785_회사에있는사람_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String,Integer> map = new TreeMap<>();
        for(int i=0;i<N;i++){
            String []tmp = br.readLine().split(" ");
            String name = tmp[0];
            String act = tmp[1];
            if(!map.containsKey(name)) {
                map.put(name,0);
                continue;
            }
            if(act.equals("leave")){
                map.remove(name);
            }
        }
        Stack<String>stack = new Stack<>();
        for(String key : map.keySet()) stack.push(key);
        StringBuilder sb= new StringBuilder();
        while(!stack.isEmpty()) sb.append(stack.pop()+"\n");
        System.out.println(sb.toString());

    }
}
