package beans;

import java.io.Serializable;

public class Offre implements Serializable {
	
	// c'est la ref de l'offrre
	private Integer id;
	private String title;
	private Double price;
	private String image;
	private String dateCreation;
	
	// proprio du bien
	// private user proprio;
	
	// email du proprio
	private String mail_proprio;
	private Integer etat;
	private String typeBien;
	private String typeOffre;
	private String description;
	private String address;
	private Integer etage;
	private Double surfaceMaison;
	private Double surfaceTerrain;
	private Integer presenceParking;
	private Integer nombrePieces;
	private String libelle;
	
	public Offre() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getMail_proprio() {
		return mail_proprio;
	}

	public void setMail_proprio(String mail_proprio) {
		this.mail_proprio = mail_proprio;
	}

	public Integer getEtat() {
		return etat;
	}

	public void setEtat(Integer etat) {
		this.etat = etat;
	}

	public String getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	public String getTypeOffre() {
		return typeOffre;
	}

	public void setTypeOffre(String typeOffre) {
		this.typeOffre = typeOffre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getEtage() {
		return etage;
	}

	public void setEtage(Integer etage) {
		this.etage = etage;
	}

	public Double getSurfaceMaison() {
		return surfaceMaison;
	}

	public void setSurfaceMaison(Double surfaceMaison) {
		this.surfaceMaison = surfaceMaison;
	}

	public Double getSurfaceTerrain() {
		return surfaceTerrain;
	}

	public void setSurfaceTerrain(Double surfaceTerrain) {
		this.surfaceTerrain = surfaceTerrain;
	}

	public Integer getPresenceParking() {
		return presenceParking;
	}

	public void setPresenceParking(Integer presenceParking) {
		this.presenceParking = presenceParking;
	}

	public Integer getNombrePieces() {
		return nombrePieces;
	}

	public void setNombrePieces(Integer nombrePieces) {
		this.nombrePieces = nombrePieces;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}