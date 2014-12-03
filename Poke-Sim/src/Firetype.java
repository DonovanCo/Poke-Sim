
public abstract class Firetype extends Pokemon {

	public Firetype()
	{
		type="fire";
	}
	
	public void useMove()
	{
		System.out.println(name+" used Ember!");
	}
	
	public void cries()
	{
		System.out.println("The pokemon does not say a word.");
	}
}
