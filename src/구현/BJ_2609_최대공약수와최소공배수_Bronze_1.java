package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_2609_최대공약수와최소공배수_Bronze_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");
        int a =Integer.parseInt(st.nextToken());
        int b =Integer.parseInt(st.nextToken());
        int min = gcd(a,b);
        System.out.println(min+"\n"+((a*b)/min));
    }
    static int gcd(int a,int b){
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        while(max!=0){
            int tmp = max;
            max = min % max;
            min = tmp;
        }
        return min;
    }
}
