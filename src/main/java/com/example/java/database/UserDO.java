package com.example.java.database;

import net.lemnik.eodsql.BaseQuery;
import net.lemnik.eodsql.ResultColumn;
import net.lemnik.eodsql.Select;
import net.lemnik.eodsql.Update;

public class UserDO {
    @ResultColumn(value = "id")
    public int id;

    @ResultColumn(value = "name")
    public String name;

    public UserDO() {}

    public UserDO(String name) {
        this.name = name;
    }

    public interface UserDAI extends BaseQuery {
        @Select("SELECT id, name FROM users WHERE id = ?1")
        UserDO find(int id) throws java.sql.SQLException;

        @Select("SELECT id, name FROM users ORDER BY id")
        UserDO[] all() throws java.sql.SQLException;

        @Update("INSERT INTO users (name) VALUES (?{1.name})")
        void create(UserDO user) throws java.sql.SQLException;

        @Update("UPDATE users SET name = ?{1.name} WHERE id = ?{1.id}")
        void update(UserDO user) throws java.sql.SQLException;

        @Update("DELETE FROM users WHERE id = ?1")
        void delete(int id) throws java.sql.SQLException;
    }
}