
public class Blastoise extends Watertype{
	
	public Blastoise()
	{
		name="Blastoise";
		cry="Blast";
		myLegendStatus = (LegendStatus) new NonLegendary();
		legendaryStatus=false;
	}
	
	public void cries()
	{
		System.out.println(name+" says \""+cry+"\"!");
	}
}
