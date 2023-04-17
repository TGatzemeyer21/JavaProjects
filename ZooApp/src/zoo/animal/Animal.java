package zoo.animal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Animal {

	private static int counter = 0;
	
	protected static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy");
	
	protected final int id;
	
	protected final String type;
	
	protected Gender gender;
	
	private LocalDate birthdate;
	
	private float weight;
	
	public Animal() {
		this.id = ++Animal.counter;
		this.type = "Animal";
		this.gender = Gender.UNKNOWN;
		this.birthdate = null;
		this.weight = 0;
	}
	
	public <T> Animal(T birthdate, float weight) throws Exception {
		this();
		this.setBirthdate(birthdate);
		this.setWeight(weight);
	}
	
	public int getId() {
		return this.id;
	}
	
	public Gender getGender() {
		return this.gender;
	}
	
	public LocalDate getBirthDate() {
		return this.birthdate;
	}
	
	public String getBirthdateStr() {
		if(this.birthdate == null) {
			return "unknown";
		} else {
			return Animal.FORMAT.format(this.birthdate);
		}
	}
	
	public String getType() {
		return this.getType();
	}
	
	public float getWeight() {
		return this.weight;
	}
	
	public <T> void setGender(T gender) throws Exception {
		if(gender instanceof String) {
			
			String s = (String) gender;
			
			s = s.toLowerCase();
			
			switch (s) {
			case "m":
			case "male":
				this.gender = Gender.MALE;
				break;
			case "f":
			case "female":
				this.gender = Gender.FEMALE;
				break;
			default:
				this.gender = Gender.UNKNOWN;
			}
		} else if (gender instanceof Gender) {
			Gender g = (Gender) gender;
			this.gender = g;
		} else {
			throw new Exception("Invalid gender: " + gender);
		}
	}
	
	public Animal(LocalDate birthdate, float weight) throws Exception {
		this();
		this.birthdate = birthdate;
		this.setWeight(weight);
	}

	public <T> void setBirthdate(T birthdate) throws Exception {
		if(birthdate instanceof String) {
			String date = (String) birthdate;
			this.birthdate = LocalDate.parse(date, Animal.FORMAT);;
		} else if (birthdate instanceof LocalDate) {
			this.birthdate = (LocalDate) birthdate;
		} else {
			throw new Exception("Invalid date MM-dd-yyyy: " + birthdate);
		}
	}
	
	public void setWeight(float weight) throws Exception{
		if (weight > 0) {
			this.weight = weight;
		} else {
			throw new Exception("Invalid weight. Can't be less than or equal to 0: " + weight);
		}
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.type;
	}
	
	abstract public void eat();
}
