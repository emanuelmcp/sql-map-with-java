package org.example.database.implementations;

import org.example.database.interfaces.StoresRepository;
import org.example.database.managers.PostgresManager;
import org.example.database.models.Store;
import org.example.database.queries.StoreQueries;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StoresRepositoryImpl implements StoresRepository {
    PostgresManager pool = PostgresManager.getInstance();
    Connection connection;
    PreparedStatement statement;
    ResultSet queryResult;

    @Override
    public Optional<Store> findByID(String id) {
        Optional<Store> store = Optional.empty();
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(StoreQueries.FIND_BY_ID);
            queryResult = statement.executeQuery();
            if (!queryResult.next()) return store;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            pool.close(connection, statement, queryResult);
        }
        return store;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public void save(Object model) {

    }

    @Override
    public void update(Object model) {

    }

    @Override
    public void delete(Object model) {

    }
}
