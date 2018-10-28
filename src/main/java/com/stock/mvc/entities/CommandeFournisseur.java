package com.stock.mvc.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class CommandeFournisseur implements Serializable{
	@Id
	@GeneratedValue
	private Long idCommandeFournisseur;
	private String code;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommande;
	@ManyToOne
	@JoinColumn(name = "idFournisseur")
	private Fournisseur fournisseur;
	@OneToMany(mappedBy ="commandeFournisseur")
	private List<LigneCommandeFournisseur> ligneCommandeFournisseur;
	public Long getIdCommandeFournisseur() {
		return idCommandeFournisseur;
	}

	public void setIdCommandeFournisseur(Long id) {
		this.idCommandeFournisseur = id;
	}

	public CommandeFournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<LigneCommandeFournisseur> getLigneCommandeFournisseur() {
		return ligneCommandeFournisseur;
	}

	public void setLigneCommandeFournisseur(List<LigneCommandeFournisseur> ligneCommandeFournisseur) {
		this.ligneCommandeFournisseur = ligneCommandeFournisseur;
	}


}
