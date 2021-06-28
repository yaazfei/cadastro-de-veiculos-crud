package com.yaazfei.cadastrodeveiculos.dto;

import javax.validation.constraints.NotNull;

public class StatusVenda {
	
	@NotNull
	private Boolean vendido;

	public Boolean getVendido() {
		return vendido;
	}

	public void setVendido(Boolean vendido) {
		this.vendido = vendido;
	}
	
	
}
