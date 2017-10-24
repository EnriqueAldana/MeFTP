package com.metalsa.meftp.user;


import com.metalsa.meftp.subgroup.MeftpSubgroupsTc;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * MeftpUsersTc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MEFTP_USERS_TC", schema = "PUBLIC", catalog = "PUBLIC", uniqueConstraints = {
		@UniqueConstraint(columnNames = "MEFTP_USERS_USEREMAILADDRESS"),
		@UniqueConstraint(columnNames = "MEFTP_USERS_USERNAMELOGIN") })
public class MeftpUsersTc implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5682799181488267546L;
	private Long meftpUsersUserid;
	private MeftpSubgroupsTc meftpSubgroupsTc;
	private String meftpUsersUsername;
	private String meftpUsersUsernamelogin;
	private String meftpUsersUserpassword;
	private String meftpUsersUserhomedirectory;
	private Boolean meftpUsersUserenabledflag;
	private Boolean meftpUsersUserwritepermission;
	private Integer meftpUsersUseridletime;
	private String meftpUsersUsercreatedate;
	private String meftpUsersUserexpires;
	private String meftpUsersUsercomments;
	private String meftpUsersUseremailaddress;
	private Boolean meftpUsersUseremailnotification;
	private Boolean meftpUsersUserisadmin;
	private Set<MeftpUsersTc> meftpUsersTcsForMeftpContactsUseridcontact = new HashSet<MeftpUsersTc>(
			0);
	private Set<MeftpUsersTc> meftpUsersTcsForMeftpContactsUserid = new HashSet<MeftpUsersTc>(
			0);

	// Constructors

	/** default constructor */
	public MeftpUsersTc() {
	}

	/** minimal constructor */
	public MeftpUsersTc(Long meftpUsersUserid, String meftpUsersUsername,
			String meftpUsersUsernamelogin, String meftpUsersUserpassword,
			String meftpUsersUserhomedirectory,
			Boolean meftpUsersUserenabledflag,
			Boolean meftpUsersUserwritepermission,
			Integer meftpUsersUseridletime, String meftpUsersUsercreatedate,
			String meftpUsersUserexpires, String meftpUsersUsercomments) {
		this.meftpUsersUserid = meftpUsersUserid;
		this.meftpUsersUsername = meftpUsersUsername;
		this.meftpUsersUsernamelogin = meftpUsersUsernamelogin;
		this.meftpUsersUserpassword = meftpUsersUserpassword;
		this.meftpUsersUserhomedirectory = meftpUsersUserhomedirectory;
		this.meftpUsersUserenabledflag = meftpUsersUserenabledflag;
		this.meftpUsersUserwritepermission = meftpUsersUserwritepermission;
		this.meftpUsersUseridletime = meftpUsersUseridletime;
		this.meftpUsersUsercreatedate = meftpUsersUsercreatedate;
		this.meftpUsersUserexpires = meftpUsersUserexpires;
		this.meftpUsersUsercomments = meftpUsersUsercomments;
	}

	/** full constructor */
	public MeftpUsersTc(Long meftpUsersUserid,
			MeftpSubgroupsTc meftpSubgroupsTc, String meftpUsersUsername,
			String meftpUsersUsernamelogin, String meftpUsersUserpassword,
			String meftpUsersUserhomedirectory,
			Boolean meftpUsersUserenabledflag,
			Boolean meftpUsersUserwritepermission,
			Integer meftpUsersUseridletime, String meftpUsersUsercreatedate,
			String meftpUsersUserexpires, String meftpUsersUsercomments,
			String meftpUsersUseremailaddress,
			Boolean meftpUsersUseremailnotification,
			Boolean meftpUsersUserisadmin,
			Set<MeftpUsersTc> meftpUsersTcsForMeftpContactsUseridcontact,
			Set<MeftpUsersTc> meftpUsersTcsForMeftpContactsUserid) {
		this.meftpUsersUserid = meftpUsersUserid;
		this.meftpSubgroupsTc = meftpSubgroupsTc;
		this.meftpUsersUsername = meftpUsersUsername;
		this.meftpUsersUsernamelogin = meftpUsersUsernamelogin;
		this.meftpUsersUserpassword = meftpUsersUserpassword;
		this.meftpUsersUserhomedirectory = meftpUsersUserhomedirectory;
		this.meftpUsersUserenabledflag = meftpUsersUserenabledflag;
		this.meftpUsersUserwritepermission = meftpUsersUserwritepermission;
		this.meftpUsersUseridletime = meftpUsersUseridletime;
		this.meftpUsersUsercreatedate = meftpUsersUsercreatedate;
		this.meftpUsersUserexpires = meftpUsersUserexpires;
		this.meftpUsersUsercomments = meftpUsersUsercomments;
		this.meftpUsersUseremailaddress = meftpUsersUseremailaddress;
		this.meftpUsersUseremailnotification = meftpUsersUseremailnotification;
		this.meftpUsersUserisadmin = meftpUsersUserisadmin;
		this.meftpUsersTcsForMeftpContactsUseridcontact = meftpUsersTcsForMeftpContactsUseridcontact;
		this.meftpUsersTcsForMeftpContactsUserid = meftpUsersTcsForMeftpContactsUserid;
	}

	
	public MeftpUsersTc(
			MeftpSubgroupsTc meftpSubgroupsTc, String meftpUsersUsername,
			String meftpUsersUsernamelogin, String meftpUsersUserpassword,
			String meftpUsersUserhomedirectory,
			Boolean meftpUsersUserenabledflag,
			Boolean meftpUsersUserwritepermission,
			Integer meftpUsersUseridletime, String meftpUsersUsercreatedate,
			String meftpUsersUserexpires, String meftpUsersUsercomments,
			String meftpUsersUseremailaddress,
			Boolean meftpUsersUseremailnotification,
			Boolean meftpUsersUserisadmin){
		
		this.meftpSubgroupsTc = meftpSubgroupsTc;
		this.meftpUsersUsername = meftpUsersUsername;
		this.meftpUsersUsernamelogin = meftpUsersUsernamelogin;
		this.meftpUsersUserpassword = meftpUsersUserpassword;
		this.meftpUsersUserhomedirectory = meftpUsersUserhomedirectory;
		this.meftpUsersUserenabledflag = meftpUsersUserenabledflag;
		this.meftpUsersUserwritepermission = meftpUsersUserwritepermission;
		this.meftpUsersUseridletime = meftpUsersUseridletime;
		this.meftpUsersUsercreatedate = meftpUsersUsercreatedate;
		this.meftpUsersUserexpires = meftpUsersUserexpires;
		this.meftpUsersUsercomments = meftpUsersUsercomments;
		this.meftpUsersUseremailaddress = meftpUsersUseremailaddress;
		this.meftpUsersUseremailnotification = meftpUsersUseremailnotification;
		this.meftpUsersUserisadmin = meftpUsersUserisadmin;
	}
	
	
	/** full constructor */
	public MeftpUsersTc(Long meftpUsersUserid,
			MeftpSubgroupsTc meftpSubgroupsTc, String meftpUsersUsername,
			String meftpUsersUsernamelogin, String meftpUsersUserpassword,
			String meftpUsersUserhomedirectory,
			Boolean meftpUsersUserenabledflag,
			Boolean meftpUsersUserwritepermission,
			Integer meftpUsersUseridletime, String meftpUsersUsercreatedate,
			String meftpUsersUserexpires, String meftpUsersUsercomments,
			String meftpUsersUseremailaddress,
			Boolean meftpUsersUseremailnotification,
			Boolean meftpUsersUserisadmin) {
		this.meftpUsersUserid = meftpUsersUserid;
		this.meftpSubgroupsTc = meftpSubgroupsTc;
		this.meftpUsersUsername = meftpUsersUsername;
		this.meftpUsersUsernamelogin = meftpUsersUsernamelogin;
		this.meftpUsersUserpassword = meftpUsersUserpassword;
		this.meftpUsersUserhomedirectory = meftpUsersUserhomedirectory;
		this.meftpUsersUserenabledflag = meftpUsersUserenabledflag;
		this.meftpUsersUserwritepermission = meftpUsersUserwritepermission;
		this.meftpUsersUseridletime = meftpUsersUseridletime;
		this.meftpUsersUsercreatedate = meftpUsersUsercreatedate;
		this.meftpUsersUserexpires = meftpUsersUserexpires;
		this.meftpUsersUsercomments = meftpUsersUsercomments;
		this.meftpUsersUseremailaddress = meftpUsersUseremailaddress;
		this.meftpUsersUseremailnotification = meftpUsersUseremailnotification;
		this.meftpUsersUserisadmin = meftpUsersUserisadmin;
	}
	
	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "MEFTP_USERS_USERID", unique = true, nullable = false)
	public Long getMeftpUsersUserid() {
		return this.meftpUsersUserid;
	}

	public void setMeftpUsersUserid(Long meftpUsersUserid) {
		this.meftpUsersUserid = meftpUsersUserid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEFTP_USERS_USERSUBGROUPID")
	public MeftpSubgroupsTc getMeftpSubgroupsTc() {
		return this.meftpSubgroupsTc;
	}

	public void setMeftpSubgroupsTc(MeftpSubgroupsTc meftpSubgroupsTc) {
		this.meftpSubgroupsTc = meftpSubgroupsTc;
	}

	@Column(name = "MEFTP_USERS_USERNAME", nullable = false, length = 250)
	public String getMeftpUsersUsername() {
		return this.meftpUsersUsername;
	}

	public void setMeftpUsersUsername(String meftpUsersUsername) {
		this.meftpUsersUsername = meftpUsersUsername;
	}

	@Column(name = "MEFTP_USERS_USERNAMELOGIN", unique = true, nullable = false, length = 25)
	public String getMeftpUsersUsernamelogin() {
		return this.meftpUsersUsernamelogin;
	}

	public void setMeftpUsersUsernamelogin(String meftpUsersUsernamelogin) {
		this.meftpUsersUsernamelogin = meftpUsersUsernamelogin;
	}

	@Column(name = "MEFTP_USERS_USERPASSWORD", nullable = false, length = 250)
	public String getMeftpUsersUserpassword() {
		return this.meftpUsersUserpassword;
	}

	public void setMeftpUsersUserpassword(String meftpUsersUserpassword) {
		this.meftpUsersUserpassword = meftpUsersUserpassword;
	}

	@Column(name = "MEFTP_USERS__USERHOMEDIRECTORY", nullable = false, length = 250)
	public String getMeftpUsersUserhomedirectory() {
		return this.meftpUsersUserhomedirectory;
	}

	public void setMeftpUsersUserhomedirectory(
			String meftpUsersUserhomedirectory) {
		this.meftpUsersUserhomedirectory = meftpUsersUserhomedirectory;
	}

	@Column(name = "MEFTP_USERS_USERENABLEDFLAG", nullable = false)
	public Boolean getMeftpUsersUserenabledflag() {
		return this.meftpUsersUserenabledflag;
	}

	public void setMeftpUsersUserenabledflag(Boolean meftpUsersUserenabledflag) {
		this.meftpUsersUserenabledflag = meftpUsersUserenabledflag;
	}

	@Column(name = "MEFTP_USERS_USERWRITEPERMISSION", nullable = false)
	public Boolean getMeftpUsersUserwritepermission() {
		return this.meftpUsersUserwritepermission;
	}

	public void setMeftpUsersUserwritepermission(
			Boolean meftpUsersUserwritepermission) {
		this.meftpUsersUserwritepermission = meftpUsersUserwritepermission;
	}

	@Column(name = "MEFTP_USERS_USERIDLETIME", nullable = false)
	public Integer getMeftpUsersUseridletime() {
		return this.meftpUsersUseridletime;
	}

	public void setMeftpUsersUseridletime(Integer meftpUsersUseridletime) {
		this.meftpUsersUseridletime = meftpUsersUseridletime;
	}

	@Column(name = "MEFTP_USERS_USERCREATEDATE", nullable = false, length = 26)
	public String getMeftpUsersUsercreatedate() {
		return this.meftpUsersUsercreatedate;
	}

	public void setMeftpUsersUsercreatedate(String meftpUsersUsercreatedate) {
		this.meftpUsersUsercreatedate = meftpUsersUsercreatedate;
	}

	@Column(name = "MEFTP_USERS_USEREXPIRES", nullable = false, length = 26)
	public String getMeftpUsersUserexpires() {
		return this.meftpUsersUserexpires;
	}

	public void setMeftpUsersUserexpires(String meftpUsersUserexpires) {
		this.meftpUsersUserexpires = meftpUsersUserexpires;
	}

	@Column(name = "MEFTP_USERS_USERCOMMENTS", nullable = false, length = 250)
	public String getMeftpUsersUsercomments() {
		return this.meftpUsersUsercomments;
	}

	public void setMeftpUsersUsercomments(String meftpUsersUsercomments) {
		this.meftpUsersUsercomments = meftpUsersUsercomments;
	}

	@Column(name = "MEFTP_USERS_USEREMAILADDRESS", unique = true, length = 250)
	public String getMeftpUsersUseremailaddress() {
		return this.meftpUsersUseremailaddress;
	}

	public void setMeftpUsersUseremailaddress(String meftpUsersUseremailaddress) {
		this.meftpUsersUseremailaddress = meftpUsersUseremailaddress;
	}

	@Column(name = "MEFTP_USERS_USEREMAILNOTIFICATION")
	public Boolean getMeftpUsersUseremailnotification() {
		return this.meftpUsersUseremailnotification;
	}

	public void setMeftpUsersUseremailnotification(
			Boolean meftpUsersUseremailnotification) {
		this.meftpUsersUseremailnotification = meftpUsersUseremailnotification;
	}

	@Column(name = "MEFTP_USERS_USERISADMIN")
	public Boolean getMeftpUsersUserisadmin() {
		return this.meftpUsersUserisadmin;
	}

	public void setMeftpUsersUserisadmin(Boolean meftpUsersUserisadmin) {
		this.meftpUsersUserisadmin = meftpUsersUserisadmin;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "meftpUsersTcsForMeftpContactsUserid")
	public Set<MeftpUsersTc> getMeftpUsersTcsForMeftpContactsUseridcontact() {
		return this.meftpUsersTcsForMeftpContactsUseridcontact;
	}

	public void setMeftpUsersTcsForMeftpContactsUseridcontact(
			Set<MeftpUsersTc> meftpUsersTcsForMeftpContactsUseridcontact) {
		this.meftpUsersTcsForMeftpContactsUseridcontact = meftpUsersTcsForMeftpContactsUseridcontact;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "MEFTP_CONTACTS_TR", schema = "PUBLIC", catalog = "PUBLIC", joinColumns = { @JoinColumn(name = "MEFTP_CONTACTS_USERIDCONTACT", updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "MEFTP_CONTACTS_USERID", updatable = false) })
	public Set<MeftpUsersTc> getMeftpUsersTcsForMeftpContactsUserid() {
		return this.meftpUsersTcsForMeftpContactsUserid;
	}

	public void setMeftpUsersTcsForMeftpContactsUserid(
			Set<MeftpUsersTc> meftpUsersTcsForMeftpContactsUserid) {
		this.meftpUsersTcsForMeftpContactsUserid = meftpUsersTcsForMeftpContactsUserid;
	}

}