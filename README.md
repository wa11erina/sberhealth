# Демопроект по автоматизации тестирования для веб-сайта [СберЗдоровье](https://sberhealth.ru/)

> СберЗдоровье - лидер российского медтеха, Digital Health платформа, объединяющая различные сервисы цифровой медицины.
____

> ## :ballot_box_with_check: <a name="Содержание">**Содержание:**</a>

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Примеры автоматизированных тест-кейсов</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск тестов из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>

____

<a id="tools"></a>
> ## :ballot_box_with_check: <a name="Технологии и инструменты">**Технологии и инструменты:**</a>

| Java                                                                                                     | IntelliJ  <br>  Idea                                                                                                        | GitHub                                                                                                     | JUnit 5                                                                                                           | Gradle                                                                                                     | Selenide                                                                                                         | Selenoid                                                                                                                  | Allure <br> Report                                                                                                         | Jenkins                                                                                                          | Jira                                                                                                                                    | Telegram                                                                                                            |                                                                                            Allure <br> TestOps 
|:---------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------:|
| <a href="https://www.java.com/"><img src="media/logos/Java.svg" width="50" height="50"  alt="Java"/></a> | <a href="https://www.jetbrains.com/idea/"><img src="media/logos/Intellij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a> | <a href="https://github.com/"><img src="media/logos/GitHub.svg" width="50" height="50"  alt="Github"/></a> | <a href="https://junit.org/junit5/"><img src="media/logos/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a> | <a href="https://gradle.org/"><img src="media/logos/Gradle.svg" width="50" height="50"  alt="Gradle"/></a> | <a href="https://selenide.org/"><img src="media/logos/Selenide.svg" width="50" height="50"  alt="Selenide"/></a> | <a href="https://aerokube.com/selenoid/"><img src="media/logos/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a> | <a href="https://github.com/allure-framework"><img src="media/logos/Allure.svg" width="50" height="50"  alt="Allure"/></a> | <a href="https://www.jenkins.io/"><img src="media/logos/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a> | <a href="https://www.atlassian.com/software/jira/"><img src="media/logos/Jira.svg" width="50" height="50" alt="Jira" title="Jira"/></a> | <a href="https://web.telegram.org/"><img src="media/logos/Telegram.svg" width="50" height="50" alt="Telegram"/></a> | <a href="https://qameta.io/"><img src="media/logos/Allure_TO.svg" width="50" height="50" alt="Allure_TO"/></a> |

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования Selenide.
- В качестве сборщика был использован - <code>Gradle</code>.
- Использованы фреймворки <code>JUnit 5</code> и [Selenide](https://selenide.org/).
- При удаленном запуске тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Удаленный запуск реализован в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>
  Telegram</code> при помощи бота.
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>.

Содержание Allure-отчета:

* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

____

<a id="cases"></a>
> ## :ballot_box_with_check: <a name="Примеры автоматизированных тест-кейсов">**Примеры автоматизированных тест-кейсов:
**</a>

- Проверка Главной страницы на наличие ссылок на другие разделы сервиса;
- Возможность найти необходимого специалиста в выбранной геолокации, в т.ч. для ребенка и по полису ДМС;
- Наличие ссылок на онлайн-консультации для взрослых, детей и животных и описания этих услуг;
- Проверка возможности подобрать диагностическую процедуру по ее названию и по названию органа тела.

____

<a id="jenkins"></a>
> ## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logos/Jenkins.svg"> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/belova_qa_guru_20_sberhealth/)

Для запуска сборки необходимо перейти в раздел <code>Собрать с параметрами</code> и нажать кнопку <code>Собрать</code>.

<p align="center">
<img title="Jenkins Build" src="media/screens/JenkinsBuild.png">
</p>

### **Параметры сборки:**

* <code>BASE_URL</code> – главная страница веб-сайта.
* <code>REMOTE_URL</code> – адрес удаленного сервера, на котором запускаются тесты.
* <code>BROWSER</code> – браузер, в котором выполняются тесты. По-умолчанию - <code>chrome</code>.
* <code>BROWSER_VERSION</code> – версия браузера. По-умолчанию - <code>100.0</code>.
* <code>SCREEN_RESOLUTION</code> – размер окна браузера. По-умолчанию - <code>1920x1080</code>.

После выполнения сборки в блоке <code>История сборок</code> напротив номера сборки появляются значки <code>Allure
Report</code> и <code>Allure TestOps</code>, при клике на которые открываются страницы со сформированным html-отчетом и
тестовой документацией соответственно.
____

<a id="console"></a>
> ## :ballot_box_with_check: <a name="Запуск тестов из терминала">**Запуск тестов из терминала:**</a>

### Команда для терминала IDE для локального запуска тестов:

```
gradle clean test
```

### Команда для терминала IDE для удаленного запуска тестов в <code>Selenoid</code>:

```
gradle clean test -Denv=remote
```

Также можно переопределить параметры запуска:

```
clean
${TASK}
-DbaseUrl=${BASE_URL}
-DremoteUrl=${REMOTE_URL}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DscreenResolution=${SCREEN_RESOLUTION}
```

____

<a id="allure"></a>
> ## <img alt="Allure" height="25" src="media/logos/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [Report](https://jenkins.autotests.cloud/job/belova_qa_guru_20_sberhealth/45/allure/)</a>

### Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="media/screens/allure_main.png" width="850">  
</p>  

### Тест-кейсы

<p align="center">  
<img title="Allure Tests" src="media/screens/allure_kids_case.png" width="850">  

<img title="Allure Tests" src="media/screens/allure_vet_case.png" width="850">
</p>

### Графики

<p align="center">  
<img title="Allure Graphics" src="media/screens/allure_graph1.png" width="850">

<img title="Allure Graphics" src="media/screens/allure_graph2.png" width="850">  
</p>

____

<a id="allure-testops"></a>
> ## <img src="media/logos/Allure_TO.svg" title="Allure TestOps" width="4%"/></a>Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/3505/dashboards">Allure TestOps</a>

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

## Allure TestOps Dashboard

<p align="center">  
<img title="Allure TestOps Dashboard" src="media/screens/allure_to_dashboards.png" width="850">
</p>  

## Тест-кейсы

<p align="center">  
<img title="Allure Tests" src="media/screens/allure_to_dms_case.png" width="850">  

<img title="Allure Tests" src="media/screens/allure_to_therapist_case.png" width="850">  
</p>

____

<a id="jira"></a>

## <img alt="Allure" height="25" src="media/logos/Jira.svg" width="25"/></a> Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-786)">Jira</a>

<p align="center">  
<img title="Jira" src="media/screens/jira_plus_allure_to.png" width="850">  
</p>

</p>

____

<a id="telegram"></a>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logos/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки созданный в <code>Telegram</code> бот автоматически обрабатывает результаты и отправляет
уведомление со ссылкой на отчет.

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/happy_tisha.png">
</p>

____
<a id="video"></a>

## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео его выполнения.
<p align="center">
<img title="Selenoid Video" src="media/videos/vet_online.gif" width="500" height="300" alt="video"> <img title="Selenoid Video" src="media/videos/doctor_online.gif" width="500" height="300" alt="video">

</p>
