import java.util.Scanner;
import java.util.ArrayList;

public class BattleRunner {
	
	static Scanner choice = new Scanner(System.in);
	static int cheat;
	static ArrayList <Pokemon> pokedex = new ArrayList<Pokemon>();
	static Pokemon[] contestants = new Pokemon[2];
	static String outcome;
	
	static Pokemon FCus = new Blaziken();
	static Pokemon FCusLeg = new Moltres();
	static Pokemon GCus = new Torterra();
	static Pokemon GCusLeg = new Virizion();
	static Pokemon WCus = new Blastoise();
	static Pokemon WCusLeg = new Kyogre();
	
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
			outcome = contestants[1].faint();
		}
		else if(contestants[0].isLegendaryStatus()==true&&contestants[1].isLegendaryStatus()==true) 
		{
			outcome = contestants[1].faint();
			System.out.println("It was a tough battle but you came out on top.");
		}
		
		else if(contestants[0].getName().equals("Magikarp"))
		{
			outcome = contestants[0].faint();
		}
		
		else if(contestants[1].getName().equals("Magikarp"))
		{
			outcome = contestants[1].faint();
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
			outcome = contestants[0].faint();
		}
		
		else if(contestants[0].getType().equals("water")&&contestants[1].getType().equals("fire"))
		{
			outcome = contestants[1].faint();
		}
		
		else if(contestants[0].getType().equals("fire")&&contestants[1].getType().equals("grass"))
		{
			outcome = contestants[1].faint();
		}
		
		else if(contestants[0].getType().equals("grass")&&contestants[1].getType().equals("fire"))
		{
			System.out.println(contestants[0].getName()+" barely scratches it!");
			outcome  = contestants[0].faint();
		}
		
		else if(contestants[0].getType().equals("grass")&&contestants[1].getType().equals("water"))
		{
			outcome = contestants[1].faint();
		}
		
		else if(contestants[0].getType().equals("water")&&contestants[1].getType().equals("grass"))
		{
			outcome = contestants[0].faint();
		}
		
		else if(contestants[0].getType().equals(contestants[1].getType()))
		{
			System.out.println("Both pokemon faint because they are equally matched!");
		}
		System.out.println(outcome);
		
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
			System.out.println("Do you wish to create a custom pokemon? (Y/N)");
			String chooseCus = choice.next();
			if(chooseCus.equals("Y"))
				{
				makeCus();
				}
			cheat  = getCodes();
			runOne(cheat);
		}
		else if(version==2)
		{
			PicClass.jAskCus();
		}
		else
		{
			System.out.println("That is not an option.");
		}
	}
	
	public static void makeCus()
	{
		System.out.println("Will it be a legendary pokemon? (Y/N)");
		String isLegCus = choice.next();
		if(isLegCus.equals("Y"))
			{
			System.out.println("What type will it be?\n1.)Fire\n2.)Water\n3.)Grass");
			String typeCus = choice.next();
			if(typeCus.equals("Fire"))
				{
				FCusLeg.setType(typeCus.toLowerCase());
				System.out.println("What will your pokemon's name be?");
				String nameCus = choice.next();
				FCusLeg.setName(nameCus);
				System.out.println("What will "+nameCus+"'s cry be?");
				String cryCus = choice.next();
				FCusLeg.setCry(cryCus);
				FCusLeg.setPic("unown.png");
				pokedex.add(FCusLeg);
				
				}
			else if(typeCus.equals("Water"))
				{
				WCusLeg.setType(typeCus.toLowerCase());
				System.out.println("What will your pokemon's name be?");
				String nameCus = choice.next();
				WCusLeg.setName(nameCus);
				System.out.println("What will "+nameCus+"'s cry be?");
				String cryCus = choice.next();
				WCusLeg.setCry(cryCus);
				WCusLeg.setPic("unown.png");
				pokedex.add(WCusLeg);
				
				}
			else if(typeCus.equals("Grass"))
				{
				GCusLeg.setType(typeCus.toLowerCase());
				System.out.println("What will your pokemon's name be?");
				String nameCus = choice.next();
				GCusLeg.setName(nameCus);
				System.out.println("What will "+nameCus+"'s cry be?");
				String cryCus = choice.next();
				GCusLeg.setCry(cryCus);
				GCusLeg.setPic("unown.png");
				pokedex.add(GCusLeg);
				
				}
			else
				{
				System.out.println("That is not an option.");
				}
			}
		else if(isLegCus.equals("N"))
			{
			System.out.println("What type will it be?\n1.)Fire\n2.)Water\n3.)Grass");
			String typeCus = choice.next();
			if(typeCus.equals("Fire"))
				{
				FCus.setType(typeCus.toLowerCase());
				System.out.println("What will your pokemon's name be?");
				String nameCus = choice.next();
				FCus.setName(nameCus);
				System.out.println("What will "+nameCus+"'s cry be?");
				String cryCus = choice.next();
				FCus.setCry(cryCus);
				FCus.setPic("unown.png");
				pokedex.add(FCus);
				
				}
			else if(typeCus.equals("Water"))
				{
				WCus.setType(typeCus.toLowerCase());
				System.out.println("What will your pokemon's name be?");
				String nameCus = choice.next();
				WCus.setName(nameCus);
				System.out.println("What will "+nameCus+"'s cry be?");
				String cryCus = choice.next();
				WCus.setCry(cryCus);
				WCus.setPic("unown.png");
				pokedex.add(WCus);
				
				}
			else if(typeCus.equals("Grass"))
				{
				GCus.setType(typeCus.toLowerCase());
				System.out.println("What will your pokemon's name be?");
				String nameCus = choice.next();
				GCus.setName(nameCus);
				System.out.println("What will "+nameCus+"'s cry be?");
				String cryCus = choice.next();
				GCus.setCry(cryCus);
				GCus.setPic("unown.png");
				pokedex.add(GCus);
				
				}
			else
				{
				System.out.println("That is not an option.");
				}
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
