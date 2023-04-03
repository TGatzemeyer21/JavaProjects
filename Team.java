import java.util.ArrayList;
import java.util.List;

public class Team {

	private String name;
	private List<Player> players;
	
	public Team() {
		this.name = "unknown";
		this.players = new ArrayList<Player>();
	}
	
	public Team(String name)	{
		this();
		this.setName(name);
	}
	
	public String getName()	{
		return this.name;
	}
	
	public void addPlayer(String name, int jersey) throws Exception {
		Player dupPlayer = this.getPlayer(jersey);
		if (dupPlayer == null)	{
			this.players.add(new Player(name, jersey));
		} else {
			String dupPlayerName = dupPlayer.getName();
			throw new Exception("Jersey #" + jersey + " is already assigned to " + dupPlayerName + "!");
		}
		this.players.add(new Player(name, jersey));
	}
	
	public Player getPlayer(int jersey) throws Exception {
		int index = this.players.indexOf(new Player(jersey));
		
		if (index == -1) {
			return null;
		}else {
			return this.players.get(index);
		}
	}
	public void setName(String name)	{
		this.name = name;
	}
	
	public int getTeamPoints()	{
		int teamPoints = 0;
		for(int i = 0; i < players.size(); i++) {
			teamPoints += this.players.get(i).getPoints();
		}
		return teamPoints;
	}
	
	public int getTeamFouls()	{
		int teamFouls = 0;
		for(int i = 0; i < players.size(); i++) {
			teamFouls += this.players.get(i).getFouls();
		}
		return teamFouls;
	}
	
	public void displayTeamStats() {
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		int teamPoints = this.getTeamPoints();
		int teamFouls = this.getTeamFouls();
		System.out.println("Points for " + this.name + " " + teamPoints);
		System.out.println("Fouls for " + this.name + " " + teamFouls);
	}
	public void displayDetailStats() {
		for (int i = 0; i < this.players.size(); i++) {
			int jersey = players.get(i).getJersey();
			String name = players.get(i).getName();
			int fouls = players.get(i).getFouls();
			int fieldGoals_1pt = players.get(i).getFieldGoals_1pt();
			int fieldGoals_2pt = players.get(i).getFieldGoals_2pt();
			int fieldGoals_3pt = players.get(i).getFieldGoals_3pt();
			int pointtt1 = players.get(i).getPoints();
			
			System.out.println("Number  Name         Fouls  1pts  2pts  3pts  Total Points   ");
			System.out.printf("%-7d %-14s %-5d %-5d %-5d %-9d %-10d\n", jersey, name, fouls, fieldGoals_1pt, fieldGoals_2pt, fieldGoals_3pt, pointtt1);
		}
	}
}
