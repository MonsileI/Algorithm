package 전체문제2026.February.Fourteenth;

public class PR_스킬트리_Level_2 {
    public static void main(String[] args) {
        String skill = "CBD";
        String[]skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill,skill_trees));
    }
    static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String str : skill_trees){
            int idx = 0;
            boolean flag = true;
            int len = str.length();
            for(int i=0;i<len;i++){
                char ch = str.charAt(i);
                if(skill.contains(ch+"")){
                    if(skill.charAt(idx)!=ch){
                        flag = false;
                        break;
                    }
                    idx++;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}
