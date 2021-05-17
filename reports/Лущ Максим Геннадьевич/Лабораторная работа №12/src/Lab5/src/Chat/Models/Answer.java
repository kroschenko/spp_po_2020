package Chat.Models;

import java.io.*;

public class Answer implements Serializable {
    protected static final long serialVersionUID = 1112122200L;

    private final MessageType type;
    private final String message;

    public Answer(MessageType type, String message) {
        this.type = type;
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
