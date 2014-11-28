package ru.bssys.task

/**
 * Created by radik on 28.11.2014.
 */
class Envelope {
  def body, next, previous
  Envelope(def t) {
    this.body = t
  }
  String toString(){
    return body.toString()
  }
}
