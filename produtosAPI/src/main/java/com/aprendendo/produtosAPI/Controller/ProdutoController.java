package com.aprendendo.produtosAPI.Controller;


import com.aprendendo.produtosAPI.Repository.ProdutosRepository;
import com.aprendendo.produtosAPI.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutosRepository produtosRepository;

    public ProdutoController(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto salvo "+ produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtosRepository.save(produto);
        return produto;
    }
    @GetMapping("/{id}")
    public Produto obterId(@PathVariable("id") String id){
        return produtosRepository.findById(id).orElse(null);
    }

    @DeleteMapping ("{id}")
    public void  deletar(@PathVariable("id") String id){
        produtosRepository.deleteById(id);
    }

    @PutMapping ("{id}")
    public void atulizar(@PathVariable("id") String id,@RequestBody Produto produto){
        produto.setId(id);
        produtosRepository.save(produto);

    }
    @GetMapping
    public List<Produto> buscar(@RequestParam("nome")String nome){
        return produtosRepository.findByNome(nome);
    }
}
