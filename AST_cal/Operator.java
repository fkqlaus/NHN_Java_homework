public enum Operator {
  PLUS('+', 0),
  MINUS('-', 0),
  MULT('*', 1),
  DIV('/', 1);

  private final char symbol;
  private final int num;

  Operator(char symbol, int num) {
      this.symbol = symbol;
      this.num = num;
  }

  public char getSymbol() {
      return symbol;
  }

  public int getPrecedence() {
      return num;
  }

  public static Operator fromChar(char c) {
      for (Operator op : values()) {
          if (op.symbol == c) {
              return op;
          }
      }
      throw new InvalidExpressionException("오류 발생!");
  }
}
