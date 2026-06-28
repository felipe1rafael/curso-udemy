package com.aprendendo.produtosAPI.Repository;

import com.aprendendo.produtosAPI.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutosRepository extends JpaRepository<Produto, String> {
    List<Produto> findByNome(String nome);

}
