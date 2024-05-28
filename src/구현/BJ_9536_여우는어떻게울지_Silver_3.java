package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class BJ_9536_여우는어떻게울지_Silver_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        for(int t=0;t<TC;t++){
            String[]cries = br.readLine().split(" ");
            int N =cries.length;
            boolean[]check = new boolean[N];
            while(true){
                String [] tmp = br.readLine().split(" ");
                if(tmp[0].equals("what")) break;
                for(int i=0;i<N;i++){
                    if(tmp[2].equals(cries[i])) check[i] = true;
                }
            }
            for(int i=0;i<N;i++) {
                if(!check[i]){
                    if(i==N-1) sb.append(cries[i]);
                    else sb.append(cries[i]+" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
