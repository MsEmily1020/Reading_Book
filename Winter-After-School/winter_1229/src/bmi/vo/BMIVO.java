package bmi.vo;

public class BMIVO {
	double height;
	double weight;
	double bmi;
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getBmi() {
		return bmi;
	}
	
	public void setBmi() {
		this.bmi = weight / Math.pow(height / 100, 2);
	}
	
}
