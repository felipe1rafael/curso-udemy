package io.github.com.arquitetura;


import io.github.com.arquitetura.todos.TodoEntity;
import io.github.com.arquitetura.todos.TodoService;
import io.github.com.arquitetura.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy(false)
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class BeanGerenciado {

    @Autowired
    private TodoValidator validator;


    @Autowired
    public  BeanGerenciado(TodoValidator validator){
        this.validator= validator;

    }
    public void  utilizar(){
        var todo = new TodoEntity();
        validator.validar(todo);

    }
    @Autowired
    public void setValidator(TodoValidator validator){

        this.validator = validator;
    }






}
