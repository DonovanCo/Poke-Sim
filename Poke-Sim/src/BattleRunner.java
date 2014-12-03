import java.util.Scanner;
public class BattleRunner {
	
	static Scanner choice = new Scanner(System.in);
	
	
	public static void run()
	{
		Pokemon [] pokedex = new Pokemon[4];
		pokedex[0]= new Blaziken();
		pokedex[1]= new Moltres();
		pokedex[2]= new Blastoise();
		pokedex[3]= new Kyogre();
		
		System.out.println("Welcome to Poke-Sim! \nA Pokemon battle simulator based on a pokemon's typing and legendary status.\nBegin by choosing a Pokemon.");
		for (int i = 0; i < pokedex.length; i++)
		{
			System.out.println((i+1)+".)"+pokedex[i].getName());
		}
		int poke1=(choice.nextInt()-1);
		pokedex[poke1].giveInfo();
		pokedex[poke1].myLegendStatus.checkLegendary();
		pokedex[poke1].cries();
		
		
		System.out.println("Which pokemon will be your opponent?");
		for (int i = 0; i < pokedex.length; i++)
		{
			System.out.println((i+1)+".)"+pokedex[i].getName());
		}
		int poke2 = (choice.nextInt()-1);
		pokedex[poke2].giveOppInfo();
		pokedex[poke2].myLegendStatus.checkLegendary();
		pokedex[poke2].cries();
		
		Pokemon[] contestants = new Pokemon[2];
		contestants[0]=pokedex[poke1];
		contestants[1]=pokedex[poke2];
		
		
		contestants[0].useMove();
		contestants[1].useMove();
		
		//error on this line.
		if(contestants[0].isLegendaryStatus()==true&&contestants[1].isLegendaryStatus()==true)
		{
			contestants[1].faint();
			System.out.println("It was a tough battle but you came out on top.");
		}
		
		else if(contestants[0].isLegendaryStatus()==false&&contestants[1].isLegendaryStatus()==true)
		{
			System.out.println("Your oppent blew you out of the water!");
		}
		
		else if(contestants[0].isLegendaryStatus()==true&&contestants[1].isLegendaryStatus()==false)
		{
			System.out.println("You overpowered your opponent! Hurray!!");
		}
		
		else if(contestants[0].getType().equals("fire")&&contestants[1].getType().equals("water"))
		{
			contestants[0].faint();
		}
		
		else if(contestants[0].getType().equals("water")&&contestants[1].getType().equals("fire"))
		{
			contestants[1].faint();
		}
		
		else if(contestants[0].getType().equals(contestants[1].getType()))
		{
			System.out.println("Both pokemon faint because they are equally matched!");
		}
		
	}


	public static void main(String[] args) {
		
		run();

	}

}
