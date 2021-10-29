package medical.m2i.model;

import java.io.Serializable;

public class Ville implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nom;
	private Integer code_postal;

	public Ville() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nom
	 * @param code_postal
	 */
	public Ville(Integer id, String nom, Integer code_postal) {
		super();
		this.id = id;
		this.nom = nom;
		this.code_postal = code_postal;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the code_postal
	 */
	public Integer getCode_postal() {
		return code_postal;
	}

	/**
	 * @param code_postal the code_postal to set
	 */
	public void setCode_postal(Integer code_postal) {
		this.code_postal = code_postal;
	}

}