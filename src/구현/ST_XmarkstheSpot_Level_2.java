package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class ST_XmarkstheSpot_Level_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        for(int i=0;i<N;i++){
            String[]tmp = br.readLine().split(" ");
            int index = tmp[0].indexOf('X');
            if(index==-1) index = tmp[0].indexOf('x');
            sb.append(Character.toUpperCase(tmp[1].charAt(index)));
        }
        System.out.println(sb.toString());

    }
}
