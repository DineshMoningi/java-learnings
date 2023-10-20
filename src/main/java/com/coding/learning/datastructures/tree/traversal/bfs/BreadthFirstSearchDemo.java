package com.coding.learning.datastructures.tree.traversal.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class BreadthFirstSearch {

  class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  private Node root;

  public boolean insert(int value) {
    final BreadthFirstSearch.Node newNode = new BreadthFirstSearch.Node(value);
    if (root == null) {
      this.root = newNode;
      return true;
    } else {
      BreadthFirstSearch.Node temp = root;
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

  public List<Integer> bfs() {
    Node currentNode = root;

    Queue<Node> queue = new LinkedList<>();
    List<Integer> results = new ArrayList<>();
    queue.add(currentNode);
    List<String> test = new LinkedList<>();
    while (queue.size() > 0) {
      currentNode = queue.remove();
      results.add(currentNode.value);

      if (currentNode.left != null) {
        queue.add(currentNode.left);
      }

      if (currentNode.right != null) {
        queue.add(currentNode.right);
      }
    }

    return results;
  }
}

public class BreadthFirstSearchDemo {

  /*
   *            47
   *        21         76
   *     18    27   52     82
   *  BFS scanned result = [47, 21, 76, 18, 27, 52, 82]
   *
   * */

  public static void main(String[] args) {
    BreadthFirstSearch bfs = new BreadthFirstSearch();
    bfs.insert(47);
    bfs.insert(18);
    bfs.insert(27);
    bfs.insert(21);
    bfs.insert(52);
    bfs.insert(82);
    bfs.insert(76);

    System.out.println(bfs.bfs());

  }

  private static int sum(List<Integer> list) {
    int sum = 0;
    for(int i =0; i < list.size(); i++) {
      list.set(i, list.get(i) * 2);
    }

    for(int i = 0; i < list.size(); i++) {
      sum += list.get(i);
    }
    return sum;
  }
}

