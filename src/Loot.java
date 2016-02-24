public class Loot
{
	public static double randomLoot()
	{
		double lootMana = Math.floor(Math.random()*3 + 1);
		
		System.out.println("Vous venez de gagner "+lootMana+" pts de mana sur un total de "+Personnage.DEFAULT_MANA);
		return lootMana;
	}
}