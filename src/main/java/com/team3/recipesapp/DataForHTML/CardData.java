package com.team3.recipesapp.DataForHTML;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CardData {
    private Connection conn;

    public CardData(Connection conn) {
        this.conn = conn;
    }

    public ResultSet getData() {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM table_name");
            return rs;
        } catch (SQLException e) {
            // handle the exception
        }
        return rs;
    }
}
