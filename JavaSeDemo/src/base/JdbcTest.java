package base;

import org.junit.Test;
import pojo.Person;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yusheng
 * @create-date: 2019-11-13 01:46
 **/
public class JdbcTest {
    Connection conn = null;
    String driverClass = "com.mysql.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/test";
    String user = "root";
    String password = "123456";


    public Connection getConn() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        // 注册jdbc驱动
        DriverManager.registerDriver((Driver) Class.forName(driverClass).getDeclaredConstructor().newInstance());
        conn = DriverManager.getConnection(jdbcUrl, user, password);
        return conn;
    }

    @Test
    public void testUpdate() throws SQLException {
        //曾
        String sql = "insert into employee (Id,Name,Password) values (1,'wangba',131)";
        //删
        //String sql = "delete from employee where id = 1";
        //改
        //String sql = "update employee set name = 'fuck' where id = 2";
        //查
        String sqlQuery = "select * from employee";
        update(sql);
        testQueryObject(sqlQuery);
    }

    public void testQueryObject(String sql) throws SQLException {
        Person employee = null;
        List<Person> list = new ArrayList();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            //创建连接
            conn = getConn();
            //创建prepareStatement对象，用于执行SQL
            ps = conn.prepareStatement(sql);
            //获取查询结果集
            result = ps.executeQuery();
            while (result.next()) {
                // result.getInt(n)获取查询结果集的第n列
                employee = new Person(result.getInt(1), Integer.valueOf(result.getString(2)));
                list.add(employee);
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            conn.close();
        }
    }

    public void update(String sql) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //创建数据库连接
            conn = getConn();
            //创建执行SQL的prepareStatement对象
            ps = conn.prepareStatement(sql);
            //用于增删改操作
            int result = ps.executeUpdate();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("出现异常=" + e.toString());
        } finally {
            ps.close();
            conn.close();
        }


    }
}
