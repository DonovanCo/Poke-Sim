
public class Grasstype extends Pokemon{

	public Grasstype()
	{
		type="grass";
	}
	
	public void useMove()
	{
		System.out.println(name+" used Leaf Storm!");
	}
	
	public void cries()
	{
		System.out.println(name+" says \""+cry+"\"!");
	}
}
