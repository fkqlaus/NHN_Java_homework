
public class BinaryTree {
  treeNode createBTreeNode() {
    treeNode newNode = new treeNode();
      newNode.leftNode = null;
      newNode.rightNode = null;

      return newNode;
  }

  Object getData(treeNode node) {
      return node.data;
  }

  void setData(treeNode node, Object data) {
      node.data = data;
  }

  treeNode getLeftSubTree(treeNode node) {
      return node.leftNode;
  }

  treeNode getRightSubTree(treeNode node) {
      return node.rightNode;
  }

  void createLeftSubTree(treeNode parent, treeNode child) {
      if (parent.leftNode != null){
          parent.leftNode = null;
      }

      parent.leftNode = child;
  }

  void createRightSubTree(treeNode parent, treeNode child) {
      if (parent.rightNode != null) {
          parent.rightNode = null;
      }

      parent.rightNode = child;
  }
}