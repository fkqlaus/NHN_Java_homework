import java.util.*;
public class JBGW08_045_AST {

  public static void main(String[] args) {
      
    ExpressionTree expTree = new ExpressionTree();

    Scanner sr = new Scanner(System.in);
    String expression="0";

  
      while(true){
        System.out.print("> ");
        expression = sr.nextLine();
        if(expression.equals("exit()"))
          break;
  
        treeNode node = expTree.generateAST(expression);
        System.out.println(expTree.evaluation(node));
  
        System.out.println(expTree.generateAST(expression));
      }
      
    
  }
}