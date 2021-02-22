package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Author extends Person{
    public Author() { }

    public Author(int id, String name, String surname, String middleName) {
        super(id, name, surname, middleName);
    }

    public Author(String name, String surname, String middleName) {
        super(name, surname, middleName);
    }

    public void setResultSet(ResultSet rs) throws SQLException {
        try {
            this.setId(rs.getInt("author_id"));
            this.setName(rs.getString("name"));
            this.setSurname(rs.getString("surname"));
            this.setMiddleName(rs.getString("middle_name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" + super.getId() + '\'' +
                "name='" + super.getName() + '\'' +
                ", surname='" + super.getSurname() + '\'' +
                ", middleName='" + super.getMiddleName() + '\'' +
                '}';
    }
}
