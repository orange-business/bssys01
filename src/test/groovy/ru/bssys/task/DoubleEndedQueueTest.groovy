package ru.bssys.task

import spock.lang.Specification

/**
 * Created by radik on 27.11.2014.
 */
class DoubleEndedQueueTest extends Specification {
  def stack

  def "different cases"() {
    stack = new DoubleEndedQueue()
    stack.fetchLast()
    stack.fetchFirst()
    assert stack.length == 0
    stack.addFirst("Cheese")
    assert stack.length == 1 & stack.last.toString() == 'Cheese'
    def res = stack.fetchLast()
    assert stack.length == 0 & stack.first == null & res.toString() == 'Cheese'& stack.last == null
    stack.addLast(422)
    assert stack.length == 1 & stack.first == stack.last
    res = stack.fetchFirst()
    assert stack.length == 0 & stack.first == null & res.toString() == '422' & stack.last == null
    stack.addFirst("Cheese1")
    assert stack.length == 1 & stack.first == stack.last & stack.last.toString() == "Cheese1"
    stack.addFirst("Cheese2")
    assert stack.length == 2 & stack.first != stack.last & stack.last.toString() == "Cheese1" & stack.first.toString() == "Cheese2"
    stack.addFirst("Cheese3")
    assert stack.length == 3 & stack.first != stack.last & stack.last.toString() == "Cheese1" & stack.first.toString() == "Cheese3"
    stack.addLast(423)
    assert stack.length == 4 & stack.first != stack.last & stack.last.toString() == "423" & stack.first.toString() == "Cheese3"
    stack.addLast(424)
    assert stack.length == 5 & stack.first != stack.last & stack.last.toString() == "424" & stack.first.toString() == "Cheese3"
    res = stack.fetchFirst()
    assert stack.length == 4 & stack.first != stack.last & stack.last.toString() == "424" & stack.first.toString() == "Cheese2" & res.toString() == "Cheese3"
    res = stack.fetchLast()
    assert stack.length == 3 & stack.first != stack.last & stack.last.toString() == "423" & stack.first.toString() == "Cheese2" & res.toString() == "424"
    res = stack.fetchFirst()
    assert stack.length == 2 & stack.first != stack.last & stack.last.toString() == "423" & stack.first.toString() == "Cheese1" & res.toString() == "Cheese2"
    res = stack.fetchLast()
    assert stack.length == 1 & stack.first == stack.last & stack.last.toString() == "Cheese1" & stack.first.toString() == "Cheese1" & res.toString() == "423"
    expect: true
  }

  def "fetchLast test method"() {
    stack = new DoubleEndedQueue()
    stack.fetchLast()
    assert stack.length == 0
    stack.addFirst("Hello Cap!")
    assert stack.length == 1
    stack.fetchFirst()
    assert stack.length == 0
    stack.addLast(422)
    assert stack.length == 1
    stack.addLast(522)
    assert stack.length == 2
    stack.addFirst("One")
    assert stack.length == 3
    stack.addLast(422)
    assert stack.length == 4
    stack.addLast(522)
    assert stack.length == 5
    def res = stack.fetchLast()
    assert stack.length == 4
    expect: stack.length == 4 & res.toString() == '522'
  }

  def "fetchLast method"() {
    stack = new DoubleEndedQueue()
    stack.fetchLast()
    stack.addFirst("Hello Cap!")
    def res = stack.fetchLast()
//    stack.fetchFirst()
//    stack.addLast(422)
//    stack.addLast(522)
    expect:
    stack.length == 0 & res.toString() == 'Hello Cap!'
  }
  def "test addLast once method"() {
    stack = new DoubleEndedQueue()
    stack.addLast(22)
    stack.addFirst("Hello Cap!")
    stack.fetchFirst()
    stack.addLast(422)
    stack.addLast(522)
    expect: stack.length == 3 & stack.toString() == '22 422 522'
  }
  def "test addLast nil method"() {
    stack = new DoubleEndedQueue()
    stack.addLast(22)
    stack.addFirst("Hello Cap!")
    stack.fetchFirst()
    stack.addLast(422)
    stack.addLast(522)
    stack.fetchFirst()
    stack.fetchFirst()
    stack.fetchFirst()
    stack.fetchFirst()
    expect: stack.length == 0 & stack.toString() == ''
  }

  def "test empty queue"() {
    stack = new DoubleEndedQueue()
    expect: stack.length == 0 & stack.toString() == ''
  }
  def "test empty with fetchFirst method"() {
    stack = new DoubleEndedQueue()
    stack.fetchFirst()
    expect: stack.length == 0 & stack.toString() == ''
  }

  def "test fetchFirst once method"() {
    stack = new DoubleEndedQueue()
    stack.addFirst(22)
    stack.fetchFirst()
    expect: stack.length == 0 & stack.toString() == ''
  }

  def "test broke fetchFirst method times"() {
    stack = new DoubleEndedQueue()
    stack.addFirst(22)
    def res1 = stack.fetchFirst()
    stack.addFirst("Hello Cap!")
    expect: res1 == 22 & stack.length == 1 & stack.toString() == 'Hello Cap!' & stack.@first.toString() == 'Hello Cap!' &
            stack.@first.next == null  & stack.@first.previous == null & stack.@first == stack.@last
  }

  def "test broke fetchFirst method 5 times"() {
    stack = new DoubleEndedQueue()
    stack.addFirst(22)
    stack.fetchFirst()
    stack.addFirst("Hello Cap!")
    stack.addFirst(22)
    expect: stack.length == 2 & stack.@first.next != null
  }

  def "test addFirst once method Integer"() {
    stack = new DoubleEndedQueue()
    stack.addFirst(-123456)
    expect: stack.length == 1 & stack.toString() == '-123456'
  }

  def "test addFirst once method"() {
    stack = new DoubleEndedQueue()
    stack.addFirst('HelloOne')
    expect: stack.length == 1 & stack.toString() == 'HelloOne'
  }
  def "test addFirst method String"() {
    stack = new DoubleEndedQueue()
    stack.addFirst('HelloOne')
    stack.addFirst('HelloTwo')
    stack.addFirst('HelloThree')
    stack.addFirst('HelloFour')
    expect: stack.length == 4 & stack.toString() == 'HelloFour HelloThree HelloTwo HelloOne'
  }
  def "test addFirst method Integer"() {
    stack = new DoubleEndedQueue()
    stack.addFirst(15)
    stack.addFirst(14)
    stack.addFirst(2)
    stack.addFirst(9)
    expect: stack.length == 4 & stack.toString() == '9 2 14 15'
  }
}