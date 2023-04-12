import java.text.
public class Animal {

	
	
	public Animal() {
		
		this.id = ++Animal.counter;
		this.type = "Animal";
		this.birthDate = null;
		this.weight = 0;
	}
	
	public Animal(String birthdate, float weight) throws Exception {
		this();
		this.setBirthDate(birthdate);
		this.setWeight(weight);
	}
	
	public Animal(Date birthdate, float weight) throws Exception {
		this();
		this.birthdate = birthdate;
		this.setWeight(weight);
	}

	public void setBirthdate(String birthdate) throws ParseException {
		this.setBirthdate = this.formatter.parse(birthdate);
	}
	
	public void setWeight(float weight) {
		if (weight <= 0) {
			throw new Exception("Invalid weight. Can't be less than or equal to 0: " + weight);
		} else {
			this.weight = weight;
		}
	}
}
