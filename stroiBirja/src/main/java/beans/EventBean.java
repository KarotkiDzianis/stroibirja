package beans;


public class EventBean {

	private Integer eventId;
	private Integer eventNumber;
	private Integer ispId;
	private Integer eventRol;
	
	public EventBean(){
		
	}

	
	public EventBean(int eventId, int eventNumber, int ispId){
		this.eventId = eventId;
		this.eventNumber = eventNumber;
		this.ispId = ispId;
	}
	
	
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public int getEventNumber() {
		return eventNumber;
	}

	public void setEventNumber(Integer eventNumber) {
		this.eventNumber = eventNumber;
	}

	public int getIspId() {
		return ispId;
	}

	public void setIspId(Integer ispId) {
		this.ispId = ispId;
	}

	public int getEventRol() {
		return eventRol;
	}

	public void setEventRol(Integer eventRol) {
		this.eventRol = eventRol;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventNumber == null) ? 0 : eventNumber.hashCode());
		result = prime * result + ((ispId == null) ? 0 : ispId.hashCode());
		result = prime * result + ((eventRol == null) ? 0 : eventRol.hashCode());
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

			EventBean other = (EventBean) obj;
			if (eventNumber == null) {
				if (other.eventNumber != null) {
					return false;
				}
			} else if (!eventNumber.equals(other.eventNumber)) {
				return false;
			}

			if (ispId == null) {
				if (other.ispId != null) {
					return false;
				}
			} else if (!ispId.equals(other.ispId)) {
				return false;
			}

			if (eventRol == null) {
				if (other.eventRol != null) {
					return false;
				}
			} else if (!eventRol.equals(other.eventRol)) {
				return false;
			}

			return true;
		}


	@Override
	public String toString() {
		return "Event [id=" + eventId + ", number=" + eventNumber + ", isp=" + ispId + ", rol=" + eventRol + "]";
	}

}
