
public abstract class Watertype extends Pokemon{

	public Watertype()
	{
		type="water";
	}
	
	public void useMove()
	{
		System.out.println(name+" used Hydro Pump!");
	}
	
	public void cries()
	{
		System.out.println(name+" says \""+cry+"\"!");
	}
}
