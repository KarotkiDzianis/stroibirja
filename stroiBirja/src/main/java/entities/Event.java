package entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Event")
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "eventId")
	private Integer eventId;

	
	@ManyToOne (fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "eventNumber")
	private Ad eventNumber;

	@Column(name = "ispId")
	private Organization ispl;

	@Column(name = "eventRol")
	private Integer eventRol;
/*
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)*/
	@JoinTable()
	private Organization isp;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventNumber == null) ? 0 : eventNumber.hashCode());
		result = prime * result + ((ispl == null) ? 0 : ispl.hashCode());
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

		Event other = (Event) obj;
		if (eventNumber == null) {
			if (other.eventNumber != null) {
				return false;
			}
		} else if (!eventNumber.equals(other.eventNumber)) {
			return false;
		}

		if (ispl == null) {
			if (other.ispl != null) {
				return false;
			}
		} else if (!ispl.equals(other.ispl)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + eventId + ", Number=" + eventNumber + ", isp=" + ispl + "]";
	}
}
