package 전체문제2025.September.Seventh;

import java.util.*;

public class PR_전화번호목록_Level_2 {


    static class TrieNode {

        Map<Character,TrieNode> childNode = new HashMap<>();
        boolean isFinish;
        public TrieNode(){};

        public void insertNode(String str){
            TrieNode curNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                curNode.childNode.putIfAbsent(ch, new TrieNode());
                curNode = curNode.childNode.get(ch);
                if(i==str.length()-1){
                    curNode.isFinish = true;
                }
            }
        }
        public boolean isContains(String str){
            TrieNode curNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                TrieNode nowNode = curNode.childNode.get(ch);
                curNode = nowNode;
            }
            if(curNode.isFinish){
                if(curNode.childNode.isEmpty()){
                    return false;
                }
            }
            return true;
        }

    }

    public static void main(String[] args) {
        String[]phone_book = {"123","456","789"};
        // false

        System.out.println(solution(phone_book));
    }
    static boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> list = new ArrayList<>();
        TrieNode trieNode = new TrieNode();
        for(String str : phone_book){
            list.add(str);
            trieNode.insertNode(str);
        }
        for(String str : list){
            if(trieNode.isContains(str) == true){
                answer = false;
                break;
            }
        }
        return answer;
    }
}
