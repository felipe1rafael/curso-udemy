package io.github.com.arquitetura.todos;

import org.springframework.stereotype.Service;

@Service
public class TodoService {


    private TodoRepository repository;
    private TodoValidator validator;
    private Mailsender mailsender;



    public TodoEntity salvar(TodoEntity novoTodo){
        validator.validar(novoTodo);
        return repository.save(novoTodo);
    }
    public void atualizarstatus(TodoEntity todo){
        repository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluido" : "Não concluido";
        mailsender.enviar("Todo  "+ todo.getDescricao() + " "+status);
    }

    public TodoEntity buscarPorId(Integer id){
        return  repository.findById(id).orElse(null);
    }
    public Mailsender getMailsender() {
        return mailsender;
    }

    public void setMailsender(Mailsender mailsender) {
        this.mailsender = mailsender;
    }

    public TodoValidator getValidator() {
        return validator;
    }

    public void setValidator(TodoValidator validator) {
        this.validator = validator;
    }

    public TodoRepository getRepository() {
        return repository;
    }

    public void setRepository(TodoRepository repository) {
        this.repository = repository;
    }

    public  TodoService(TodoRepository todoRepository
                        ,TodoValidator validator,
                        Mailsender mailsender){
        this.repository =todoRepository;
        this.mailsender = mailsender;
        this.validator = validator;
    }
}

