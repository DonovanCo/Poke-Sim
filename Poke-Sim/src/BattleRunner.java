import java.util.Scanner;
import java.util.ArrayList;

public class BattleRunner {
	
	static Scanner choice = new Scanner(System.in);
	static int cheat;
	static ArrayList <Pokemon> pokedex = new ArrayList<Pokemon>();
	static Pokemon[] contestants = new Pokemon[2];
	
	public static void makeList()
	{
		
		pokedex.add(new Blaziken());
	    pokedex.add(new Charizard());
		pokedex.add(new Moltres());
		pokedex.add(new Blastoise());
		pokedex.add(new Magikarp());
		pokedex.add(new Kyogre());
		pokedex.add(new Torterra());
		pokedex.add(new Virizion());
	}
	
	public static void runOne(int a)
	{
		
		System.out.println("Welcome to Poke-Sim! \nA Pokemon battle simulator based on a pokemon's typing and legendary status.\nBegin by choosing a Pokemon.");
		for (int i = 0; i < pokedex.size(); i++)
		{
			System.out.println((i+1)+".)"+pokedex.get(i).getName());
		}
		int poke1=(choice.nextInt()-1);
		pokedex.get(poke1).giveInfo();
		pokedex.get(poke1).myLegendStatus.checkLegendary();
		pokedex.get(poke1).cries();
		
		
		System.out.println("Which pokemon will be your opponent?");
		for (int i = 0; i < pokedex.size(); i++)
		{
			System.out.println((i+1)+".)"+pokedex.get(i).getName());
		}
		int poke2 = (choice.nextInt()-1);
		pokedex.get(poke2).giveOppInfo();
		pokedex.get(poke2).myLegendStatus.checkLegendary();
		pokedex.get(poke2).cries();
		
		contestants[0]=pokedex.get(poke1);
		contestants[1]=pokedex.get(poke2);
		
		
		contestants[0].useMove();
		contestants[1].useMove();
		
		if(a==1)
		{
			System.out.println("You win by default.");
			contestants[1].faint();
		}
		else if(contestants[0].isLegendaryStatus()==true&&contestants[1].isLegendaryStatus()==true) 
		{
			contestants[1].faint();
			System.out.println("It was a tough battle but you came out on top.");
		}
		
		else if(contestants[0].getName().equals("Magikarp"))
		{
			contestants[0].faint();
		}
		
		else if(contestants[1].getName().equals("Magikarp"))
		{
			contestants[1].faint();
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
		
		else if(contestants[0].getType().equals("fire")&&contestants[1].getType().equals("grass"))
		{
			contestants[1].faint();
		}
		
		else if(contestants[0].getType().equals("grass")&&contestants[1].getType().equals("fire"))
		{
			System.out.println(contestants[0].getName()+" barely scratches it!");
			contestants[0].faint();
		}
		
		else if(contestants[0].getType().equals("grass")&&contestants[1].getType().equals("water"))
		{
			contestants[1].faint();
		}
		
		else if(contestants[0].getType().equals("water")&&contestants[1].getType().equals("grass"))
		{
			contestants[0].faint();
		}
		
		else if(contestants[0].getType().equals(contestants[1].getType()))
		{
			System.out.println("Both pokemon faint because they are equally matched!");
		}
		
	}
	
	public static void makeCustom()
	{
		System.out.println("What will your pokemon,s name be?");
		String nameCus = choice.next();
		System.out.println("What will "+nameCus+",s cry be?");
		String cryCus = choice.next();
		System.out.println("Finally, what type is your pokemon? 1.)Fire 2.)Grass 3.)Water");
		int typeCus = choice.nextInt();
		
	}
	
	public static int getCodes()
	{
		System.out.println("Would you like to enter cheat codes?(y/n)");
		String answer = choice.next();
		if(answer.equals("y"))
		{
			System.out.println("Enter your code now.");
			String code = choice.next();
			if(code.equals("^^VV<><>ba"))
			{
				System.out.println("Cheat Activated: AutoWin");
				return 1;
			}
		}
		return 0;
	}
	
	public static void askPref()
	{
		System.out.println("Would you like 1.)normal or 2.)Graphics output?");
		int version = choice.nextInt();
		if(version==1)
		{
			cheat  = getCodes();
			runOne(cheat);
		}
		else if(version==2)
		{
			PicClass.jGetCodes();
		}
		else
		{
			System.out.println("That is not an option.");
		}
	}
	
	public static void main(String[] args) {
		
		makeList();
		askPref();
		
		

	}

}
