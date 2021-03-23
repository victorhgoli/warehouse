package com.wms.warehouse.api.controller;

import java.util.List;
import java.util.Optional;

import com.wms.warehouse.domain.model.Produto;
import com.wms.warehouse.domain.repository.ProdutoRepository;
import com.wms.warehouse.domain.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<Produto> buscar(@PathVariable Long produtoId) {
        Optional<Produto> produto = produtoRepository.findById(produtoId);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto adicionar(@RequestBody Produto produto) {
		return produtoService.salvar(produto);
	}

    @PutMapping("/{produtoId}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long produtoId,
			@RequestBody Produto produto) {
		
		if (!produtoRepository.existsById(produtoId)) {
			return ResponseEntity.notFound().build();
		}
		
		produto.setId(produtoId);
		produto = produtoService.salvar(produto);
		
		return ResponseEntity.ok(produto);
	}

    @DeleteMapping("/{produtoId}")
	public ResponseEntity<Void> remover(@PathVariable Long produtoId) {
		if (!produtoRepository.existsById(produtoId)) {
			return ResponseEntity.notFound().build();
		}
		
		produtoService.excluir(produtoId);
		
		return ResponseEntity.noContent().build();
	}

}
