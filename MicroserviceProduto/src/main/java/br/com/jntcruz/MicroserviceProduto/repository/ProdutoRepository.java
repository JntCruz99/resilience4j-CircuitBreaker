package br.com.jntcruz.MicroserviceProduto.repository;

import br.com.jntcruz.MicroserviceProduto.entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    Produto findByProdutoId(Integer produtoId);

}
