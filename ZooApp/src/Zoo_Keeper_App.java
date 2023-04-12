
public class Zoo_Keeper_App {

	public Zoo_Keeper_App() {
		
		try {
			Animal a1 = new Animal();
			Animal a2 = new Animal("12-31-2023", (float)10.5);
			Animal a3 = new Animal();
			
			System.out.println(a1);
			System.out.println(a2);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
