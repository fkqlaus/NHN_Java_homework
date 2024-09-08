import java.util.Stack;

public class PostfixNotation {
    public static String convPostfix(String infix) {
        Stack<Character> opStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringBuilder numBuilder = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            
            // 숫자이면 넘빌더에 추가
            if (Character.isDigit(c)) {
                numBuilder.append(c);
            } else {
                // 숫자 처리가 끝났으면 넘빌더 데이터 sb에 추가
                if (numBuilder.length() > 0) {
                    sb.append(numBuilder.toString()).append(' ');
                    numBuilder.setLength(0); // numBuilder를 초기화
                }

                if (c == ' ') {
                    // 공백이면 넘어가기
                    continue;
                } else if (isOperator(c)) {
                    // 연산자면
                    while (!opStack.isEmpty() && compareOp(opStack.peek(), c) >= 0) {
                        sb.append(opStack.pop()).append(' ');
                    }
                    opStack.push(c);
                } else {
                  throw new InvalidExpressionException("수식이 잘못되었습니다 \n오류를 일으킨 문자: " + c);
              }
            }
        }

        // 마지막에 남아있는 숫자 추가로 넣기
        if (numBuilder.length() > 0) {
            sb.append(numBuilder.toString()).append(' ');
        }

        // 스택에 남아있는 모든 연산자를 pop
        while (!opStack.isEmpty()) {
            sb.append(opStack.pop()).append(' ');
        }

        return sb.toString().trim(); // 마지막 공백 제거
    }

    // 연산자 순위 반환하기
    public static int getOpPriority(char c) {
        Operator op = Operator.fromChar(c);
        return op.getPrecedence();
    }

    // 연산자 순위 비교ㅎ
    public static int compareOp(char stackOp, char curOp) {
        Operator stackOpEnum = Operator.fromChar(stackOp);
        Operator curOpEnum = Operator.fromChar(curOp);

        return Integer.compare(stackOpEnum.getPrecedence(), curOpEnum.getPrecedence());
    }

    // 연산자인지 확인하기
    private static boolean isOperator(char c) {
        try {
            Operator.fromChar(c);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
