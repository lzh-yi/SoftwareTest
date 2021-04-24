package com.lzh.Main;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerLinkedListTest {
  private CustomerLinkedList[] integerCustomerLinkedList;
  @BeforeEach
  public void init() {
    integerCustomerLinkedList = new CustomerLinkedList[7];
    integerCustomerLinkedList[0] = new CustomerLinkedList<Integer>();
    //
    integerCustomerLinkedList[1] = new CustomerLinkedList<Integer>();
    integerCustomerLinkedList[1].addFirst(Integer.valueOf(1));
    integerCustomerLinkedList[1].addFirst(Integer.valueOf(2));
    integerCustomerLinkedList[2] = new CustomerLinkedList<Integer>();
    integerCustomerLinkedList[2].addFirst(Integer.valueOf(1));
    integerCustomerLinkedList[2].addFirst(null);
    integerCustomerLinkedList[2].addFirst(null);
    integerCustomerLinkedList[3] = new CustomerLinkedList<Integer>();
    integerCustomerLinkedList[3].addFirst(null);
    integerCustomerLinkedList[3].addFirst(null);
    integerCustomerLinkedList[4] = new CustomerLinkedList<Integer>();
    integerCustomerLinkedList[4].addFirst(null);
    integerCustomerLinkedList[4].addFirst(null);
  }

  @Test
  void testRemove() {
    Assertions.assertEquals(false, integerCustomerLinkedList[0].remove(null));
    Assertions.assertEquals(false, integerCustomerLinkedList[1].remove(null));
    Assertions.assertEquals(true, integerCustomerLinkedList[3].remove(null));
    Assertions.assertEquals(true, integerCustomerLinkedList[4].remove(null));
    Assertions.assertEquals(true, integerCustomerLinkedList[2].remove(null));
    Assertions.assertEquals(false, integerCustomerLinkedList[0].remove(1));
    Assertions.assertEquals(true, integerCustomerLinkedList[1].remove(1));
    Assertions.assertEquals(false, integerCustomerLinkedList[1].remove(10));
    Assertions.assertEquals(true, integerCustomerLinkedList[2].remove(1));
    Assertions.assertEquals(false, integerCustomerLinkedList[3].remove(10));
    Assertions.assertEquals(false, integerCustomerLinkedList[4].remove(10));
  }
}