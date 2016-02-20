
public class Personnage
{
	public static final double DEFAULT_LIFE = 50.0;
	public static final double LIFE_LIMIT = 55.0;
	
	private double life;
	private double attaque;
	private double defense;
	private double coupDeGrace;
	
	public Personnage()
	{
		this.life = DEFAULT_LIFE;
	}

	public double getLife()
	{
		return this.life;
	}
	
	public double getAttaque()
	{
		return this.attaque;
	}

	public double getDefense()
	{
		return this.defense;
	}

	public double getCoupDeGrace()
	{
		return this.coupDeGrace;
	}

	public void attaquerN(Personnage cible)
	{
		if(cible.life == 0)
			return;
		
		this.attaque = Math.floor(Math.random()*10 + 1);
		cible.defense = Math.floor(Math.random()*9 + 2);
		
		cible.life -= Math.abs(this.attaque - cible.defense);
		if(cible.life <= 0)
			cible.life = 0;
	}
	
	public void attaquerCG(Personnage cible)
	{
		if(cible.life == 0)
			return;
		
		this.coupDeGrace = Math.floor(Math.random()*11 + 9);
		cible.defense = Math.floor(Math.random()*9 + 2);
		
		cible.life -= Math.abs(this.coupDeGrace - cible.defense);
		if(cible.life < 0)
			cible.life = 0;
	}
	
	public void seSoigner()
	{
		if(this.life == 0)
			return;
		
		this.life += Math.floor(Math.random()*10 + 10);
		
		if(this.life > LIFE_LIMIT)
			this.life = LIFE_LIMIT;
	}
}
