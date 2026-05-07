package 전체문제2026.May.Second;

import java.util.*;
public class PR_자동완성_Level_4 {

    static class TrieNode {

        Map<Character,TrieNode> childNode = new HashMap<>();
        int count = 0;

        public void insertNode(String str){
            int len = str.length();
            TrieNode trieNode = this;
            for(int i=0;i<len;i++){
                char ch = str.charAt(i);
                trieNode.childNode.putIfAbsent(ch, new TrieNode());
                trieNode = trieNode.childNode.get(ch);
                trieNode.count++;
            }
        }
        public int inputRange(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                trieNode = trieNode.childNode.get(ch);
                if(trieNode.count == 1){
                    return i + 1;
                }
            }
            return str.length();
        }
    }

    public static void main(String[] args) {
        String[] words = {"go","gone","guild"};
        System.out.println(solution(words));
    }
    static int solution(String[] words) {
        int answer = 0;
        TrieNode trieNode = new TrieNode();
        for(String str : words){
            trieNode.insertNode(str);
        }
        for(String str : words){
            answer += trieNode.inputRange(str);
        }
        return answer;
    }
}
