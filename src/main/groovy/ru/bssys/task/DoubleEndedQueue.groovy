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
    // очередь пуста
    if (!last) {
      first = last = new Envelope(t)
      first.next = null
      first.previous = null
      length++
      return
    }
    // last существует
    Envelope nextToLast  = last
    last = new Envelope(t)
    last.next = null
    last.previous = nextToLast
    nextToLast.next = last
    length++
    return
  }

  def fetchLast = { ->
    // last не существует
    if (!last) return
    // last существует
    def deleted = last

    // last был единственным
    if (!last.previous) {
      first = last = null
      length = 0
      return deleted
    }
    length--
    last = last.previous
    last.next = null
    return deleted
  }

  def addFirst = { t ->
    if (!first) {
      first = last = new Envelope(t)
      first.next = null
      first.previous = null
      length++
      return
    }
    Envelope second = first
    first = new Envelope(t)
    first.next = second
    first.previous = null
    second.previous = first
    length++
    return
  }
  def fetchFirst = { ->
    // first нет
    if (!first) return
    // first есть
    def deleted = first

    length--
    first = first.next
    // если следующего за first нет, то
    if (!first) {
      last = null
      return deleted
    }
    first.previous = null
    return deleted
  }

  BigInteger getLength() { return length }
  String toString(){
    def curr = first
    String output = ''
    if (curr) output += curr.toString()
    while(curr && curr.next && curr.next != null) {
      curr = curr.next
      output += ' ' + curr.toString()
    }
    return output
  }
}