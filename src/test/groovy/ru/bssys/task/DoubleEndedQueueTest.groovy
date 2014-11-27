package ru.bssys.task

import spock.lang.Specification

/**
 * Created by radik on 27.11.2014.
 */
class DoubleEndedQueueTest extends Specification {
  def "test empty queue"() {
    def stack = new DoubleEndedQueue()
    expect: stack.length == 0 & stack.toString() == ''
  }
  def "test empty with fetchFirst method"() {
    def stack = new DoubleEndedQueue()
    stack.fetchFirst()
    expect: stack.length == 0 & stack.toString() == ''
  }

  def "test fetchFirst once method"() {
    def stack = new DoubleEndedQueue()
    stack.addFirst(22)
    stack.fetchFirst()
    expect: stack.length == 0 & stack.toString() == ''
  }

  def "test broke fetchFirst method times"() {
    def stack = new DoubleEndedQueue()
    stack.addFirst(22)
    def res1 = stack.fetchFirst()
    stack.addFirst("Hello Cap!")
    expect: res1 == 22 & stack.length == 1 & stack.toString() == 'Hello Cap!' & stack.@first == 'Hello Cap!' &
            stack.@first.nxt == null  & stack.@first.prv == null & stack.@first == stack.@last
  }

  def "test broke fetchFirst method 5 times"() {
    def stack = new DoubleEndedQueue()
    stack.addFirst(22)
    stack.fetchFirst()
    stack.addFirst("Hello Cap!")
    stack.addFirst(22)
    expect: stack.length == 2 & stack.@first.nxt == null
  }

  def "test addFirst once method Integer"() {
    def stack = new DoubleEndedQueue()
    stack.addFirst(-123456)
    expect: stack.length == 1 & stack.toString() == '-123456'
  }

  def "test addFirst once method"() {
    def stack = new DoubleEndedQueue()
    stack.addFirst('HelloOne')
    expect: stack.length == 1 & stack.toString() == 'HelloOne'
  }
  def "test addFirst method String"() {
    def stack = new DoubleEndedQueue()
    stack.addFirst('HelloOne')
    stack.addFirst('HelloTwo')
    stack.addFirst('HelloThree')
    stack.addFirst('HelloFour')
    expect: stack.length == 4 & stack.toString() == 'HelloFour HelloThree HelloTwo HelloOne'
  }
  def "test addFirst method Integer"() {
    def stack = new DoubleEndedQueue()
    stack.addFirst(15)
    stack.addFirst(14)
    stack.addFirst(2)
    stack.addFirst(9)
    expect: stack.length == 4 & stack.toString() == '9 2 14 15'
  }
}
