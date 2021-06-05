from PyQt5 import QtWidgets
import registrationWindowUI


class RegistrationWindow(QtWidgets.QMainWindow, registrationWindowUI.Ui_RegistrationWindow):
    def __init__(self):
        super().__init__()
        self.setupUi(self)

