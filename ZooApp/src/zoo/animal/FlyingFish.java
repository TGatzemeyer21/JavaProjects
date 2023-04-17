package zoo.animal;

public class FlyingFish extends Fish implements Fly{

	protected final String type = "FlyingFish";
	
	public FlyingFish() {
		super();
	}
	
	public <T> FlyingFish(T birthdate, float weight) throws Exception {
		super(birthdate, weight);
	}

	public <T> FlyingFish(T birthdate, float weight, T water) throws Exception {
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

	@Override
	public void soar() {
		System.out.println("This " + this.type + " is soaring...");
	}

	@Override
	public void glide() {
		System.out.println("This " + this.type + " is gliding...");
	}
}
