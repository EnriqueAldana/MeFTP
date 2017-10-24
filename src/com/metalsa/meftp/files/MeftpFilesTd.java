package com.metalsa.meftp.files;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MeftpFilesTd entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MEFTP_FILES_TD", schema = "PUBLIC", catalog = "PUBLIC")
public class MeftpFilesTd implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2756904525967434586L;
	private Integer meftpFilesFileid;
	private String meftpFilesFilename;
	private String meftpFilesFilepath;
	private Integer meftpFilesOwnerfileid;
	private Integer meftpFilesFilesize;
	private String meftpFilesFiletype;
	private String meftpFilesFilecretateddate;
	//private Byte	meftpFilesFilecontent;

	// Constructors

	/** default constructor */
	public MeftpFilesTd() {
	}

	/** minimal constructor */
	public MeftpFilesTd(Integer meftpFilesFileid, String meftpFilesFilename,
			String meftpFilesFilepath, Integer meftpFilesOwnerfileid,
			Integer meftpFilesFilesize, String meftpFilesFiletype) {
		this.meftpFilesFileid = meftpFilesFileid;
		this.meftpFilesFilename = meftpFilesFilename;
		this.meftpFilesFilepath = meftpFilesFilepath;
		this.meftpFilesOwnerfileid = meftpFilesOwnerfileid;
		this.meftpFilesFilesize = meftpFilesFilesize;
		this.meftpFilesFiletype = meftpFilesFiletype;
	}
	
	
	/** full constructor for update */
	public MeftpFilesTd(Integer meftpFilesFileid, String meftpFilesFilename,
			String meftpFilesFilepath, Integer meftpFilesOwnerfileid,
			Integer meftpFilesFilesize, String meftpFilesFiletype,
			String meftpFilesFilecretateddate) {
		this.meftpFilesFileid = meftpFilesFileid;
		this.meftpFilesFilename = meftpFilesFilename;
		this.meftpFilesFilepath = meftpFilesFilepath;
		this.meftpFilesOwnerfileid = meftpFilesOwnerfileid;
		this.meftpFilesFilesize = meftpFilesFilesize;
		this.meftpFilesFiletype = meftpFilesFiletype;
		this.meftpFilesFilecretateddate = meftpFilesFilecretateddate;
	}
	
	/** constructor without id for save records*/
	public MeftpFilesTd(String meftpFilesFilename,
			String meftpFilesFilepath, Integer meftpFilesOwnerfileid,
			Integer meftpFilesFilesize, String meftpFilesFiletype,
			String meftpFilesFilecretateddate) {
		this.meftpFilesFilename = meftpFilesFilename;
		this.meftpFilesFilepath = meftpFilesFilepath;
		this.meftpFilesOwnerfileid = meftpFilesOwnerfileid;
		this.meftpFilesFilesize = meftpFilesFilesize;
		this.meftpFilesFiletype = meftpFilesFiletype;
		this.meftpFilesFilecretateddate = meftpFilesFilecretateddate;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "MEFTP_FILES_FILEID", unique = true, nullable = false)
	public Integer getMeftpFilesFileid() {
		return this.meftpFilesFileid;
	}

	public void setMeftpFilesFileid(Integer meftpFilesFileid) {
		this.meftpFilesFileid = meftpFilesFileid;
	}

	@Column(name = "MEFTP_FILES_FILENAME", nullable = false, length = 250)
	public String getMeftpFilesFilename() {
		return this.meftpFilesFilename;
	}

	public void setMeftpFilesFilename(String meftpFilesFilename) {
		this.meftpFilesFilename = meftpFilesFilename;
	}

	@Column(name = "MEFTP_FILES_FILEPATH", nullable = false, length = 250)
	public String getMeftpFilesFilepath() {
		return this.meftpFilesFilepath;
	}

	public void setMeftpFilesFilepath(String meftpFilesFilepath) {
		this.meftpFilesFilepath = meftpFilesFilepath;
	}

	@Column(name = "MEFTP_FILES_OWNERFILEID", nullable = false)
	public Integer getMeftpFilesOwnerfileid() {
		return this.meftpFilesOwnerfileid;
	}

	public void setMeftpFilesOwnerfileid(Integer meftpFilesOwnerfileid) {
		this.meftpFilesOwnerfileid = meftpFilesOwnerfileid;
	}

	@Column(name = "MEFTP_FILES_FILESIZE", nullable = false)
	public Integer getMeftpFilesFilesize() {
		return this.meftpFilesFilesize;
	}

	public void setMeftpFilesFilesize(Integer meftpFilesFilesize) {
		this.meftpFilesFilesize = meftpFilesFilesize;
	}

	@Column(name = "MEFTP_FILES_FILETYPE", nullable = false, length = 250)
	public String getMeftpFilesFiletype() {
		return this.meftpFilesFiletype;
	}

	public void setMeftpFilesFiletype(String meftpFilesFiletype) {
		this.meftpFilesFiletype = meftpFilesFiletype;
	}

	@Column(name = "MEFTP_FILES_FILECRETATEDDATE", length = 26)
	public String getMeftpFilesFilecretateddate() {
		return this.meftpFilesFilecretateddate;
	}

	public void setMeftpFilesFilecretateddate(
			String meftpFilesFilecretateddate) {
		this.meftpFilesFilecretateddate = meftpFilesFilecretateddate;
	}

/*	public Byte getMeftpFilesContent() {
		return meftpFilesFilecontent;
	}

	public void setMeftpFilesContent(Byte meftpFilesFilecontent) {
		this.meftpFilesFilecontent = meftpFilesFilecontent;
	}*/
	
}