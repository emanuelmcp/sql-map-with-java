package org.example.database.managers;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.example.database.interfaces.DBConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresManager extends DBConfig {
    private HikariConfig hikariConfig = new HikariConfig();
    private HikariDataSource dataSource = new HikariDataSource();
    private static PostgresManager poolObject;

    private PostgresManager(){}

    public static PostgresManager getInstance(){
        if (poolObject == null) poolObject = new PostgresManager();
        poolObject.init();
        poolObject.setupPool();
        return poolObject;
    }

    public void init() {
        hostname = "localhost";
        port = "5432";
        database = "test_db";
        username = "root";
        password = "root";
    }
    public void setupPool(){
        init();
        hikariConfig.setJdbcUrl("jdbc:postgresql://" + hostname + ":" + port + "/" + database);
        hikariConfig.setDriverClassName("org.postgresql.Driver");
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setMinimumIdle(3);
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setConnectionTimeout(5000);
        dataSource = new HikariDataSource(hikariConfig);
    }

    public void close(Connection conn, PreparedStatement ps, ResultSet res) {
        if (conn != null) try { conn.close(); } catch (SQLException ignored) {}
        if (ps != null) try { ps.close(); } catch (SQLException ignored) {}
        if (res != null) try { res.close(); } catch (SQLException ignored) {}
    }
    public void closePool() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
