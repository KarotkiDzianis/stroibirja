package beans;

public class AdBean {

	private Integer adId;
	private String adName;
	private Integer adAuthor;

	public AdBean() {

	}

	public AdBean(Integer adId, String adName) {
		this.adId = adId;
		this.adName = adName;
	}

	public int getAdId() {
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

	public int getAdAuthor() {
		return adAuthor;
	}

	public void setAdAuthor(Integer adAuthor) {
		this.adAuthor = adAuthor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((adName == null) ? 0 : adName.hashCode());
		result = prime * result + ((adAuthor == null) ? 0 : adAuthor.hashCode());

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

		AdBean other = (AdBean) obj;
		if (adName == null) {
			if (other.adName != null) {
				return false;
			}
		} else if (!adName.equals(other.adName)) {
			return false;
		}

		if (adAuthor == null) {
			if (other.adAuthor != null) {
				return false;
			}
		} else if (!adAuthor.equals(other.adAuthor)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "Ad [Id=" + adId + ", Name=" + adName + ", Author=" + adAuthor + "]";

	}

}
