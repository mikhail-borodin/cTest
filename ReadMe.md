# Веб-сервис для оповещения сall-центра
Простой веб-сервис, предназначенный для быстрого оповещения курьером сall-центра о заказах, которые не могут быть доставлены в срок.

#### Сервис поддерживает операции:

###### Курьер:
* добавление нового задания;

###### Оператор сall-центра:
* просмотр списка заданий;
* поиск заданий по номеру заказа;
* закрытие выполненных заданий.

## Запуск сервиса

#### Подготовка базы данных

Для работы сервиса, сервер PostgreSQL должен быть развернут и запущен, база с названием "cdek_test_db" создана. Доступ к базе осуществляется по:
```
url=jdbc:postgresql://localhost/cdek_test_db
username=postgres
password=123
```
База должна содержать таблицу "tasks". SQL запрос на создание таблицы:
```
CREATE TABLE tasks
  (
    id SERIAL NOT NULL,
    number varchar(20) NOT NULL,
    date timestamp DEFAULT current_timestamp,
    checked BOOLEAN NOT NULL,
    PRIMARY KEY (id)
  );
```

#### Запуск сервиса

Для запуска сервиса необходимо выполнить cdek_test.jar файл в корне проекта:
```
java -jar cdek_test.jar
```

## Список операций
### Для курьера:
Web-интерфейс для курьера доступен по адресу: <http://localhost:9872/courier>
* Для добавления задания необходимо ввести в соответствующее поле номер заказа и нажать на кнопку "Добавить".

Добавить задание с тем же номером заказа можно только в том случае, если предыдущее задание было обработано со стороны сall-центра (нельзя отложить доставку, время которой не было обговорено с клиентом).

Предполагается, что в качестве допустимых символов для номера заказа выступают буквы английского алфавита и цифры.

### Для оператора call-центра
Web-интерфейс для оператора call-центра доступен по адресу: <http://localhost:9872/callcenter>
* Список заданий представлен на странице в виде таблицы с колонками "Номер заказа", "Дата и время добавления задания", "Статус". Закрытые задания размещены после активных.
* Для поиска заданий необходимо ввести номер заказа в соответствующее поле и нажать на кнопку "Найти". Поиск с пустым полем или нажатие на кнопку "Сбросить" сбрасывают результат поиска и возвращают к полному списку заданий.
* Для закрытия задания необходимо нажать на кнопку "Закрыть" соответствующей строки таблицы.
## Дополнительная информация
* Стек технологий: SpringController, SpringWeb, MyBatis, PostgreSQL, Thymeleaf.
