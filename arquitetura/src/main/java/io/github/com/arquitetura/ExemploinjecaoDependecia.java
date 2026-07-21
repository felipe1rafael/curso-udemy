package io.github.com.arquitetura;

import io.github.com.arquitetura.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class ExemploinjecaoDependecia {

    public  static void main(String[] args) throws Exception{

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("user");
        dataSource.setPassword("senha");

        Connection connection = dataSource.getConnection();

        EntityManager entityManager = null;

        TodoRepository repository = null ;//new SimpleJpaRepository<TodoEntity, Integer>();
        TodoValidator validator = new TodoValidator(repository);
        Mailsender mailsender = new Mailsender();

        TodoService todoService  = new TodoService(repository,validator,mailsender);

//        BeanGerenciado beanGerenciado = new BeanGerenciado(null);
//       beanGerenciado.setValidator(validator);



    }
}
