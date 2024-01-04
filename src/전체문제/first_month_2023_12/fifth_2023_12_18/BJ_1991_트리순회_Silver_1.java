package 전체문제.first_month_2023_12.fifth_2023_12_18;
import java.io.*;
public class BJ_1991_트리순회_Silver_1 {

    static class Node{
        char head; Node left; Node right;
        public Node(char head, Node left, Node right) {
            this.head = head;
            this.left = left;
            this.right = right;
        }

    }
    static Node root = new Node('A',null,null);
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String str = br.readLine();
            char h = str.charAt(0);
            char l = str.charAt(2);
            char r = str.charAt(4);
            insertNode(root,h,l,r);
        }
        sb = new StringBuilder();
        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        System.out.println(sb.toString());
    }
    static void postOrder(Node tree){
        if(tree==null) return;
        postOrder(tree.left);
        postOrder(tree.right);
        sb.append(tree.head);
    }
    static void inOrder(Node tree){
        if(tree==null) return;
        inOrder(tree.left);
        sb.append(tree.head);
        inOrder(tree.right);
    }
    static void preOrder(Node tree){
        if(tree==null) return;
        sb.append(tree.head);
        preOrder(tree.left);
        preOrder(tree.right);
    }

    static void insertNode(Node tree, char head,char left,char right){
        if(tree.head==head){
            tree.left = (left == '.' ? null : new Node(left,null,null));
            tree.right = (right == '.' ? null : new Node(right,null,null));
        }else{
            if(tree.left!=null) insertNode(tree.left,head,left,right);
            if(tree.right!=null) insertNode(tree.right,head,left,right);
        }
    }
}
