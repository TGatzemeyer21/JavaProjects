package zoo.animal;
public class Fish extends Animal {

	protected final String type = "fish";
	
	protected Water water;
	
	public Fish() {
		super();
		this.water = Water.UNKNOWN;
	}

	public <T> Fish(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
	
	public <T> Fish(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}
}
