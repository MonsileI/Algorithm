package 전체문제2026.March.Thirteenth;

public class PR_힌트스테이지_Level_2 {
    public static void main(String[] args) {
        int[][] cost = {{160, 140, 120, 110, 60}, {290, 270, 260, 120, 10}, {160, 130, 120, 60, 20}, {160, 120, 80, 70, 20}, {110, 70, 60, 30, 20}};
        int[][] hint = {{40, 2, 3}, {40, 5, 3}, {20, 5, 4}, {50, 5, 5}};
        System.out.println(solution(cost, hint));
    }

    static int answer;
    static int N;
    static int[] coupon;
    static int[][] HINT;
    static int[][] COST;

    static int solution(int[][] cost, int[][] hint) {
        answer = Integer.MAX_VALUE;
        N = cost.length;
        HINT = hint;
        COST = cost;

        coupon = new int[N+1];

        // 🔥 초기 hint 적용 (범위 체크 추가)
        for(int i = 1; i < hint[0].length; i++){
            int idx = hint[0][i] - 1;
            if(idx >= 0 && idx < N){
                coupon[idx]++;
            }
        }

        dfs(1, getCost(0) + hint[0][0]);

        coupon = new int[N];

        dfs(1, getCost(0));

        return answer;
    }

    static void dfs(int depth, int sum){
        if(answer <= sum) return;

        if(depth == N-1){
            sum += getCost(depth); // 🔥 안전 접근
            answer = Math.min(answer, sum);
            return;
        }

        sum += getCost(depth); // 🔥 안전 접근

        // 🔥 구입 하기
        int tmpSum = sum + HINT[depth][0];

        // 증가 (범위 체크)
        for(int i = 1; i < HINT[depth].length; i++){
            int idx = HINT[depth][i] - 1;
            if(idx >= 0 && idx < N){
                coupon[idx]++;
            }
        }

        dfs(depth + 1, tmpSum);

        // 복구 (범위 체크 동일하게)
        for(int i = 1; i < HINT[depth].length; i++){
            int idx = HINT[depth][i] - 1;
            if(idx >= 0 && idx < N){
                coupon[idx]--;
            }
        }

        // 🔥 구입 안하기
        dfs(depth + 1, sum);
    }

    // 🔥 COST 접근 안전하게 처리
    static int getCost(int depth){
        int idx = Math.min(coupon[depth], COST[depth].length - 1);
        return COST[depth][idx];
    }
}