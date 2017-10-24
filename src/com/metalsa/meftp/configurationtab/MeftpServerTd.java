package com.metalsa.meftp.configurationtab;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MeftpServerTd entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MEFTP_SERVER_TD", schema = "PUBLIC", catalog = "PUBLIC")
public class MeftpServerTd implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1357966720805943965L;
	private Integer meftpServerServeridpropertie;
	private String meftpServerServerkeypropertie;
	private String meftpServerServervaluepropertie;

	// Constructors

	/** default constructor */
	public MeftpServerTd() {
	}

	/** full constructor */
	public MeftpServerTd(Integer meftpServerServeridpropertie,
			String meftpServerServerkeypropertie,
			String meftpServerServervaluepropertie) {
		this.meftpServerServeridpropertie = meftpServerServeridpropertie;
		this.meftpServerServerkeypropertie = meftpServerServerkeypropertie;
		this.meftpServerServervaluepropertie = meftpServerServervaluepropertie;
	}

	// Property accessors
	@Id
	@Column(name = "MEFTP_SERVER_SERVERIDPROPERTIE", unique = true, nullable = false)
	public Integer getMeftpServerServeridpropertie() {
		return this.meftpServerServeridpropertie;
	}

	public void setMeftpServerServeridpropertie(
			Integer meftpServerServeridpropertie) {
		this.meftpServerServeridpropertie = meftpServerServeridpropertie;
	}

	@Column(name = "MEFTP_SERVER_SERVERKEYPROPERTIE", nullable = false, length = 250)
	public String getMeftpServerServerkeypropertie() {
		return this.meftpServerServerkeypropertie;
	}

	public void setMeftpServerServerkeypropertie(
			String meftpServerServerkeypropertie) {
		this.meftpServerServerkeypropertie = meftpServerServerkeypropertie;
	}

	@Column(name = "MEFTP_SERVER_SERVERVALUEPROPERTIE", nullable = false, length = 250)
	public String getMeftpServerServervaluepropertie() {
		return this.meftpServerServervaluepropertie;
	}

	public void setMeftpServerServervaluepropertie(
			String meftpServerServervaluepropertie) {
		this.meftpServerServervaluepropertie = meftpServerServervaluepropertie;
	}

}