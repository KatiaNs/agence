package beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the operations database table.
 * 
 */
@Entity
@Table(name="operations")
@NamedQuery(name="Operation.findAll", query="SELECT o FROM Operation o")
public class Operation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idOperation;

	@Column(name="DATE")
	private String dateOperation;

	@Column(name="HEURE")
	private String heureOperation;

	@Column(name = "NOCOMPTE")
	private String noCompte;

	@Column(name="OP")
	private String operation;

	private Float valeur;

	public Operation() {
	}

	public int getIdOperation() {
		return this.idOperation;
	}

	public void setIdOperation(int idOperation) {
		this.idOperation = idOperation;
	}

	public String getDateOperation() {
		return this.dateOperation;
	}

	public void setDateOperation(String dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getHeureOperation() {
		return this.heureOperation;
	}

	public void setHeureOperation(String heureOperation) {
		this.heureOperation = heureOperation;
	}

	public String getNoCompte() {
		return this.noCompte;
	}

	public void setNoCompte(String noCompte) {
		this.noCompte = noCompte;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Float getValeur() {
		return this.valeur;
	}

	public void setValeur(Float valeur) {
		this.valeur = valeur;
	}

}