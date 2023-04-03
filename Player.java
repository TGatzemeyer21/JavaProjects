
public class Player {

	private String name;
	private int jersey;
	private int fouls;
	private int fieldGoals_1pt;
	private int fieldGoals_2pt;
	private int fieldGoals_3pt;

	public Player() {
		this.name = "unknown";
		this.jersey = 0;
		this.fouls = 0;
	}
	
	public boolean equals(Object object) {
		if(!(object instanceof Player))
			return false;
		
		Player other = (Player)object;
		
		if (this.jersey == other.getJersey())
			return true;
		else
			return false;
	}
	
	public Player(int jersey) throws Exception {
		this();
		this.setJersey(jersey);
	}
	
	public Player(String name, int jersey) throws Exception {
		this();
		this.setName(name);
		this.jersey = jersey;
	}
	
	public String getName()	{
		return this.name;
	}
	
	public void setName(String name)	{
		this.name = name;
	}
	
	public int getJersey()	{
		return this.jersey;
	}
	
	public void setJersey(int jersey) throws Exception {
		if(jersey >= 0 && jersey <=99)
			this.jersey = jersey;
		else
			throw new Exception("Invalid Jersey Number!");
	}
	
	public int getFouls()	{
		return this.fouls;
	}
	
	public int getFieldGoals_1pt() {
		return this.fieldGoals_1pt;
	}
	
	public int getFieldGoals_2pt() {
		return this.fieldGoals_2pt;
	}
	
	public int getFieldGoals_3pt() {
		return this.fieldGoals_3pt;
	}
	
	public void foul() {
		++this.fouls;
	}
	
	public void shot(int shotType)throws Exception {
		switch (shotType)	{
		case 1:
			this.fieldGoals_1pt++;
			break;
		case 2:
			this.fieldGoals_2pt++;
			break;
		case 3:
			this.fieldGoals_3pt++;
			break;
		default:
			throw new Exception("Invalid Shot! Select 1pt 2pt or 3pt!");
		}
		
	}
	
	public int getPoints() {
		return this.fieldGoals_1pt + (this.fieldGoals_2pt * 2) + (this.fieldGoals_3pt * 3);
	}
	
	public void displayStats() {
		System.out.println("Jersey #: " + this.getJersey());
		System.out.println("Name: " + this.getName());
		System.out.println("Fouls: " + this.getFouls());
		System.out.println("Points: " + this.getPoints());
	}
		
}
