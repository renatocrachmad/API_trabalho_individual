package org.serratec.backend.individual.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @Embedded
    @Valid
    private InformacaoPublicacao informacaoPublicacao;   
    
    

	public Livro(Long id, @NotBlank(message = "O título é obrigatório") String titulo,
			@Valid InformacaoPublicacao informacaoPublicacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.informacaoPublicacao = informacaoPublicacao;
	}

	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public InformacaoPublicacao getInformacaoPublicacao() {
		return informacaoPublicacao;
	}

	public void setInformacaoPublicacao(InformacaoPublicacao informacaoPublicacao) {
		this.informacaoPublicacao = informacaoPublicacao;
	}

    
}

