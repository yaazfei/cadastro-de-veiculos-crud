package com.yaazfei.cadastrodeveiculos.dto;

import org.springframework.data.mongodb.core.mapping.Field;

public class AnoTotal {

    @Field("_id.ano")
    private String ano;
    @Field("count")
    private String total;
    
    
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
    
}
