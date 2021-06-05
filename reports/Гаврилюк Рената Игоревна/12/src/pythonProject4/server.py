import time

from flask import Flask, request, Response
from utils import filter_by_key

from cities import Cities

app = Flask(__name__)

# Список сообщений, отпрпвленных за текущую сессию
messages = []

# Города и работа с ними
cities = Cities()

# Функция типа send - отправка сообщений от клиента серверу
# Метод POST используется для запроса, при котором адресуемый сервер принимает объект
@app.route("/send", methods=['POST'])
def send():
    # Извлечение из JSON-объекта информации
    name = request.json.get('username')  # Имя пользователя
    text = request.json.get('text')  # Текст сообщения

    if cities.add_city_to_named(text):
        # Если город неверный
        messages.clear()
        cities.restart()
        return Response(status=400)  # Вернуть код ошибки 400

    message = {
        'username': name,
        'time': time.time(),
        'text': text
    }
    messages.append(message)

    return Response(status=200)  # 200 - код "ОК"


def send_first_name():
    if not messages:
        text = cities.get_last_named_city()
        message = {
            'username': 'Chat-bot (⌒▽⌒)♡',
            'time': time.time(),
            'text': text
        }
        messages.append(message)


# Функция для фильтрации сообщений
@app.route("/messages")
def messages_view():
    # Дроп ошибки 400, если порог времени некорректен
    try:
        after = float(request.args['after'])
    except:
        return Response(status=400)
    send_first_name()

    # Возвращает объект с отфильтрованными сообщениями под ключом 'messages'
    return {
        'messages': filter_by_key(messages, key='time', threshold=after)
    }


send_first_name()

app.run()
