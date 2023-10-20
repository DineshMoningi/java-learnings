package com.coding.learning.datastructures.tree.bst;

class BinarySearchTree {

  class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  private Node root;

  public Node getRoot() {
    return root;
  }
  public boolean insert(int value) {
    final Node newNode = new Node(value);
    if (root == null) {
      this.root = newNode;
      return true;
    } else {
      Node temp = root;
      while (true) {
        if (temp.value == newNode.value) {
          return false;
        }
        if (newNode.value < temp.value) {
          if (temp.left == null) {
            temp.left = newNode;
            return true;
          }
          temp = temp.left;
        } else {
          if (temp.right == null) {
            temp.right = newNode;
            return true;
          }
          temp = temp.right;
        }
        // left side should be lesser value
        // Right side should be greater value
      }
    }
  }

  public boolean contains(int value) {
    Node temp = root;
    while(temp != null) {
      if(temp.value == value) {
        return true;
      } else if(value < temp.value) {
        temp = temp.left;
      } else {
        temp = temp.right;
      }
    }
    return false;
  }
}

public class BinarySearchTreeDemo {

  public static void main(String[] args) {
    final BinarySearchTree bst = new BinarySearchTree();
    bst.insert(47);
    bst.insert(21);
    bst.insert(76);
    bst.insert(18);
    bst.insert(52);
    bst.insert(82);

    bst.insert(27);
    System.out.println(bst.getRoot().left.right.value);

    System.out.println(bst.contains(82));
  }
}
