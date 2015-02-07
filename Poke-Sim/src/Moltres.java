
public class Moltres extends Firetype {
	
	public Moltres()
	{
		name="Moltres";
		cry="Mol";
		myLegendStatus = (LegendStatus) new Legendary();
		legendaryStatus=true;
		pic="moltres.png";
	}
	public void cries()
	{
		System.out.println(name+" says \""+cry+"\"!");
	}
}
