# Сервис, который обращается к сервису курсов валют, и отдает gif в ответ

Для запуска сервиса нужно:
1. Собрать jar из исходников, для этого выполнить ``./gradlew clean bootJar``
2. Собрать докер-образ при помощи команды ``docker build . -t gif-service``
3. Запустить докер-контейнер при помощи команды docker run --name=gif-service --rm -e "GIF_API_KEY=\<your gif api key\>" -e "CURRENCY_API_APP_ID=<your currency api app id\>" -p 127.0.0.1:8080:8080 -p 127.0.0.1:8787:8787 gif-service (по желанию можно также запускать контейнер с разной базовой валютой (по умолчанию USD), для этого нужно пробросить переменную -e "CURRENCY_BASE=\<currency base\>")

Запрос к сервису осуществляется по эндпоинту: http://localhost:8080/gif/{currency}
Порт для удаленной отладки - 8787
# CurrencyRate
