public class Personnage
{
	public static final double DEFAULT_MANA = 5.0;
	public static final double DEFAULT_LIFE = 50.0;
	public static final double HALF_LIFE = 25.0;
	public static final double LIFE_LIMIT = 55.0;
	
	private double life;
	private double attaque;
	private double defense;
	private double coupDeGrace;
	private double mana;
	
	public Personnage(double mana)
	{
		this.life = DEFAULT_LIFE;
		this.mana = mana;
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
	
	public double getMana()
	{
		return this.mana;
	}
	
	public boolean isDead()
	{
		return this.life == 0;
	}
	
	public boolean outOfMana()
	{
		return this.mana == 0;
	}
	
	public void mjPower()
	{
		System.out.println("\nMJ's power !!\n");
		this.life = 0;
	}

	public void attaquerN(Personnage cible)
	{
		if(cible.isDead())
			return;
		
		this.attaque = Math.floor(Math.random()*10 + 1);
		System.out.println("Attaque : "+this.attaque);
		cible.defense = Math.floor(Math.random()*9 + 2);
		System.out.println("Défense cible : "+cible.defense+"\n");
		
		double perte = this.attaque - cible.defense;
		if(perte < 0)
			perte = 0;
		cible.life -= perte;
		
		if(cible.life <= 0)
			cible.life = 0;
	}
	
	public void attaquerCG(Personnage cible)
	{
		if(cible.isDead())
			return;
		
		this.coupDeGrace = Math.floor(Math.random()*11 + 9);
		System.out.println("Attaque : "+this.coupDeGrace);
		cible.defense = Math.floor(Math.random()*9 + 2);
		System.out.println("Défense cible : "+cible.defense+"\n");
		
		double perte = this.coupDeGrace - cible.defense;
		if(perte < 0)
			perte = 0;
		cible.life -= perte;
		
		if(cible.life < 0)
			cible.life = 0;
	}
	
	public void seSoigner()
	{
		if(this.isDead() || this.outOfMana())
			return;
		
		this.mana -= 1;
		
		double soins;
		soins = Math.floor(Math.random()*10 + 10);
		System.out.println("Soins : "+soins+"\n");
		
		this.life += soins;
		
		if(this.life > LIFE_LIMIT)
			this.life = LIFE_LIMIT;
	}
	
	public void avoirUnLoot()
	{
		this.mana += Loot.randomLoot();
		
		if(this.mana > DEFAULT_MANA)
			this.mana = DEFAULT_MANA;
	}
}