package ru.bssys.task

import spock.lang.Specification

/**
 * Created by radik on 27.11.2014.
 */
class DoubleEndedQueueTest extends Specification {
  void setup() {

  }
  def "test addFirst method"() {
    def stack = new DoubleEndedQueue()
    stack.addFirst('Hello')
    stack.addFirst('Hello')
    stack.addFirst('Hello')
    expect: true
  }
}
