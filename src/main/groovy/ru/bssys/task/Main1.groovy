package ru.bssys.task

/**
 * Created by radik on 28.11.2014.
 */
URL url = this.getClass().getResource("/test2.txt")
File file = new File(url.getFile())

def stack = new DoubleEndedQueue()
file.eachLine { line -> if (line.isDouble()) stack.addFirst(line.toDouble()) }

println 'Подсчет элементов в очереди только через методы addFirst, addLast, fetchFirst, fetchLast'
println '1. Кидаем маркер в конец очереди'
stack.addLast('маркер')
println '2. После добавления маркера очередь = ' + stack
int length = 0
def curr

while ((curr = stack.fetchFirst()).toString() != 'маркер'){
  length++
  stack.addLast(curr)
}
println '3. Подсчитанное количество элементов в очереди - ' + length
println '4. Проверим равенство подсчитанных величин количество элементов в очереди.'
assert length == stack.length

println '5. Проверим, что очередь никак не изменилась после подсчета элементов.'
println '6. Создадим копию первоначальной очереди.'
def stackNew = new DoubleEndedQueue()
file.eachLine { line -> if (line.isDouble()) stackNew.addFirst(line.toDouble()) }

println '7. Мы уже знаем, что количество элементов до и после одинаковое.'
println '8. Проверим зеркальное соответствие элементов из обоих очередей.'
for (i in 1..length) {
  assert stack.fetchFirst() == stackNew.fetchFirst()
}