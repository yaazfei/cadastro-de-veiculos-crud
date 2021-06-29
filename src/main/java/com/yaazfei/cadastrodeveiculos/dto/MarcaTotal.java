package com.yaazfei.cadastrodeveiculos.dto;

import org.springframework.data.mongodb.core.mapping.Field;

public class MarcaTotal {

    @Field("_id.marca")
    private String marca;
    @Field("count")
    private String total;
    
    
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
    
    
}
