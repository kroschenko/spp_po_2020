let stompClient = null
let gameNumber = null
let userName = null

function setConnected(connected) {
    if (connected) {
        $("#startGame").hide()
        $("#disconnect").show()
    } else {
        $("#startGame").show()
        $("#disconnect").hide()
    }
}

function connect() {
    let socket = new SockJS('/connect')
    stompClient = Stomp.over(socket)
    stompClient.connect({}, function (frame) {
        setConnected(true)
        $.ajax({
            url: "/digits",
            type: 'GET',
            success: function (data) {
                gameNumber = data
                showGameNumber("user")
            }
        })
        stompClient.subscribe('/topic/digit', function (gameObject) {
            let response = JSON.parse(gameObject.body)
            gameNumber = response.numbers
            if (gameNumber.length > 0) {
                showGameNumber(response.userName)
            } else {
                gameIsOver(response.userName)
            }
        })
    })
}

function resetGameNumber() {
    $.ajax({
        url: "/digits",
        type: 'POST'
    })
}

$('#updateDialog').on('show.bs.modal', function (event) {
    let target = $(event.relatedTarget)
    $("#updateFormErrorResponse").text("")
    $(this).find("#modalChangedNumber").val(target.data('number'))
    $("#updateFormUrl").attr("onclick", "updateNumber(" + target.data('id') + ", " +
        target.data('number') + ")")
    $("#reduceNumbers").attr("onclick", "reduceGameNumber(" + target.data('id') + ")")
})

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect()
    }
    setConnected(false)
    $("#mainGame").html("")
}

function sendName() {
    stompClient.send("/app/start", {}, JSON.stringify({
        'userName': userName,
        "numbers": gameNumber
    }))
}

function updateNumber(numberId, number) {
    const newNumber = $("#modalChangedNumber").val()
    gameNumber[numberId] = parseInt(newNumber)
    sendName()
    $('#updateDialog').modal('hide')
}

function showGameNumber(lastUserName) {
    let response = ""
    if (lastUserName === userName) {
        response = response + "<p>Opponent's turn</p>"
        $("#mainGame").css('pointer-events', 'none')
    } else {
        response = response + "<p>Your turn</p>"
        $("#mainGame").css('pointer-events', 'auto')
    }
    $.each(gameNumber, function (i, l) {
        response = response + createNumberButton(i, l)
    })
    $("#mainGame").html(response)
}

function createNumberButton(index, number) {
    if (number > 0) {
        return "<span data-toggle='modal' data-target='#updateDialog' data-id=" + index + " data-number=" + number + ">\n" +
            " <button data-toggle='tooltip' data-placement='top'>" + number + "</button>\n" +
            " </span>"
    } else {
        return "<button style=\"background: blue; color: white;\" onclick='reduceGameNumber(" + index + ")'>" + number + "</button>"
    }
}

function gameIsOver(lastUserName) {
    let response = "<h1>Game Over!</h1>"
    if (lastUserName === userName) {
        response = response + "<h3>You lost</h3>"
    } else {
        response = response + "<h3>You won</h3>"
    }
    $("#mainGame").html(response)
}

function reduceGameNumber(index) {
    gameNumber = gameNumber.slice(0, index)
    sendName()
    $('#updateDialog').modal('hide')
}

$(function () {
    let clkBtn = ""
    $("#startGameForm").on('submit', function (e) {

        if (clkBtn === "newGame") {
            resetGameNumber()
        }
        connect()
        userName = $("#userNameInForm").val()
        e.preventDefault()
    })
    $("#connect").click(function (evt) {
        clkBtn = evt.target.id
    })
    $("#newGame").click(function (evt) {
        clkBtn = evt.target.id
    })
    $("#disconnect").hide().click(function () {
        disconnect()
    })
})
