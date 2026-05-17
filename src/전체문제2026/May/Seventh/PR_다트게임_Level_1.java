package 전체문제2026.May.Seventh;

public class PR_다트게임_Level_1 {
    public static void main(String[] args) {
        String dartResult = "1D2S0T";
        System.out.println(solution(dartResult));
    }
    static int solution(String dartResult) {
        int answer = 0;
        //스타상 -> 그 전꺼도 *2, S는 1제곱 D,2제곱 T3제곱, #은 지금 점수 * -1;
        //숫자는 1~10; -> 예외 1이면 다음 값이 0인 지 확인
        int tmpNum = 0;
        int idx = -1;
        int[]numbers = new int[3];
        for(int i=0;i<dartResult.length();i++){
            char ch = dartResult.charAt(i);
            if('0'<=ch && ch <= '9'){
                idx++;
                if(ch=='1'){
                    char tmp = dartResult.charAt(i+1);
                    if(tmp=='0'){
                        tmpNum = 10;
                        i++;
                    }else{
                        tmpNum = 1;
                    }
                }else{
                    tmpNum = ch - '0';
                }
                continue;
            }
            if(ch=='#'){
                numbers[idx] *= -1;
            }
            if(ch=='*'){
                numbers[idx] *= 2;
                if(idx!=0) numbers[idx-1] *=2;
            }
            switch (ch){
                case 'S':
                    numbers[idx] = tmpNum;
                    break;
                case 'D':
                    numbers[idx] = (int)Math.pow(tmpNum,2);
                    break;
                case 'T':
                    numbers[idx] = (int)Math.pow(tmpNum,3);
                    break;
            }
        }
        for(int i=0;i<numbers.length;i++) answer += numbers[i];
        return answer;
    }
}
