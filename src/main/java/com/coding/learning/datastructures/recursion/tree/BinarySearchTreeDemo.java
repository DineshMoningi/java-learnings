package com.coding.learning.datastructures.recursion.tree;

class BinarySearchTree {

  class Node {

    int value;
    Node left, right;

    public Node(int value) {
      this.value = value;
    }
  }

  private Node root;

  public boolean insert(int value) {
    Node newNode = new Node(value);
    Node temp = root;
    if (temp == null) {
      root = newNode;
      return true;
    }
    while (true) {
      if (temp.value == value) {
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
    }
  }

  public void rInsert(int value) {
    if (root == null) {
      root = new Node(value);
    }
    rInsert(root, value);
  }

  private Node rInsert(Node currentNode, int value) {
    if (currentNode == null) {
      return new Node(value);
    }

    if (value < currentNode.value) {
      currentNode.left = rInsert(currentNode.left, value);
    } else if (value > currentNode.value) {
      currentNode.right = rInsert(currentNode.right, value);
    }
    return currentNode;
  }

  public boolean contains(Node temp, int value) {
    if (temp == null) {
      return false;
    }
    if (temp.value == value) {
      return true;
    }

    if (value < temp.value) {
      return contains(temp.left, value);
    } else {
      return contains(temp.right, value);
    }
  }

  public Node getRoot() {
    return root;
  }

  public boolean contains(int value) {
    return contains(root, value);
  }

  private Node deleteNode(Node currentNode, int value) {
    if(currentNode == null) {
      return null;
    }

    if(value < currentNode.value) {
      currentNode.left = deleteNode(currentNode.left, value);
    } else if(value > currentNode.value) {
      currentNode.right = deleteNode(currentNode.right, value);
    } else {
      if(currentNode.left == null && currentNode.right == null) {
        return null;
      } else if(currentNode.left == null){
        currentNode = currentNode.right;
      } else if(currentNode.right == null){
        currentNode = currentNode.left;
      } else {
        int subTreeMinValue = minValue(currentNode.right);
        currentNode.value = subTreeMinValue;
        currentNode.right = deleteNode(currentNode.right, subTreeMinValue);
      }
    }
    return currentNode;
  }

  public void deleteNode(int value) {
    deleteNode(root, value);
  }

  public int minValue(Node currentNode) {
    while(currentNode.left != null) {
      currentNode = currentNode.left;
    }
    return currentNode.value;
  }
}

public class BinarySearchTreeDemo {

  public static void main(String[] args) {
    final BinarySearchTree bst = new BinarySearchTree();
//    bst.insert(47);
//    bst.insert(21);
//    bst.insert(76);
//    bst.insert(18);
//    bst.insert(52);
//    bst.insert(82);
//
//    bst.insert(27);
//
//    System.out.println(bst.contains(88));
//
//    bst.insert(88);
//    System.out.println(bst.contains(88));

//    bst.rInsert(10);
//    System.out.println(bst.getRoot().value);
    bst.rInsert(47);
    bst.rInsert(21);
    bst.rInsert(76);
    bst.rInsert(18);
    bst.rInsert(52);
    bst.rInsert(82);

    bst.rInsert(27);
    System.out.println(bst.contains(82));

    bst.deleteNode(82);
    System.out.println(bst.contains(82));
    bst.deleteNode(47);
    System.out.println(bst.contains(47));
    System.out.println(bst.getRoot().value);
  }
}
