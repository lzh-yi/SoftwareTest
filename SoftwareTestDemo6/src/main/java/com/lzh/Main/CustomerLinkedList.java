package com.lzh.Main;

import java.util.LinkedList;

/**
 * {@code CustomerLinkedList}类模拟实验 {@code JDK 8}的{@link LinkedList#remove()}方法
 *
 * @author 李志豪
 * @version 1.0
 */
public class CustomerLinkedList<E> implements java.io.Serializable{
  /**
   * Pointer to first node.
   */
  transient Node<E> first;

  /**
   * Pointer to last node.
   */
  transient Node<E> last;
  /**
   * 初始化大小
   */
  transient int size = 0;

  public boolean remove(Object o) {
    if (o == null) {
      for (Node<E> x = first; x != null; x = x.next) {
        if (x.item == null) {
          unlink(x);
          return true;
        }
      }
    } else {
      for (Node<E> x = first; x != null; x = x.next) {
        if (o.equals(x.item)) {
          unlink(x);
          return true;
        }
      }
    }
    return false;
  }

  public void addFirst(E e) {
    linkFirst(e);
  }

  private void linkFirst(E e) {
    final Node<E> f = first;
    final Node<E> newNode = new Node<>(null, e, f);
    first = newNode;
    if (f == null) {
      last = newNode;
    } else {
      f.prev = newNode;
    }
    size++;
  }

  E unlink(Node<E> x) {
    // assert x != null;
    final E element = x.item;
    final Node<E> next = x.next;
    final Node<E> prev = x.prev;

    if (prev == null) {
      first = next;
    } else {
      prev.next = next;
      x.prev = null;
    }

    if (next == null) {
      last = prev;
    } else {
      next.prev = prev;
      x.next = null;
    }

    x.item = null;
    size--;
//    modCount++;
    return element;
  }

  private static class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
      this.item = element;
      this.next = next;
      this.prev = prev;
    }
  }

}
