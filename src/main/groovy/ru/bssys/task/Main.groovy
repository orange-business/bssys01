package ru.bssys.task

/**
 * Created by radik on 28.11.2014.
 */
URL url = this.getClass().getResource("/test.txt");
File file = new File(url.getFile());

def stack = new DoubleEndedQueue()
file.eachLine { line ->
  if (line.isDouble()) stack.addFirst(line.toDouble())
}
println stack.length + ' ' + stack
