
public abstract class Pokemon {
	
	protected String name;
	protected String type;
	protected String cry;
	protected LegendStatus myLegendStatus;
	protected boolean legendaryStatus;
	
	
	public boolean isLegendaryStatus() {
		return legendaryStatus;
	}

	public void setLegendaryStatus(boolean legendaryStatus) {
		this.legendaryStatus = legendaryStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCry() {
		return cry;
	}

	public void setCry(String cry) {
		this.cry = cry;
	}

	public LegendStatus getMyLegendStatus() {
		return myLegendStatus;
	}

	public void setMyLegendStatus(LegendStatus myLegendStatus) {
		this.myLegendStatus = myLegendStatus;
	}

	public abstract void cries();
	public abstract void useMove();
	
	public void faint()
	{
		System.out.println(name+" fainted!");
	}
	
	public void giveInfo()
	{
		System.out.println("You chose "+name+", the "+type+" type!");
	}
	
	public void giveOppInfo()
	{
		System.out.println("Your opponent is "+name+", the "+type+" type!");
	}
}
