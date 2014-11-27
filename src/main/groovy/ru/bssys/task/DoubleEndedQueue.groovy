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
  private def first, last, length = 0 as BigInteger
  def addFirst = { t ->
    if (!first) {
      first = last = t
      first.metaClass.nxt = null
      length++
      return
    }
    def second = first
    first = t
    first.metaClass.nxt = second
    second.metaClass.prv = first
    length++
    return
  }
  def fetchFirst = { ->
    if (!first) return
    def deleted = first
    first = first.nxt
    if (first) first.prv = null
    length--
    return deleted
  }

  BigInteger getLength() { return length }
  String toString(){
    def curr = first
    String output = ''
    if (curr) output += curr.toString()
    while(curr && curr.metaClass.hasProperty(curr, 'nxt') && curr.nxt != null) {
      curr = curr.nxt
      output += ' ' + curr.toString()
    }
    return output
  }
}
