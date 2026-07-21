
package io.github.com.arquitetura.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private  TodoRepository repository;


    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar(TodoEntity todo){
        if (existeTodoDescricao(todo.getDescricao())){
            throw new IllegalArgumentException("ja existe um todo m com essa descricao");
        }
    }
    public  Boolean existeTodoDescricao (String descricao){
        return  repository.existsByDescricao(descricao);
    }

    public TodoRepository getRepository() {
        return repository;
    }

    public void setRepository(TodoRepository repository) {
        this.repository = repository;
    }
}
