package 전체문제2026.April.Second;

public class PR_스킬트리_Level_2 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[]skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill,skill_trees));
    }
    static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int len = skill.length();
        int[]alpha = new int[26];
        int num = 1;
        for(int i=0;i<len;i++){
            char ch = skill.charAt(i);
            alpha[ch - 'A'] = num++;
        }
        for(String str : skill_trees){
            int idx = 1;
            boolean flag = true;
            for(int i=0;i<str.length();i++){
                if(len<idx) break;
                char ch = str.charAt(i);
                if(ch==skill.charAt((idx-1))){
                    idx++;
                }else{
                    if(alpha[ch-'A'] !=0){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}
