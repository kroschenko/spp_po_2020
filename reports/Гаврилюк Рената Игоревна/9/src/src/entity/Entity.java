package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Entity {
    private int id;

    public Entity() { }

    public Entity(ResultSet rs) {}

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void setResultSet(ResultSet rs) throws SQLException;
}
