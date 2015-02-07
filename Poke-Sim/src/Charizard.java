
public class Charizard extends Firetype {

	public Charizard()
	{
		cry="roar";
		name="Gabe's Charizard";
		myLegendStatus = (LegendStatus) new NonLegendary();
		legendaryStatus=false;
		pic = "charizard";
	}
	public void cries()
	{
		System.out.println(name+" unleashes a mighty "+cry+"!");
	}

}
