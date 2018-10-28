package com.stock.mvc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
public class LigneCommandeClient implements Serializable{
	@Id
	@GeneratedValue
	private Long idLigneCdeClt;
	@ManyToOne
	@JoinColumn(name = "idCommandeClient")
	private CommandeClient commandeClient;
	
	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;
	
	public Long getIdLigneCdeClt() {
		return idLigneCdeClt;
	}

	public void setIdLigneCdeClt(Long id) {
		this.idLigneCdeClt = id;
	}

	
public LigneCommandeClient() {
	// TODO Auto-generated constructor stub
}
	
	

}
