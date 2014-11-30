package ru.bssys.task

/**
 * Created by radik on 27.11.2014.
 * Двунаправленная очередь – структура данных, для которой доступны операции:
 •	Добавить число в начало очереди; add first
 •	Добавить число в конец очереди;  add last
 •	Изъять число из начала очереди;  fetch first
 •	Изъять число из конца очереди;   fetch last
 */

class DoubleEndedQueue {
  private Envelope first, last
  private def length = 0 as BigInteger

  def addLast = { t ->
    if (!t) return
    // очередь пуста
    if (!last) {
      first = last = new Envelope(body:t)
      first.next = null
      first.previous = null
      length++
      return
    }
    // last существует, добавляем один элемент, который и делаем последним
    Envelope nextToLast  = last
    last = new Envelope(body:t)
    last.next = null
    last.previous = nextToLast
    nextToLast.next = last
    length++
    return
  }

  def fetchLast = { ->
    // last не существует
    if (!last) {
      first = null
      length = 0
      return
    }
    // last существует
    def deleted = last

    // last был единственным, потому очередь стала пустой
    if (!last.previous) {
      first = last = null
      length = 0
      return deleted.body
    }
    length--
    last = last.previous
    last.next = null
    return deleted.body
  }

  def addFirst = { t ->
    if (!t) return
    // очередь пуста
    if (!first) {
      first = last = new Envelope(body:t)
      first.next = null
      first.previous = null
      length = 1
      return
    }
    // в очереди есть хотя бы один элемент
    Envelope second = first
    first = new Envelope(body:t)
    first.next = second
    first.previous = null
    second.previous = first
    length++
    return
  }
  def fetchFirst = { ->
    // first нет, очередь пуста
    if (!first) {
      last = null
      length = 0
      return
    }
    // first есть
    def deleted = first

    // оформление нового first
    first = first.next
    // если новый first null то очередь пуста
    if (!first) {
      last = null
      length = 0
      return deleted.body
    }
    length--
    first.previous = null
    return deleted.body
  }

  String toString(){
    def curr = first, output = ''

    if (curr) output += curr.toString()
    while(curr && curr.next && curr.next != null) {
      curr = curr.next
      output += ' ' + curr.toString()
    }
    return output
  }

  private class Envelope implements Comparable {
    def body
    Envelope next, previous
    String toString(){
      return body.toString()
    }

    @Override
    int compareTo(Object o) {
      if (!this.body.toString().isNumber()) return -1
      if (!o || !(o instanceof Envelope))   return -1
      Envelope env = (Envelope) o
      if (!env.body.toString().isNumber())  return -1
      return this.body - env.body
    }
  }
}