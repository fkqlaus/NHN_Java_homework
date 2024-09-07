// 반드시 enum을 사용할것
import java. util.*;

class Node<T>{

    String key;
    Node left;
    Node right;

    public Node(String key){
        this.key = key;
        left = right = null;
    }
    
}

public class Calurator<T>{

    Stack<Node> stack = new Stack<>();

    Node root;
    int size = 0;

    public Calurator(){
        this.root = null;
    }

    public Node getRootNode(){
        return this.root;
    }

    public void add(String key){
        StringTokenizer token = new StringTokenizer(key);
        while(token.hasMoreTokens()){
            size++;
            root = addNode(root,token.nextToken());
        }
        System.out.println(root.left.key);
    
        
    }

    private Node addNode(Node node, String key){
        
        
        if(node==null){
            return new Node(key);
        }

            return node.left = addNode(node.left, key);
       
            //node.right = addNode(node.right, key);
        
     
    }

    public void inOrder(Node node){
        
        if(node != null){
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }
    public void postOrder(Node node){
        
        if(node != null){
            
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }

    //계산 결과 반환 함수
 


}