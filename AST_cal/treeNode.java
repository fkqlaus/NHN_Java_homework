public class treeNode {
  Object data;
  treeNode leftNode;
  treeNode rightNode;

  @Override
  public String toString() {
      if (leftNode == null && rightNode == null) {
          // 리프 노드면 데이터만 출력해버리기
          return data.toString();
      }

      return "(" + leftNode + ")," + data + ",(" + rightNode + ")";
  }
}
