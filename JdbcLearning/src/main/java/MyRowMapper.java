import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MyRowMapper implements RowMapper<City> {

    @Override
    public City mapRow(ResultSet resultSet, int i) throws SQLException {
        City mycity = new City();
        mycity.setCity_name(resultSet.getString("city_name"));
        mycity.setId(resultSet.getLong("id"));
        mycity.setDescription(resultSet.getString("description"));
        mycity.setProvince_id(resultSet.getLong("province_id"));
        return mycity;
    }
}
