import com.mysql.cj.protocol.Resultset;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.*;
import java.util.List;

/* 功能： 通过jdbcTemplate 实现查询操作
 * 查询结果需要自己封装（实现RowMapper接口）
*/
public class HelloJdbcTemplate {
    private String jdbcurl = "jdbc:mysql://localhost:3306/springbootdb";
    private String username = "root";
    private String password = "13820381042bq";
    private String driverName = "com.mysql.cj.jdbc.Driver";
    DriverManagerDataSource datasource;
    JdbcTemplate jdbcTemplate;

    public HelloJdbcTemplate() {
        this.datasource = new DriverManagerDataSource();
        this.datasource.setDriverClassName(driverName);
        this.datasource.setUrl(jdbcurl);
        this.datasource.setPassword(password);
        this.datasource.setUsername(username);

        this.jdbcTemplate = new JdbcTemplate(datasource);

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //define datasource
        // var type only exist in java10
        HelloJdbcTemplate myJdbc = new HelloJdbcTemplate();
        String sql = "select * from city;";
        String sql2 = "insert into city values(?,?,?,?)"; //prepare statement
        //        List result = myJdbc.jdbcTemplate.queryForList(sql);
        //        int Row = myJdbc.jdbcTemplate.update(sql2, 3,3,"XiAn","Hello");
        // If you want to use Row Mapper -> you need to implements interface every time.
        List<City> cityList = myJdbc.jdbcTemplate.query(sql, new MyRowMapper());
        System.out.println(cityList.get(1));

    }

}
