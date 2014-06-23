package dto;

public class Guest implements java.io.Serializable{
	private String guestE = "";
	private String guestText = "";
	private String guestPA;
	private String guestDate;
	public Guest() {
		super();
	}
	public Guest(String guestE, String guestText, String guestPA, String guestDate) {
		super();
		if(guestE != null)	this.guestE = guestE;
		setguestText(guestText);
		this.guestPA = guestPA;
		this.guestDate = guestDate;
	}
	public String getguestE() {
		return guestE;
	}
	//db에서 설정된 부분이므로 수정을 미연에 방지
//	public void setguestE(String guestE) {
//		this.guestE = guestE;
//	}
	public String getguestText() {
		return guestText;
	}
	public String getguestDate(){
		return guestDate;
	}
	
	
	public void setguestText(String guestText) {
		if(guestText != null)	this.guestText = guestText;
	}
	public String getguestPA() {
		return guestPA;
	}
	public void setguestPA(String guestPA) {
		this.guestPA = guestPA;
	}
	@Override
	public String toString() {
		return new StringBuilder(guestE).append(" : ")
					.append(guestText).append(" : ")
					.append(guestPA).toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guestE == null) ? 0 : guestE.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guest other = (Guest) obj;
		if (guestE == null) {
			if (other.guestE != null)
				return false;
		} else if (!guestE.equals(other.guestE))
			return false;
		return true;
	}
	
}
