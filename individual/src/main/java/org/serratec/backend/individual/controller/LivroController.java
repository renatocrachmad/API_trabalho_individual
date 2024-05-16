package org.serratec.backend.individual.controller;

import java.util.List;

import org.serratec.backend.individual.model.Livro;
import org.serratec.backend.individual.repository.LivroRepository;
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
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public ResponseEntity<List<Livro>> listarLivros() {
        List<Livro> livros = livroRepository.findAll();
        return ResponseEntity.ok(livros);
    }

    @PostMapping
    public ResponseEntity<Livro> criarLivro(@Valid @RequestBody Livro livro) {    	
        Livro novoLivro = livroRepository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @Valid @RequestBody Livro livroAtualizado) {
        Livro livroExistente = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        livroExistente.setTitulo(livroAtualizado.getTitulo());
        livroExistente.setInformacaoPublicacao(livroAtualizado.getInformacaoPublicacao());

        Livro livroAtualizadoEntity = livroRepository.save(livroExistente);
        return ResponseEntity.ok(livroAtualizadoEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
