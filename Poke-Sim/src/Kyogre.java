
public class Kyogre extends Watertype {

	public Kyogre()
	{
		name="Kyogre";
		cry="Ky";
		myLegendStatus = (LegendStatus) new Legendary();
		legendaryStatus=true;
	}
	
	public void cries()
	{
		System.out.println(name+" says \""+cry+"\"!");
	}
}
