from PyQt5 import QtWidgets
import registrationWindow
import mainWindow

app = QtWidgets.QApplication([])
window = registrationWindow.RegistrationWindow()
window.show()
app.exec_()

window2 = mainWindow.MainWindow('http://127.0.0.1:5000', window.getUsername())
window2.show()
app.exec_()
