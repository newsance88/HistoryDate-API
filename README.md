Исторические Даты Микросервис
  Микросервис "Исторические Даты" предоставляет API и веб-интерфейс для управления историческими датами и периодами.
  Он позволяет создавать, обновлять и удалять записи о значимых исторических событиях.
  Кроме того, микросервис поддерживает управление историческими периодами (веками), к которым эти события относятся.

Основные функции:
  Управление историческими датами:
  Добавление новой исторической даты.
  Обновление существующей исторической даты.
  Удаление исторической даты.
  Просмотр списка всех исторических дат.
  Управление периодами (веками).
  Добавление нового периода.
  Просмотр списка всех периодов.

Технологии и библиотеки:
  Java 17
  Spring Boot
  Spring Data JPA
  Hibernate
  Thymeleaf (для веб-интерфейса)
  Bootstrap 4.3.1 (для стилизации веб-интерфейса)
  Lombok (для упрощения создания Java-классов)
  Postgresql

Сборка и запуск из командной строки:
  mvn clean package
  java -jar target/history-date-service
