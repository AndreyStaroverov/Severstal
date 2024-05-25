# Backend - часть для приложения "Поставка продукции"
Технологии:
+ Java 17
+ Spring Boot
+ Maven
+ Hibernate
+ PostgreSQL
+ JS/HTML/CSS
+ Docker

Database diagramm

![DB diagram](https://github.com/AndreyStaroverov/Severstal2/blob/main/db.jpg)

HTML+JS+CSS. Был сделан простейший визуальный интерфейс

Главная страница
![Visual](https://github.com/AndreyStaroverov/Severstal2/blob/main/Screenshot_1.png)
Выбираем поставки и продукцию
![Visual](https://github.com/AndreyStaroverov/Severstal2/blob/main/Screenshot_2.png)
Получаем отчет на странице либо в виде csv файла
![Visual](https://github.com/AndreyStaroverov/Severstal2/blob/main/Screenshot_3.png)

Чтобы испытать необходимо иметь Docker и запустить командой **`docker compose up`**
Дождаться сборки и перейти на http://localhost:8080/index.html (после уже работает навигация, для перехода на страницу с отчетом)

Без докера будет проблемнее, так как необходимо будет подключать базу данных, все в application.properties готово, если понадобится