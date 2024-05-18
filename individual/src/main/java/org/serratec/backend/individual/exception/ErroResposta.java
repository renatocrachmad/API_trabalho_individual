package org.serratec.backend.individual.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {
	private Integer status;
    private String titulo;
    private LocalDateTime horario;
    private List<String> erros;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public LocalDateTime getHorario() {
		return horario;
	}
	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}
	public ErroResposta(Integer status, String titulo, LocalDateTime horario, List<String> erros) {
		super();
		this.status = status;
		this.titulo = titulo;
		this.horario = horario;
		this.erros = erros;
	}
	public List<String> getErros() {
		return erros;
	}
	public void setErros(List<String> erros) {
		this.erros = erros;
	}

    
}
