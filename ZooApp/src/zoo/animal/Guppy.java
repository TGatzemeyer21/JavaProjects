package zoo.animal;

public class Guppy extends Fish {

	protected final String type = "Guppy";
	
	public Guppy() {
		super();
	}
	
	public <T> Guppy(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	public <T> Guppy(T birthdate, float weight, T water) throws Exception {
		super(birthdate, weight, water);
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
