package com.stock.mvc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
public class LigneCommandeFournisseur implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public LigneCommandeFournisseur() {
		// TODO Auto-generated constructor stub
	}
	

}
