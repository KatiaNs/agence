package beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the exemple_simple database table.
 * 
 */
@Entity
@Table(name="exemple_simple")
@NamedQuery(name="ExempleSimple.findAll", query="SELECT e FROM ExempleSimple e")
public class ExempleSimple implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String libelle;

	public ExempleSimple() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}