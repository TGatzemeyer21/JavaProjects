package zoo.animal;

public class Sparrow extends Bird {

	protected final String type = "Sparrow";
	
	public Sparrow() {
		super();
	}

	public <T> Sparrow(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	public <T> Sparrow(T birthdate, float weight, float wingspan) throws Exception {
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