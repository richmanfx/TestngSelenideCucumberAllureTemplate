#language: ru

# Функционал: => Feature:
# Сценарий:   => Scenario:
# Пусть     => Given
# Когда     => When
# Тогда     => Then
# И         => And
# Но        => But


Функционал: Smoke-тесты

  Сценарий: Проверка доступности сайта

    Пусть открыт сайт
    Тогда должен быть элемент с тегом H1
    И текст элемента с тегом H1 должен содержать "R5AM"
