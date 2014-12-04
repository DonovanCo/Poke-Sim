
public class Magikarp extends Watertype{

	public Magikarp()
	{
		name="Magikarp";
		cry="*flops*";
		myLegendStatus = (LegendStatus) new NonLegendary();
		legendaryStatus=false;
	}
	
	public void useMove()
	{
		System.out.println("Maagikarp used Splash!\nIt simultaneously created and destroyed the universe!\nBut nothing happend to the other pokemon.");
	}
	
	public void cries()
	{
		System.out.println(cry);
	}
	
	public void giveInfo()
	{
		System.out.println("Really. You chose "+name+"...");
	}
	
	public void giveOppInfo()
	{
		System.out.println("You couldn't have chosen an easier opponent.");
	}
}
