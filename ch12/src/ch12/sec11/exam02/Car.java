package ch12.sec11.exam02;

public class Car {
	private String model;
	private String owner;
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(String model, String onwer) {
		this.setModel(model);
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
}
