package org.example.database.mappers;

import org.example.database.models.Store;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreMapper {
    private static StoreMapper mapperObject;
    public Store mapRowReader(ResultSet rs) throws SQLException{
        return Store.builder()
                .phoneStore(rs.getString("phone"))
                .emailStore(rs.getString("street"))
                .cityStore(rs.getString("city"))
                .stateStore(rs.getString("state"))
                .zipCodeStore(rs.getString("zip_code"))
                .build();
    }

}
