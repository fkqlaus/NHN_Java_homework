import java.util.Stack;

public class ExpressionTree extends BinaryTree {
    treeNode node;

    // generateAST로 AST 생성
    public treeNode generateAST(String exp) {
        return createExpTree(exp);
    }

    // 후위 표기법으로 수식을 바꾸고 트리 만들기
    public treeNode createExpTree(String exp) {
        String postfixExp = PostfixNotation.convPostfix(exp);
        Stack<treeNode> stack = new Stack<>();
        StringBuilder numBuilder = new StringBuilder();
        

        for (int i = 0; i < postfixExp.length(); i++) {
            char c = postfixExp.charAt(i);

            if (Character.isDigit(c)) {
                // 숫자를 스트링 빌더에 추가
                numBuilder.append(c);
            } else if (c == ' ' && numBuilder.length() > 0) {
                // 공백이 나오고 넘빌더에 내용이 있으면, 넘빌더의 내용을 처리
                treeNode newNode = new treeNode();
                newNode.data = Integer.parseInt(numBuilder.toString());
                stack.push(newNode);
                numBuilder.setLength(0); // 넘빌더 초기화
            } else if (c == ' ') {
                // 공백만 있는 경우 무시
                continue;
            } else if (Operator.fromChar(c) != null) {
                // 연산자인 경우
                treeNode newNode = new treeNode();
                newNode.data = c;
                newNode.rightNode = stack.pop();
                newNode.leftNode = stack.pop();
                stack.push(newNode);
            }
        }

        // 마지막에 남아있는 숫자를 처리
        if (numBuilder.length() > 0) {
            treeNode newNode = new treeNode();
            newNode.data = Integer.parseInt(numBuilder.toString());
            stack.push(newNode);
        }

        return stack.pop();
    }

    // AST 계산
    public int evaluation(treeNode node) {
        if (node.leftNode == null && node.rightNode == null) {
            return (int) node.data;
        }

        int leftValue = evaluation(node.leftNode);
        int rightValue = evaluation(node.rightNode);
        char operator = (char) node.data;
        Operator op = Operator.fromChar(operator);

        switch (op) {
            case PLUS: return leftValue + rightValue;
            case MINUS: return leftValue - rightValue;
            case MULT: return leftValue * rightValue;
            case DIV: return leftValue / rightValue;
            default: throw new InvalidExpressionException("오류..");
        }
    }
}
