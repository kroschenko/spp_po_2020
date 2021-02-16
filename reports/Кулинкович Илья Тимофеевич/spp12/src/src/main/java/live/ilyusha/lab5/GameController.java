package live.ilyusha.lab5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(final GameService gameService) {
        this.gameService = gameService;
    }

    @MessageMapping("/start")
    @SendTo("/topic/digit")
    public GameObject greeting(GameObject gameObject) {
        gameService.setNumbers(gameObject.getNumbers());
        return gameObject;
    }

    @GetMapping("/digits")
    public @ResponseBody
    List<Integer> getGameNumbers() {
        return gameService.getNumbers();
    }

    @PostMapping("/digits")
    public @ResponseBody
    void updateGameNumber() {
        gameService.generateNumbers();
    }
}