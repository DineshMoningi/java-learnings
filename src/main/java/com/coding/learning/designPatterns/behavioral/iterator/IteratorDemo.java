package com.coding.learning.designPatterns.behavioral.iterator;

import java.util.Iterator;
import java.util.function.Consumer;

class Node<T> {
  public T value;
  public Node<T> left, right, parent;

  public Node(T value) {
    this.value = value;
  }

  public Node(Node<T> left, Node<T> right,
      Node<T> parent) {
    this.left = left;
    this.right = right;
    this.parent = parent;
  }
}

class InOrderIterator<T> implements Iterator<T> {

  private Node<T> current, root;
  private boolean yeildedStart;

  public InOrderIterator(Node<T> root) {
    this.root = current = root;
    while(current.left != null) {
      current = current.left;
    }
  }

  private boolean hasRigthmostparent(Node<T> node) {
    if(node.parent == null) {
      return false;
    } else {
      return (node == node.parent.left) || hasRigthmostparent(node.parent);
    }
  }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public T next() {
    return null;
  }

  @Override
  public void remove() {
    Iterator.super.remove();
  }

  @Override
  public void forEachRemaining(Consumer<? super T> action) {
    Iterator.super.forEachRemaining(action);
  }
}
public class IteratorDemo {

}
