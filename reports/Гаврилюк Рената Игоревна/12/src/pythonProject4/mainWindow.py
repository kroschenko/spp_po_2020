from PyQt5 import QtWidgets, QtCore
import mainWindowUI

from datetime import datetime
import requests


class MainWindow(QtWidgets.QMainWindow, mainWindowUI.Ui_MainWindow):
    def __init__(self, server_url, username):
        super().__init__()
        self.setupUi(self)
        self.userNameLabel.setText(username)
        self.__username = username
        self.__server_url = server_url
        self.sendMessageButton.clicked.connect(self.send_message)
        self.after = 0
        self.timerValue = 0
        self.timerLabel.setText(str(self.timerValue))
        self.server_url = server_url
        self.timer = QtCore.QTimer()
        self.timer.timeout.connect(self.load_messages)
        self.timer.start(1000)
        self.isClickedStartButton = False
        self.score = 0
        self.startButton.clicked.connect(self.clickOnStartButton)

    def pretty_message(self, message):
        dt = datetime.fromtimestamp(message['time'])
        dt_str = dt.strftime('%H:%M:%S')
        self.messageList.append(message['username'] + ', ' + dt_str)
        self.messageList.append(message['text'])
        self.messageList.append('')
        self.messageList.repaint()

    def load_messages(self):
        """Подгрузка сообщений за данную сессию"""
        try:
            data = requests.get(self.server_url + '/messages', params={'after': self.after}).json()
        except:
            return

        for message in data['messages']:
            self.pretty_message(message)
            self.after = message['time']

        if self.isClickedStartButton:
            self.timerValue += 1
            self.timerLabel.setText(str(self.timerValue))
            self.timerLabel.repaint()

            if self.timerValue >= 10:
                self.timerValue = 0
                self.send_message("КОНЕЦ ИГРЫ")


    def send_message(self, text=""):
        """Обработка нажатия на кнопку Отправить сообщение"""
        text = self.messageText.toPlainText()
        self.messageText.clear()
        self.messageText.repaint()
        message = {
            'username': self.__username,
            'text': text
        }

        try:
            response = requests.post(self.server_url + '/send', json=message)
            # self.prohibitSendingMessages()
        except:
            self.messageList.append('Сервер недоступен. Повторите попытку позже.')
            self.messageList.repaint()
            self.allowSendingMessages()
            return

        if response.status_code == 400:
            self.messageList.append('КОНЕЦ ИГРЫ!\n')
            self.isClickedStartButton = False
            self.startGame()

            return

        self.timerValue = 0
        self.timerLabel.repaint()
        self.score += 1
        self.scoreLabel.setText("SCORE: " + str(self.score))

    def clickOnStartButton(self):
        """Обработка нажатия на кнопку Начать игру"""
        self.messageText.show()
        self.sendMessageButton.show()
        self.startButton.hide()
        self.isClickedStartButton = True
        if self.messageList:
            self.allowSendingMessages()
            self.messageList.clear()
            self.timerValue = 0
            self.after = 0
            self.score = 0
            self.scoreLabel.setText("SCORE: " + str(self.score))
            self.load_messages()
            self.messageList.repaint()

