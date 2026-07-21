package io.github.com.arquitetura.todos;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("todos")
public class TodoController {

    private  TodoService service;

    public TodoController(TodoService service){
        this.service =service;
    }

    @PostMapping
    public  TodoEntity salvar(@RequestBody TodoEntity todo){
        try {
            return this.service.salvar(todo);
        }catch (IllegalArgumentException e){
            var mesagem =  e.getMessage();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST , mesagem);
        }


    }
    @PutMapping("{id}")
    public  void atulizarStatus(@PathVariable("id")Integer id,@RequestBody TodoEntity todo){
        todo.setId(id);
        service.atualizarstatus(todo);
    }
    @GetMapping("{id}")
    public TodoEntity buscar(@PathVariable("id") Integer id){
        return service.buscarPorId(id);
    }
}
