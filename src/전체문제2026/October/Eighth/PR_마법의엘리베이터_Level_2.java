package 전체문제2026.October.Eighth;

public class PR_마법의엘리베이터_Level_2 {
    public static void main(String[] args) {
        int storey = 2554;
        System.out.println(solution(storey));
    }
    static int solution(int storey) {
        int answer = 0;
        // 5<= 빼주기
        while(0<storey){
            int num = storey % 10;
            storey /= 10;
            if(num<5) answer += num;
            else{
                answer += (10-num);
                if(num==5){
                    if(5 <= storey%10) storey++;
                }else storey++;
            }
        }
        return answer;
    }
}
