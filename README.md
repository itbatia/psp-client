# PSP-client

Client for PSP. Simulates the work of the merchant API.

<img src="https://img.shields.io/badge/JDK_Version-v21.х-orange">   

`PSP-client` принимает HTTP-запросы от Payment Service Provider (`PSP`) и возвращает ответы.  
HTTP-запрос от `PSP` - это вебхук с информацией о статусе транзакции.  
Ответы от `PSP-client` могут быть в 2-х вариантах:

Webhook принят и сохранён:
```json
{
"transaction_id": "f2a47478-27c3-421a-9781-f68fc89da6bf",
"http_status": "200 OK",
"success": true
}
```
Webhook не принят (ошибка на сервере мерчанта):
```json
{
  "transaction_id": "f8f74ced-5403-4a60-ae94-8da894ae9cac",
  "http_status": "500 INTERNAL_SERVER_ERROR",
  "success": false
}
```

### Запуск проекта

1) Скачайте проект;
2) При необходимости исправьте конфигурацию в `src\main\resources\application-dev.yml`
3) Запустите профиль `dev`.

PS: Ключ `success-rate` определяет - какой процент вебхуков необходимо обработать успешно. 
