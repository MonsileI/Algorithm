package 문자열.Trie;

import java.util.HashMap;
import java.util.Map;

public class PR_전화번호목록_Level_2 {

    static class TrieNode {
        Map<Character,TrieNode> childMap = new HashMap<>();
        public TrieNode(){};

        public void insertNode(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                trieNode.childMap.putIfAbsent(ch,new TrieNode());
                trieNode = trieNode.childMap.get(ch);
            }
        }
        public boolean isContains(String str){
            TrieNode trieNode = this;
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                TrieNode nowNode = trieNode.childMap.get(ch);
                if(nowNode.childMap.isEmpty()) return true;
                trieNode = nowNode;
            }
            return false;
        }
    }

    static boolean solution(String[] phone_book) {
        boolean answer = true;
        TrieNode trieNode = new TrieNode();
        for(String str : phone_book){
            trieNode.insertNode(str);
        }
        for(String str : phone_book){
            if(!trieNode.isContains(str)){
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        /*
        TEST CASE
        1.
        String[]phone_book = {"119", "97674223", "1195524421"};

        return false;
        2.
        String[]phone_book = {"123","456","789"};

        return true;
        3.
        String[]phone_book = {"12","123","1235","567","88"};

        return false;
        * */
        String[]phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }
}
