package 전체문제.fourth_month_2024_03.sixth_2024_03_08;
import java.util.*;

public class PR_카펫_Level_2 {
    static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        //브라운이 바깥쪽, 옐로우가 안쪽
        //가로가 세로보다 부조건 더 큼
        //10일 경우, 4,3 5,2 가능 10 + 4 를 만들 수 있는 두개의 수 음....
        //브라운 +4 /2 해서 만들 수 있는 두 수!
        int outLine = (brown+4)/2;
        int min = 3;
        while(true){
            int N = outLine - min;
            int M = min;
            if(((N-2) * (M-2)) == yellow){
                answer[0] = N; answer[1] = M;
                break;
            }
            min++;
        }
        return answer;
    }
    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        int brown = 10;
        int yellow = 2;

        int [] return = {4, 3};

        2.
        int brown = 8;
        int yellow = 1;

        int [] return = {3, 3};

        3.
        int brown = 24;
        int yellow = 24;

        int [] return = {8, 6};
        * */
        int brown = 24;
        int yellow = 24;
        System.out.println(Arrays.toString(solution(brown,yellow)));
    }
}
