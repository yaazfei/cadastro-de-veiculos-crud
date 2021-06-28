package com.yaazfei.cadastrodeveiculos.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@EnableMongoAuditing
@Document
public class Veiculo implements Persistable<String>{

	@Id
	private String id;
	private String veiculo;
	private Marca marca;
	private Integer ano;
	private String descricao;
	private Boolean vendido;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
	@CreatedDate
	private LocalDateTime created;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
	@LastModifiedDate
	private LocalDateTime updated;
	
	
	public String getId() {
		return id;
	}

	
	public void setId(String id) {
		this.id = id;
	}
	
	@NotBlank(message = "Veiculo não pode ser vazio.")
	public String getVeiculo() {
		return veiculo;
	}

	
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	

	@NotNull(message = "Ano não pode ser vazio.")
	public Integer getAno() {
		return ano;
	}

	@NotNull(message = "Marca não pode ser vazio.")
	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public void setAno(Integer ano) {
		this.ano = ano;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@NotNull(message = "Campo vendido não pode ser vazio.")
	public Boolean getVendido() {
		return vendido;
	}


	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}


	public LocalDateTime getCreated() {
		return created;
	}


	public void setCreated(LocalDateTime created) {
		this.created = created;
	}


	public LocalDateTime getUpdated() {
		return updated;
	}


	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}


	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", veiculo=" + veiculo + ", marca=" + marca + ", ano=" + ano + ", descricao="
				+ descricao + ", vendido=" + vendido + ", created=" + created + ", updated=" + updated + "]";
	}


	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return created == null;
	}


	
	
}
