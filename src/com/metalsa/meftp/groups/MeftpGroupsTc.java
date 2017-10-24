package com.metalsa.meftp.groups;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.metalsa.meftp.subgroup.MeftpSubgroupsTc;

/**
 * MeftpGroupsTc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MEFTP_GROUPS_TC", schema = "PUBLIC", catalog = "PUBLIC")
public class MeftpGroupsTc implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5182330444431215282L;
	private Long meftpGroupsGroupid;
	private String meftpGroupsGroupname;
	private String meftpGroupsGroupdescription;
	private Boolean meftpGroupsGroupenable;
	private String meftpGroupsGroupexpireddate;
	private String meftpGroupsGroupemail;
	private Boolean meftpGroupsGroupemailnotification;
	private String meftpGroupsGroupcreateddate;
	private String meftpGroupsGroupcomments;
	private Set<MeftpSubgroupsTc> meftpSubgroupsTcs = new HashSet<MeftpSubgroupsTc>(
			0);

	// Constructors

	/** default constructor */
	public MeftpGroupsTc() {
	}

	/** minimal constructor */
	public MeftpGroupsTc(
			String meftpGroupsGroupname, String meftpGroupsGroupdescription,
			Boolean meftpGroupsGroupenable,
			String meftpGroupsGroupexpireddate,
			String meftpGroupsGroupemail,
			Boolean meftpGroupsGroupemailnotification,
			String meftpGroupsGroupcreateddate,
			String meftpGroupsGroupcomments) {
		this.meftpGroupsGroupname = meftpGroupsGroupname;
		this.meftpGroupsGroupdescription = meftpGroupsGroupdescription;
		this.meftpGroupsGroupenable = meftpGroupsGroupenable;
		this.meftpGroupsGroupexpireddate = meftpGroupsGroupexpireddate;
		this.meftpGroupsGroupemail = meftpGroupsGroupemail;
		this.meftpGroupsGroupemailnotification = meftpGroupsGroupemailnotification;
		this.meftpGroupsGroupcreateddate = meftpGroupsGroupcreateddate;
		this.meftpGroupsGroupcomments = meftpGroupsGroupcomments;
	}

	/** full constructor */
	public MeftpGroupsTc(Long meftpGroupsGroupid,
			String meftpGroupsGroupname, String meftpGroupsGroupdescription,
			Boolean meftpGroupsGroupenable,
			String meftpGroupsGroupexpireddate,
			String meftpGroupsGroupemail,
			Boolean meftpGroupsGroupemailnotification,
			String meftpGroupsGroupcreateddate,
			String meftpGroupsGroupcomments,
			Set<MeftpSubgroupsTc> meftpSubgroupsTcs) {
		this.meftpGroupsGroupid = meftpGroupsGroupid;
		this.meftpGroupsGroupname = meftpGroupsGroupname;
		this.meftpGroupsGroupdescription = meftpGroupsGroupdescription;
		this.meftpGroupsGroupenable = meftpGroupsGroupenable;
		this.meftpGroupsGroupexpireddate = meftpGroupsGroupexpireddate;
		this.meftpGroupsGroupemail = meftpGroupsGroupemail;
		this.meftpGroupsGroupemailnotification = meftpGroupsGroupemailnotification;
		this.meftpGroupsGroupcreateddate = meftpGroupsGroupcreateddate;
		this.meftpGroupsGroupcomments = meftpGroupsGroupcomments;
		this.meftpSubgroupsTcs = meftpSubgroupsTcs;
	}
	
	
	/** full constructor */
	public MeftpGroupsTc(Long meftpGroupsGroupid,
			String meftpGroupsGroupname, String meftpGroupsGroupdescription,
			Boolean meftpGroupsGroupenable,
			String meftpGroupsGroupexpireddate,
			String meftpGroupsGroupemail,
			Boolean meftpGroupsGroupemailnotification,
			String meftpGroupsGroupcreateddate,
			String meftpGroupsGroupcomments) {
		this.meftpGroupsGroupid = meftpGroupsGroupid;
		this.meftpGroupsGroupname = meftpGroupsGroupname;
		this.meftpGroupsGroupdescription = meftpGroupsGroupdescription;
		this.meftpGroupsGroupenable = meftpGroupsGroupenable;
		this.meftpGroupsGroupexpireddate = meftpGroupsGroupexpireddate;
		this.meftpGroupsGroupemail = meftpGroupsGroupemail;
		this.meftpGroupsGroupemailnotification = meftpGroupsGroupemailnotification;
		this.meftpGroupsGroupcreateddate = meftpGroupsGroupcreateddate;
		this.meftpGroupsGroupcomments = meftpGroupsGroupcomments;

	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "MEFTP_GROUPS_GROUPID", unique = true, nullable = false)
	public Long getMeftpGroupsGroupid() {
		return this.meftpGroupsGroupid;
	}

	public void setMeftpGroupsGroupid(Long meftpGroupsGroupid) {
		this.meftpGroupsGroupid = meftpGroupsGroupid;
	}

	@Column(name = "MEFTP_GROUPS_GROUPNAME", nullable = false, length = 250)
	public String getMeftpGroupsGroupname() {
		return this.meftpGroupsGroupname;
	}

	public void setMeftpGroupsGroupname(String meftpGroupsGroupname) {
		this.meftpGroupsGroupname = meftpGroupsGroupname;
	}

	@Column(name = "MEFTP_GROUPS_GROUPDESCRIPTION", nullable = false, length = 250)
	public String getMeftpGroupsGroupdescription() {
		return this.meftpGroupsGroupdescription;
	}

	public void setMeftpGroupsGroupdescription(
			String meftpGroupsGroupdescription) {
		this.meftpGroupsGroupdescription = meftpGroupsGroupdescription;
	}

	@Column(name = "MEFTP_GROUPS_GROUPENABLE", nullable = false)
	public Boolean getMeftpGroupsGroupenable() {
		return this.meftpGroupsGroupenable;
	}

	public void setMeftpGroupsGroupenable(Boolean meftpGroupsGroupenable) {
		this.meftpGroupsGroupenable = meftpGroupsGroupenable;
	}

	@Column(name = "MEFTP_GROUPS_GROUPEXPIREDDATE", nullable = false, length = 26)
	public String getMeftpGroupsGroupexpireddate() {
		return this.meftpGroupsGroupexpireddate;
	}

	public void setMeftpGroupsGroupexpireddate(
			String meftpGroupsGroupexpireddate) {
		this.meftpGroupsGroupexpireddate = meftpGroupsGroupexpireddate;
	}

	@Column(name = "MEFTP_GROUPS_GROUPEMAIL", nullable = false, length = 250)
	public String getMeftpGroupsGroupemail() {
		return this.meftpGroupsGroupemail;
	}

	public void setMeftpGroupsGroupemail(String meftpGroupsGroupemail) {
		this.meftpGroupsGroupemail = meftpGroupsGroupemail;
	}

	@Column(name = "MEFTP_GROUPS_GROUPEMAILNOTIFICATION", nullable = false)
	public Boolean getMeftpGroupsGroupemailnotification() {
		return this.meftpGroupsGroupemailnotification;
	}

	public void setMeftpGroupsGroupemailnotification(
			Boolean meftpGroupsGroupemailnotification) {
		this.meftpGroupsGroupemailnotification = meftpGroupsGroupemailnotification;
	}

	@Column(name = "MEFTP_GROUPS_GROUPCREATEDDATE", nullable = false, length = 26)
	public String getMeftpGroupsGroupcreateddate() {
		return this.meftpGroupsGroupcreateddate;
	}

	public void setMeftpGroupsGroupcreateddate(
			String meftpGroupsGroupcreateddate) {
		this.meftpGroupsGroupcreateddate = meftpGroupsGroupcreateddate;
	}

	@Column(name = "MEFTP_GROUPS_GROUPCOMMENTS", nullable = false, length = 250)
	public String getMeftpGroupsGroupcomments() {
		return this.meftpGroupsGroupcomments;
	}

	public void setMeftpGroupsGroupcomments(String meftpGroupsGroupcomments) {
		this.meftpGroupsGroupcomments = meftpGroupsGroupcomments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "meftpGroupsTc")
	public Set<MeftpSubgroupsTc> getMeftpSubgroupsTcs() {
		return this.meftpSubgroupsTcs;
	}

	public void setMeftpSubgroupsTcs(Set<MeftpSubgroupsTc> meftpSubgroupsTcs) {
		this.meftpSubgroupsTcs = meftpSubgroupsTcs;
	}

}