package com.metalsa.meftp.journaltab;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MeftpJournalTd entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MEFTP_JOURNAL_TD", schema = "PUBLIC", catalog = "PUBLIC")
public class MeftpJournalTd implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5066778751266384789L;
	// Fields

	private Long meftpJournalJournaleventid;
	private String meftpJournalJournaleventname;
	private String meftpJournalJournaldescription;
	private String meftpJournalJournaluserlogin;
	private String meftpJournalJournaldateevent;

	// Constructors

	/** default constructor */
	public MeftpJournalTd() {
	}

	/** full constructor */
	public MeftpJournalTd(Long meftpJournalJournaleventid,
			String meftpJournalJournaleventname,
			String meftpJournalJournaldescription,
			String meftpJournalJournaluserlogin,
			String meftpJournalJournaldateevent) {
		this.meftpJournalJournaleventid = meftpJournalJournaleventid;
		this.meftpJournalJournaleventname = meftpJournalJournaleventname;
		this.meftpJournalJournaldescription = meftpJournalJournaldescription;
		this.meftpJournalJournaluserlogin = meftpJournalJournaluserlogin;
		this.meftpJournalJournaldateevent = meftpJournalJournaldateevent;
	}
	
	/** constructo without id */
	public MeftpJournalTd(
			String meftpJournalJournaleventname,
			String meftpJournalJournaldescription,
			String meftpJournalJournaluserlogin,
			String meftpJournalJournaldateevent) {
		this.meftpJournalJournaleventname = meftpJournalJournaleventname;
		this.meftpJournalJournaldescription = meftpJournalJournaldescription;
		this.meftpJournalJournaluserlogin = meftpJournalJournaluserlogin;
		this.meftpJournalJournaldateevent = meftpJournalJournaldateevent;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "MEFTP_JOURNAL_JOURNALEVENTID", unique = true, nullable = false)
	public Long getMeftpJournalJournaleventid() {
		return this.meftpJournalJournaleventid;
	}

	public void setMeftpJournalJournaleventid(Long meftpJournalJournaleventid) {
		this.meftpJournalJournaleventid = meftpJournalJournaleventid;
	}

	@Column(name = "MEFTP_JOURNAL_JOURNALEVENTNAME", nullable = false, length = 250)
	public String getMeftpJournalJournaleventname() {
		return this.meftpJournalJournaleventname;
	}

	public void setMeftpJournalJournaleventname(
			String meftpJournalJournaleventname) {
		this.meftpJournalJournaleventname = meftpJournalJournaleventname;
	}

	@Column(name = "MEFTP_JOURNAL_JOURNALDESCRIPTION", nullable = false, length = 250)
	public String getMeftpJournalJournaldescription() {
		return this.meftpJournalJournaldescription;
	}

	public void setMeftpJournalJournaldescription(
			String meftpJournalJournaldescription) {
		this.meftpJournalJournaldescription = meftpJournalJournaldescription;
	}

	@Column(name = "MEFTP_JOURNAL_JOURNALUSERLOGIN", nullable = false, length = 250)
	public String getMeftpJournalJournaluserlogin() {
		return this.meftpJournalJournaluserlogin;
	}

	public void setMeftpJournalJournaluserlogin(
			String meftpJournalJournaluserlogin) {
		this.meftpJournalJournaluserlogin = meftpJournalJournaluserlogin;
	}

	@Column(name = "MEFTP_JOURNAL_JOURNALDATEEVENT", nullable = false, length = 26)
	public String getMeftpJournalJournaldateevent() {
		return this.meftpJournalJournaldateevent;
	}

	public void setMeftpJournalJournaldateevent(
			String meftpJournalJournaldateevent) {
		this.meftpJournalJournaldateevent = meftpJournalJournaldateevent;
	}

}