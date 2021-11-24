# Автотесты для [интернет-магазина 'Буквоед'](https://www.bookvoed.ru/)
&nbsp;
![сайт Буквоед](https://user-images.githubusercontent.com/70107243/143308278-8a31b153-b462-4cbf-b470-26ab35c2896b.png)

&nbsp;
## Реализованы проверки:
### UI
- Авторизация пользователя с корректными и некорректными значениями
- Отображение главной страницы и переключение между вкладками
- Переход по категориям каталога (PLP)
- Открытие карточки товара (PDP)
- Поиск по наименованию продукта
- Добавление товара в корзину со страниц PDP и PLP
- Очистка корзины после добавления в нее товара
- Открытие страницы со списком магазинов

&nbsp;
## Используемые технологии и инструменты
<table>
<tbody>
<tr>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Intelij_IDEA.svg" width="40" height="40"><br>IntelliJ IDEA</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Java.svg" width="40" height="40"><br>Java</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Gradle.svg" width="40" height="40"><br>Gradle</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/JUnit5.svg" width="40" height="40"><br>JUnit5</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenide.svg" width="40" height="40"><br>Selenide</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Selenoid.svg" width="40" height="40"><br>Selenoid</td>
</tr>
<tr>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Jenkins.svg" width="40" height="40"><br>Jenkins</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Github.svg" width="40" height="40"><br>Github</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_Report.svg" width="40" height="40"><br>Allure Report</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Allure_EE.svg" width="40" height="40"><br>Allure TestOps</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Jira.svg" width="40" height="40"><br>Jira</td>
<td align="center"><src="https://www.jetbrains.com/idea/"><img src="https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width="40" height="40"><br>Telegram Bot</td>
</tr>
</tbody>
</table>

&nbsp;
## Команды для запуска из терминала
Локально должны быть заданы параметры в remoteweb.properties
### Запуск всех тестов на удалённом сервере:
```bash
gradle clean test -DremoteUrl=remoteweb
```
### Запуск всех тестов в браузере FireFox с разрешением экрана 1920x1080:
```bash
gradle clean test -Dbrowser=firefox -DbrowserSize=1920x1080
```
### Запуск тестов для корзины с включением параллельного выполнения и выбором 4-х потоков:
```bash
gradle clean cart_tests -DparallelRun=true -Dthreads=4
```
### Собрать Allure отчет:
```bash
allure serve build/allure-results
```

&nbsp;
## Параметры с помощью которых можно [запустить сборку в Jenkins](https://jenkins.autotests.cloud/job/08-alexstark_spb-bookvoed_tests/build):
![Сборка Jenkins-параметры-1](https://user-images.githubusercontent.com/70107243/143316090-295ac8ac-ce7c-4c1c-81fd-2c8c80f15cbc.png)
![Сборка Jenkins-параметры-2](https://user-images.githubusercontent.com/70107243/143315775-01c55ce3-0470-4023-aee8-0c7ad3a6f006.png)

## Отчёт в [Allure Report](https://jenkins.autotests.cloud/job/08-alexstark_spb-bookvoed_tests/51/allure/)
### Доска с аналитикой тестирования
![Allure Overview](https://user-images.githubusercontent.com/70107243/143316809-b4c33a2e-9c2c-4b89-a01b-49a4853799c8.png)

### Пример автоматизированного тест кейса
![Allure Behaviors](https://user-images.githubusercontent.com/70107243/143316844-364eaaec-7077-4542-81a1-10db799714fa.png)

&nbsp;
## Интеграция с TMS Allure TestOps
### Пример автоматизированного тест кейса
![Allure TestOps](https://user-images.githubusercontent.com/70107243/143319301-6cc24f46-0875-462f-b53e-bc84c7a086ab.png)

### Доска с аналитикой тестирования
![Allure TestOps Доска с аналитикой](https://user-images.githubusercontent.com/70107243/143317400-285697d5-2181-40fc-a8ee-c98c8675b51f.png)

&nbsp;
## Интеграция с Jira
![Jira](https://user-images.githubusercontent.com/70107243/143317827-d72f0a7d-3b93-48eb-b74e-8778eb2998e8.png)

&nbsp;
## Оповещение о прохождении тестов в Telegram
![Telegram Bot](https://user-images.githubusercontent.com/70107243/143317893-43dd6ea6-6479-4800-a296-06b607290832.png)

&nbsp;
## Видео прохождение тестов из Selenoid
- Добавление товара в корзину и дальнейшая ее очистка
![2aa712f2fd6a0a31cee9a593c2db6a95](https://user-images.githubusercontent.com/70107243/143318284-f1f80b2d-f183-4a7c-9543-82fb68c3cf94.gif)
