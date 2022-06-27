package demo;

import demo.domain.Product;
import demo.mapper.ProductMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author leo
 * @date 20220627 18:10:36
 */
public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream is = Main.class.getClassLoader().getResourceAsStream("jdbc.properties")){
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String driver = properties.getProperty("jdbc.driver");
        String url = properties.getProperty("jdbc.url");
        String username = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        DataSource dataSource = new PooledDataSource(driver, url, username, password);
        Environment environment = new Environment("development", new JdbcTransactionFactory(), dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMappers("demo.mapper");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        try (SqlSession sqlsession = sqlSessionFactory.openSession()){
            ProductMapper mapper = sqlsession.getMapper(ProductMapper.class); //
            Product product = mapper.getOne();
            System.out.println(product);
        }
    }
}
