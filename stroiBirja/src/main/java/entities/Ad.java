<<<<<<< HEAD
package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "Ad")
public class Ad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adId")
	private Integer adId;

	@Column(name = "adName")
	private String adName;


	/*@ManyToMany  (mappedBy = "events")  /*(fetch = FetchType.LAZY)*/
	/*@JoinColumn(name = "adAuthor")*/
	private Organization author;

	public Ad() {
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((adName == null) ? 0 : adName.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		Ad other = (Ad) obj;
		if (adName == null) {
			if (other.adName != null) {
				return false;
			}
		} else if (!adName.equals(other.adName)) {
			return false;
		}

		return true;
	}

}
=======
package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "Ad")
public class Ad implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adId")
	private Integer adId;

	@Column(name = "adName")
	private String adName;


	/*@ManyToMany  (mappedBy = "events")  /*(fetch = FetchType.LAZY)*/
	/*@JoinColumn(name = "adAuthor")*/
	private Organization author;

	public Ad() {
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((adName == null) ? 0 : adName.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		Ad other = (Ad) obj;
		if (adName == null) {
			if (other.adName != null) {
				return false;
			}
		} else if (!adName.equals(other.adName)) {
			return false;
		}

		return true;
	}

}
>>>>>>> N commit from master
