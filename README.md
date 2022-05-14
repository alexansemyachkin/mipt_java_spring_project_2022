# mipt_java_spring_project_2022
Вы попали на репозиторий веб-приложения системы дистанционной сессии реализованного в качестве проекта для курса "Введение в программирование на языке Java" ФПМИ МФТИ

Реализованные на данный момент функции проекта:
  - Регистрация, авторизация для студента
  - Сдача экзамена в формате теста по выбранному предмету для студента
  - Админский аккаунт с функциями добавления новых предметов и вопросов к ним

Данные от админского аккаунта:
  - username: admin@phystech.edu
  - password : password

Авторы проекта: Зайцев Егор, Семячкин Александр


Чтобы запустить данный проект необходим maven версии 3.8.1 (и выше) и JDK 16 (и выше)


Инструкция по скачиванию и запуску проекта:
  - С помощью Intelij IDEA: 
    1. Склонировать репозиторий в нужную папку
    2. Перейти в папку mipt_java_spring_project_2022
    3. Перейти на ветку main
    4. Открыть как проект папку RemoteSession в Intellij IDEA
    5. Нажать кнопку "Add Configuration" и добавить Spring Boot конфигурацию со следующими парметрами:
      - Name : RemoteSessionAppliation
      - Main class : ru.mipt.remotesession.RemoteSessionApplication
      - JDK : java 16
    6. Запустить проект с созданной конфигурацией
    7. Открыть браузер и ввести в строку поиска localhost:4040
    8. Наслаждаться :)

  - С помощью терминала:
    1. Открыть терминал
    2. $ cd "папка, в которой вы хотите установить проект"
    3. $ git clone https://github.com/alexansemya/mipt_java_spring_project_2022 (или склонировать репозиторий при помощи Git/Bash на Windows)
    4. $ cd mipt_java_spring_project_2022/RemoteSession/
    5. $ mvn compile
    6. $ mvn spring-boot:run
 

Инструкции по установке необходимого программного обеспечения:
  - Для Linux:
    1. Установка JDK 16 https://www.youtube.com/watch?v=f-oBpWOZFQE
    2. Установка Maven 3.8.1 https://www.youtube.com/watch?v=urPf8sbov0I
  
  - Для Windows:
    1. Установка JDK 16 https://www.youtube.com/watch?v=eduOjferW04
    2. Установка Maven 3.8.1 https://www.youtube.com/watch?v=pFoBSlP_1Yw

В случае возникновения ошибки запуска проекта при полном соблюдении инструкции и наличии всего необходимого ПО просим написать на GitHub @alexansemya или @fpmiegorzaytsev для дальнейшего разрешения проблемы

