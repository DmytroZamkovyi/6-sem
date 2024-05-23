@echo off
set /p token=Введіть токен:
curl -L "https://kpi.eu.auth0.com/api/v2/users" --header "Content-Type: application/x-www-form-urlencoded" --header "Authorization: Bearer %token%" --data "email=d.zamkovyi.ip13@kpi.ua&name=Zamkovyi Dmytro IP-13&connection=Username-Password-Authentication&password=Qq112233qq"
