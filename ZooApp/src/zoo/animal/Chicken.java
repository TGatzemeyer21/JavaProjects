package zoo.animal;

public class Chicken extends Bird {

	protected final String type = "Chicken";
	
	public Chicken() {
		super();
	}

	public <T> Chicken(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	public <T> Chicken(T birthdate, float weight, float wingspan) throws Exception {
		super(birthdate, weight, wingspan);
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.type;
	}
	
	@Override
	public void eat() {
		System.out.println("This " + this.type + " is eating...");
	}
}