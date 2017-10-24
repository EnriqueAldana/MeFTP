package com.metalsa.meftp.subgroup;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.metalsa.meftp.groups.MeftpGroupsTc;
import com.metalsa.meftp.user.MeftpUsersTc;

/**
 * MeftpSubgroupsTc entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MEFTP_SUBGROUPS_TC", schema = "PUBLIC", catalog = "PUBLIC")
public class MeftpSubgroupsTc implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2360972650058633177L;
	private Long meftpSubgroupsSubgroupid;
	private MeftpGroupsTc meftpGroupsTc;
	private String meftpSubgroupsSubgroupname;
	private String meftpSubgroupsMeftpsubgroupdescription;
	private Boolean meftpSubgroupsSubgroupenable;
	private String meftpSubgroupsSubgroupexpireddate;
	private String meftpSubgroupsSubgroupemail;
	private Boolean meftpSubgroupsSubgroupemailnotification;
	private String meftpSubgroupsSubgroupcomments;
	private String meftpSubgroupsSubgroupcreateddate;
	private Long meftpSubgroupsSubgroupgroupid;
	private Set<MeftpUsersTc> meftpUsersTcs = new HashSet<MeftpUsersTc>(0);

	// Constructors

	/** default constructor */
	public MeftpSubgroupsTc() {
	}

	/** minimal constructor */
	public MeftpSubgroupsTc(
			String meftpSubgroupsSubgroupname,
			String meftpSubgroupsMeftpsubgroupdescription,
			Boolean meftpSubgroupsSubgroupenable,
			String meftpSubgroupsSubgroupexpireddate,
			String meftpSubgroupsSubgroupemail,
			Boolean meftpSubgroupsSubgroupemailnotification,
			String meftpSubgroupsSubgroupcomments,
			String meftpSubgroupsSubgroupcreateddate) {
		this.meftpSubgroupsSubgroupname = meftpSubgroupsSubgroupname;
		this.meftpSubgroupsMeftpsubgroupdescription = meftpSubgroupsMeftpsubgroupdescription;
		this.meftpSubgroupsSubgroupenable = meftpSubgroupsSubgroupenable;
		this.meftpSubgroupsSubgroupexpireddate = meftpSubgroupsSubgroupexpireddate;
		this.meftpSubgroupsSubgroupemail = meftpSubgroupsSubgroupemail;
		this.meftpSubgroupsSubgroupemailnotification = meftpSubgroupsSubgroupemailnotification;
		this.meftpSubgroupsSubgroupcomments = meftpSubgroupsSubgroupcomments;
		this.meftpSubgroupsSubgroupcreateddate = meftpSubgroupsSubgroupcreateddate;
	}

	/** full constructor */
	public MeftpSubgroupsTc(Long meftpSubgroupsSubgroupid,
			MeftpGroupsTc meftpGroupsTc, String meftpSubgroupsSubgroupname,
			String meftpSubgroupsMeftpsubgroupdescription,
			Boolean meftpSubgroupsSubgroupenable,
			String meftpSubgroupsSubgroupexpireddate,
			String meftpSubgroupsSubgroupemail,
			Boolean meftpSubgroupsSubgroupemailnotification,
			String meftpSubgroupsSubgroupcomments,
			String meftpSubgroupsSubgroupcreateddate,
			Set<MeftpUsersTc> meftpUsersTcs) {
		this.meftpSubgroupsSubgroupid = meftpSubgroupsSubgroupid;
		this.meftpGroupsTc = meftpGroupsTc;
		this.meftpSubgroupsSubgroupname = meftpSubgroupsSubgroupname;
		this.meftpSubgroupsMeftpsubgroupdescription = meftpSubgroupsMeftpsubgroupdescription;
		this.meftpSubgroupsSubgroupenable = meftpSubgroupsSubgroupenable;
		this.meftpSubgroupsSubgroupexpireddate = meftpSubgroupsSubgroupexpireddate;
		this.meftpSubgroupsSubgroupemail = meftpSubgroupsSubgroupemail;
		this.meftpSubgroupsSubgroupemailnotification = meftpSubgroupsSubgroupemailnotification;
		this.meftpSubgroupsSubgroupcomments = meftpSubgroupsSubgroupcomments;
		this.meftpSubgroupsSubgroupcreateddate = meftpSubgroupsSubgroupcreateddate;
		this.meftpUsersTcs = meftpUsersTcs;
	}
	
	public MeftpSubgroupsTc(
			MeftpGroupsTc meftpGroupsTc, String meftpSubgroupsSubgroupname,
			String meftpSubgroupsMeftpsubgroupdescription,
			Boolean meftpSubgroupsSubgroupenable,
			String meftpSubgroupsSubgroupexpireddate,
			String meftpSubgroupsSubgroupemail,
			Boolean meftpSubgroupsSubgroupemailnotification,
			String meftpSubgroupsSubgroupcomments,
			String meftpSubgroupsSubgroupcreateddate,
			Set<MeftpUsersTc> meftpUsersTcs) {
		this.meftpGroupsTc = meftpGroupsTc;
		this.meftpSubgroupsSubgroupname = meftpSubgroupsSubgroupname;
		this.meftpSubgroupsMeftpsubgroupdescription = meftpSubgroupsMeftpsubgroupdescription;
		this.meftpSubgroupsSubgroupenable = meftpSubgroupsSubgroupenable;
		this.meftpSubgroupsSubgroupexpireddate = meftpSubgroupsSubgroupexpireddate;
		this.meftpSubgroupsSubgroupemail = meftpSubgroupsSubgroupemail;
		this.meftpSubgroupsSubgroupemailnotification = meftpSubgroupsSubgroupemailnotification;
		this.meftpSubgroupsSubgroupcomments = meftpSubgroupsSubgroupcomments;
		this.meftpSubgroupsSubgroupcreateddate = meftpSubgroupsSubgroupcreateddate;
		this.meftpUsersTcs = meftpUsersTcs;
	}

	
	public MeftpSubgroupsTc(
			MeftpGroupsTc meftpGroupsTc, String meftpSubgroupsSubgroupname,
			String meftpSubgroupsMeftpsubgroupdescription,
			Boolean meftpSubgroupsSubgroupenable,
			String meftpSubgroupsSubgroupexpireddate,
			String meftpSubgroupsSubgroupemail,
			Boolean meftpSubgroupsSubgroupemailnotification,
			String meftpSubgroupsSubgroupcomments,
			String meftpSubgroupsSubgroupcreateddate) {
		this.meftpGroupsTc = meftpGroupsTc;
		this.meftpSubgroupsSubgroupname = meftpSubgroupsSubgroupname;
		this.meftpSubgroupsMeftpsubgroupdescription = meftpSubgroupsMeftpsubgroupdescription;
		this.meftpSubgroupsSubgroupenable = meftpSubgroupsSubgroupenable;
		this.meftpSubgroupsSubgroupexpireddate = meftpSubgroupsSubgroupexpireddate;
		this.meftpSubgroupsSubgroupemail = meftpSubgroupsSubgroupemail;
		this.meftpSubgroupsSubgroupemailnotification = meftpSubgroupsSubgroupemailnotification;
		this.meftpSubgroupsSubgroupcomments = meftpSubgroupsSubgroupcomments;
		this.meftpSubgroupsSubgroupcreateddate = meftpSubgroupsSubgroupcreateddate;
	
	}
	
	
	public MeftpSubgroupsTc(Long meftpSubgroupsSubgroupid,
			MeftpGroupsTc meftpGroupsTc, String meftpSubgroupsSubgroupname,
			String meftpSubgroupsMeftpsubgroupdescription,
			Boolean meftpSubgroupsSubgroupenable,
			String meftpSubgroupsSubgroupexpireddate,
			String meftpSubgroupsSubgroupemail,
			Boolean meftpSubgroupsSubgroupemailnotification,
			String meftpSubgroupsSubgroupcomments,
			String meftpSubgroupsSubgroupcreateddate) {
		this.meftpSubgroupsSubgroupid = meftpSubgroupsSubgroupid;
		this.meftpGroupsTc = meftpGroupsTc;
		this.meftpSubgroupsSubgroupname = meftpSubgroupsSubgroupname;
		this.meftpSubgroupsMeftpsubgroupdescription = meftpSubgroupsMeftpsubgroupdescription;
		this.meftpSubgroupsSubgroupenable = meftpSubgroupsSubgroupenable;
		this.meftpSubgroupsSubgroupexpireddate = meftpSubgroupsSubgroupexpireddate;
		this.meftpSubgroupsSubgroupemail = meftpSubgroupsSubgroupemail;
		this.meftpSubgroupsSubgroupemailnotification = meftpSubgroupsSubgroupemailnotification;
		this.meftpSubgroupsSubgroupcomments = meftpSubgroupsSubgroupcomments;
		this.meftpSubgroupsSubgroupcreateddate = meftpSubgroupsSubgroupcreateddate;
	}
	

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "MEFTP_SUBGROUPS_SUBGROUPID", unique = true, nullable = false)
	public Long getMeftpSubgroupsSubgroupid() {
		return this.meftpSubgroupsSubgroupid;
	}

	public void setMeftpSubgroupsSubgroupid(Long meftpSubgroupsSubgroupid) {
		this.meftpSubgroupsSubgroupid = meftpSubgroupsSubgroupid;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MEFTP_SUBGROUPS_SUBGROUPGROUPID")
	public MeftpGroupsTc getMeftpGroupsTc() {
		return this.meftpGroupsTc;
	}

	public void setMeftpGroupsTc(MeftpGroupsTc meftpGroupsTc) {
		this.meftpGroupsTc = meftpGroupsTc;
	}

	@Column(name = "MEFTP_SUBGROUPS_SUBGROUPNAME", nullable = false, length = 250)
	public String getMeftpSubgroupsSubgroupname() {
		return this.meftpSubgroupsSubgroupname;
	}

	public void setMeftpSubgroupsSubgroupname(String meftpSubgroupsSubgroupname) {
		this.meftpSubgroupsSubgroupname = meftpSubgroupsSubgroupname;
	}

	@Column(name = "MEFTP_SUBGROUPS_MEFTPSUBGROUPDESCRIPTION", nullable = false, length = 250)
	public String getMeftpSubgroupsMeftpsubgroupdescription() {
		return this.meftpSubgroupsMeftpsubgroupdescription;
	}

	public void setMeftpSubgroupsMeftpsubgroupdescription(
			String meftpSubgroupsMeftpsubgroupdescription) {
		this.meftpSubgroupsMeftpsubgroupdescription = meftpSubgroupsMeftpsubgroupdescription;
	}

	@Column(name = "MEFTP_SUBGROUPS_SUBGROUPENABLE", nullable = false)
	public Boolean getMeftpSubgroupsSubgroupenable() {
		return this.meftpSubgroupsSubgroupenable;
	}

	public void setMeftpSubgroupsSubgroupenable(
			Boolean meftpSubgroupsSubgroupenable) {
		this.meftpSubgroupsSubgroupenable = meftpSubgroupsSubgroupenable;
	}

	@Column(name = "MEFTP_SUBGROUPS_SUBGROUPEXPIREDDATE", nullable = false, length = 26)
	public String getMeftpSubgroupsSubgroupexpireddate() {
		return this.meftpSubgroupsSubgroupexpireddate;
	}

	public void setMeftpSubgroupsSubgroupexpireddate(
			String meftpSubgroupsSubgroupexpireddate) {
		this.meftpSubgroupsSubgroupexpireddate = meftpSubgroupsSubgroupexpireddate;
	}

	@Column(name = "MEFTP_SUBGROUPS_SUBGROUPEMAIL", nullable = false, length = 250)
	public String getMeftpSubgroupsSubgroupemail() {
		return this.meftpSubgroupsSubgroupemail;
	}

	public void setMeftpSubgroupsSubgroupemail(
			String meftpSubgroupsSubgroupemail) {
		this.meftpSubgroupsSubgroupemail = meftpSubgroupsSubgroupemail;
	}

	@Column(name = "MEFTP_SUBGROUPS_SUBGROUPEMAILNOTIFICATION", nullable = false)
	public Boolean getMeftpSubgroupsSubgroupemailnotification() {
		return this.meftpSubgroupsSubgroupemailnotification;
	}

	public void setMeftpSubgroupsSubgroupemailnotification(
			Boolean meftpSubgroupsSubgroupemailnotification) {
		this.meftpSubgroupsSubgroupemailnotification = meftpSubgroupsSubgroupemailnotification;
	}

	@Column(name = "MEFTP_SUBGROUPS_SUBGROUPCOMMENTS", nullable = false, length = 250)
	public String getMeftpSubgroupsSubgroupcomments() {
		return this.meftpSubgroupsSubgroupcomments;
	}

	public void setMeftpSubgroupsSubgroupcomments(
			String meftpSubgroupsSubgroupcomments) {
		this.meftpSubgroupsSubgroupcomments = meftpSubgroupsSubgroupcomments;
	}

	@Column(name = "MEFTP_SUBGROUPS_SUBGROUPCREATEDDATE", nullable = false, length = 26)
	public String getMeftpSubgroupsSubgroupcreateddate() {
		return this.meftpSubgroupsSubgroupcreateddate;
	}

	public void setMeftpSubgroupsSubgroupcreateddate(
			String meftpSubgroupsSubgroupcreateddate) {
		this.meftpSubgroupsSubgroupcreateddate = meftpSubgroupsSubgroupcreateddate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "meftpSubgroupsTc")
	public Set<MeftpUsersTc> getMeftpUsersTcs() {
		return this.meftpUsersTcs;
	}

	public void setMeftpUsersTcs(Set<MeftpUsersTc> meftpUsersTcs) {
		this.meftpUsersTcs = meftpUsersTcs;
	}

}