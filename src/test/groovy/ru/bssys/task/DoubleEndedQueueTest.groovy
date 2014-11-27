package ru.bssys.task

import spock.lang.Specification

/**
 * Created by radik on 27.11.2014.
 */
class DoubleEndedQueueTest extends Specification {
  def stack = new DoubleEndedQueue2()
  void setup() {
    stack.addFirst('HelloOne')
    stack.addFirst('HelloTwo')
    stack.addFirst('HelloThree')
    stack.addFirst('HelloFour')
  }
  def "test addFirst method"() {
    println stack
    expect: stack.length == 4
  }
//  def "test fetchFirst method"() {
//    def first = stack.fetchFirst()
//    def second = stack.fetchFirst()
//    def third = stack.fetchFirst()
//    expect: first == 'Hello3' & second == 'Hello2' & third == 'Hello1'
//  }
}
