package 전체문제2026.June.Third;

public class PR_마법의엘리베이터_Level_2 {
    public static void main(String[] args) {
        int storey = 5555;
        System.out.println(solution(storey));
    }
    static int solution(int storey) {
        int answer = 0;

        while(0<storey){
            int num = storey % 10;
            storey /= 10;
            if(num<5) {
                answer += num;
            }else if(num>5){
                answer += 10 - num;
                storey++;  // 다음 자리에 올림 carry
            }
            else {
                answer += 5;
                if (storey % 10 >= 5) storey++;  // 다음 자리가 5 이상이면 올림
            }
        }
        return answer;
    }
}
