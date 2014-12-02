package ru.bssys.task

/**
 * Created by radik on 28.11.2014.
 */
URL url = this.getClass().getResource("/test2.txt");
File file = new File(url.getFile());

def stack = new DoubleEndedQueue()
file.eachLine { line ->
  if (line.isDouble()) stack.addFirst(line.toDouble())
}
println 'количество элементов в очереди - ' + stack.length
println 'Подсчет элементов в очереди напрямую'
int length = 0
def curr = stack?.first
if (curr) length++
while (curr = curr?.next) length++
println 'количество элементов в очереди - ' + length

