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
  private def first, last, tmp, length = 0 as BigInteger
  def addFirst = { t ->
    if (!first) {
      first = last = t
      length++
      return
    }
    tmp = first
    first = t
    first.metaClass.next = { tmp }
    tmp.metaClass.previous = { first }
    length++
  }

}
