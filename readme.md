# Курсовая работа по 1 курсу
Выполнены все задания сложного уровня

* Создал класс EmployeeBook.
* Перенес хранилище сотрудников в EmployeeBook и сделал приватным.
* Все статические методы по работе с массивом перенес в этот класс и сделал их нестатическими.
* Метод добавление нового сотрудника не изменился, работает как надо.
* Добавил следующие новые методы:
  * Удалить сотрудника 
    * Находим сотрудника по Ф. И. О. 
    * Находим сотрудника по id
    * Находим сотрудника по Ф. И. О. и id
  * Изменить сотрудника (получаем Ф. И. О. сотрудника):
    * Изменяем ему зарплату.
    * Изменяем ему отдел.
  * Выводим данные всех сотрудников по отделам.

* Для удобства разграничил в проекте методы через region/endregion
и соответственные комментарии, что делает метод
* Соответственно все методы в отдельном файле, в Main только вызов методов
* readme написан простецкий, надеюсь я правильно уловил суть, и 
здесь должны быть инструкции и прочая инфа по работе кода, возможно 
список изменений
* 
Единственное, что смущает: в задании написанно просто создать класс EmployeeBook, а в пункте критерии оценки, что класс 
EmployeeBook должен быть **приватным** (возможно опечатка?), ***но IDEA не дает его сделать 
приватным***, **IDEA** предлагает только ***package private***..это то,
что надо? или нет? потому что при смене ***public*** на ***package 
private*** ничего не поменялось. В чем разница?
