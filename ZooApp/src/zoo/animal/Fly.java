package zoo.animal;

public interface Fly {

	default void soar() {
		System.out.println("This animal soars");
	}
	void glide();
	
}
