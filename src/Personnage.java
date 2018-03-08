public class Personnage
{
	public static final double DEFAULT_MANA = 5.0;
	public static final double DEFAULT_LIFE = 50.0;
	public static final double HALF_LIFE = Math.floor(DEFAULT_LIFE/2);
	public static final double LIFE_LIMIT = 55.0;
	
	private static final int MAX_ATQ_CG = 11;
	private static final int MIN_ATQ_CG = 9;
	private static final int MAX_ATQ_N = 10;
	private static final int MIN_ATQ_N = 1;
	
	private double life;
	private double attaque;
	private double defense;
	private double coupDeGrace;
	private double mana;

	public Personnage() {
		this.life = DEFAULT_LIFE;
		this.mana = DEFAULT_MANA;
	}
	
	public Personnage(double mana) {
		this.life = DEFAULT_LIFE;
		this.mana = mana;
	}
	
	public Personnage(double mana, double life) {
		this.life = life;
		this.mana = mana;
	}

	public double getLife() {
		return this.life;
	}
	
	public double getAttaque() {
		return this.attaque;
	}

	public double getDefense() {
		return this.defense;
	}

	public double getCoupDeGrace() {
		return this.coupDeGrace;
	}
	
	public double getMana() {
		return this.mana;
	}
	
	public boolean isDead() {
		return this.life == 0;
	}
	
	public boolean outOfMana() {
		return this.mana == 0;
	}
	
	public void mjPower() {
		System.out.println("\nMJ's power !!\n");
		this.life = 0;
	}
	
	public void attaquer(Personnage cible, boolean coupDeGrace) {
		if(cible.isDead()) return;
		
		int max, min;
		double attaque;
		
		if(coupDeGrace) {
			max = MAX_ATQ_CG;
			min = MIN_ATQ_CG;
		}
		else {
			max = MAX_ATQ_N;
			min = MIN_ATQ_N;
		}
		
		attaque = Math.floor(Math.random()*max + min);
		System.out.println("Attaque : "+attaque);
		cible.defense = Math.floor(Math.random()*9 + 2);
		System.out.println("Defense cible : "+cible.defense+"\n");
		
		double perte = attaque - cible.defense;
		if(perte < 0) perte = 0;
		cible.life -= perte;
		
		if(cible.life < 0) cible.life = 0;
	}
	
	public void seSoigner() {
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
	
	public void avoirUnLoot() {
		this.mana += Loot.randomLoot();
		
		if(this.mana > DEFAULT_MANA)
			this.mana = DEFAULT_MANA;
	}
}