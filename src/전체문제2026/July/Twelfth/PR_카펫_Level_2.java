package 전체문제2026.July.Twelfth;

import java.util.Arrays;

public class PR_카펫_Level_2 {
    public static void main(String[] args) {
        int brown = 8;
        int yellow = 1;
        System.out.println(Arrays.toString(solution(brown,yellow)));
    }
    static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        /*
        int num = brown / 2 - (2)
        int num = brown / 2 - (4)

        yellow = (num-2) * 1 ~ 2...
        * */
        int minus = 3; //gop은 2씩 늘어남
        int gop = 1;
        while(true){
            int num = ((brown/2) - minus) * gop;
            if(num==yellow) {
                answer[0] = (brown/2) - gop;
                answer[1] = minus;
                break;
            };
            gop++;
            minus++;
        }
        return answer;
    }
}
