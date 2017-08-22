package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

@NamedQuery(name = "Org.findByOrgName", query = "select u from Organization u where u.name = :name")

@Entity
@Table(name = "organization")
public class Organization implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orgId")
	private int orgId;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	
	@Column(name = "rol")
	private int rol;

	/*@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<Event> authorEvents;*/

	
	
	/*@ManyToMany
	@JoinTable( name= "Event", joinColumns = {@JoinColumn (name="ispId")}, inverseJoinColumns = {@JoinColumn (name = "eventNumber")} )
	private List<Ad> events;
*/
	public Organization() {

	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	/*public List<Event> getAuthorEvents() {
		return authorEvents;
	}

	public void setAuthorEvents(List<Event> authorEvents) {
		this.authorEvents = authorEvents;
	}

	public List<Event> getWhoIsp() {
		return whoIsp;
	}

	public void setWhoIsp(List<Event> whoIsp) {
		this.whoIsp = whoIsp;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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

		Organization other = (Organization) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "Organization [id=" + orgId + ", Name=" + name + ", password=" + password + "]";
	}
}
