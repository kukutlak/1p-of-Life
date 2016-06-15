package oneper.domobj;

import java.util.GregorianCalendar;

public class Problem{
	
	public Problem(){}
	public Problem(String iD, String type, float cost, GregorianCalendar expiryDate) {
		super();
		this.iD = iD;
		this.type = type;
		this.cost = cost;
		this.expiryDate = expiryDate;
	}
	
	
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public GregorianCalendar getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(GregorianCalendar expiryDate) {
		this.expiryDate = expiryDate;
	}

	String iD ;
	String type;
	float cost;
	GregorianCalendar expiryDate; // = new GregorianCalendar();
	
	
}

