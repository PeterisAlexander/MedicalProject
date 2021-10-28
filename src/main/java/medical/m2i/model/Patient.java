/**
 * 
 */
package medical.m2i.model;

import java.io.Serializable;

/**
 * @author DESGOUILLES Pierre
 *
 */
public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String naissance;
	private String adresse;
	private String pays;
	private String ville;

	/**
	 * 
	 */
	public Patient() {
		super();
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param naissance
	 * @param adresse
	 * @param pays
	 * @param ville
	 */
	public Patient(String nom, String prenom, String naissance, String adresse, String pays, String ville) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.naissance = naissance;
		this.adresse = adresse;
		this.pays = pays;
		this.ville = ville;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the naissance
	 */
	public String getNaissance() {
		return naissance;
	}

	/**
	 * @param naissance the naissance to set
	 */
	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the pays
	 */
	public String getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(String pays) {
		this.pays = pays;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
}
