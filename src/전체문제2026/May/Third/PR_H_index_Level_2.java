package 전체문제2026.May.Third;

public class PR_H_index_Level_2 {
    public static void main(String[] args) {
        int[]citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }
    static int solution(int[] citations) {
            int answer = 0;
            int N = citations.length;
            int L = 0; int R = N;
            while(L<=R){
                int mid = (L+R)/2;
                if(calc(citations,mid)>=mid) L = mid+1;
                else R = mid-1;
            }
            return R;
    }
    static int calc(int[]citations,int mid){
        int cnt  =0 ;
        for(int i=0;i<citations.length;i++){
            if(mid<=citations[i])cnt++;
        }
        return cnt;
    }
}
