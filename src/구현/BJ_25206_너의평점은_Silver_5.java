package 구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_25206_너의평점은_Silver_5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double total = 0.0;
        double hakTotal = 0.0;
        for(int t=0;t<20;t++){
            String[]tmp = br.readLine().split(" ");
            if(tmp[2].equals("P")) continue;
            double score = 0;
            double hak = Double.parseDouble(tmp[1]);
            hakTotal += hak;
            switch (tmp[2]){
                case "A+":score = 4.5;
                break;
                case "A0":score = 4.0;
                    break;
                case "B+":score = 3.5;
                    break;
                case "B0":score = 3.0;
                    break;
                case "C+":score = 2.5;
                    break;
                case "C0":score = 2.0;
                    break;
                case "D+":score = 1.5;
                    break;
                case "D0":score = 1.0;
                    break;
                case "F":score = 0.0;
                    break;
            }
            total += (score * hak);
        }
        String ans = String.format("%.6f",total/hakTotal);
        System.out.println(ans);

    }
}
