import java.util.Scanner;

public class PhasesJoueur
{
	private static void choixSup(Personnage joueur, Personnage cible, Scanner choixJoueur)
	{
		int choix;
		
		if(!joueur.outOfMana())
		{
			System.out.println("Que voulez-vous faire ?");
			System.out.println("1.Attaquer");
			System.out.println("2.Soins ("+joueur.getMana()+" restants)");
			choix = choixJoueur.nextInt();
			
			switch(choix)
			{
				case 1:
					joueur.attaquerN(cible);
					break;
				case 2:
					joueur.seSoigner();
					break;
			}
		}
		else
		{
			System.out.println("Que voulez-vous faire ?");
			System.out.println("1.Attaquer");
			choix = choixJoueur.nextInt();
			
			switch(choix)
			{
				case 1:
					joueur.attaquerN(cible);
					break;
			}
		}		
	}
	
	private static void choixInf(Personnage joueur, Personnage cible, Scanner choixJoueur)
	{
		int choix;
		
		if(!joueur.outOfMana())
		{
			System.out.println("Que voulez-vous faire ?");
			System.out.println("1.Attaquer");
			System.out.println("2.Soins ("+joueur.getMana()+" restants)");
			System.out.println("3.Coup de grâce");
			choix = choixJoueur.nextInt();
			
			switch(choix)
			{
				case 1:
					joueur.attaquerN(cible);
					break;
				case 2:
					joueur.seSoigner();
					break;
				case 3:
					joueur.attaquerCG(cible);
					break;
			}
		}
		else
		{
			System.out.println("Que voulez-vous faire ?");
			System.out.println("1.Attaquer");
			System.out.println("2.Coup de grâce");
			choix = choixJoueur.nextInt();
			
			switch(choix)
			{
				case 1:
					joueur.attaquerN(cible);
					break;
				case 2:
					joueur.attaquerCG(cible);
			}
		}
	}
	
	/**
	 * it suppose that a.getLife() > Personnage.HALF_LIFE
	 * @param a
	 * @param b
	 * @param scannerJoueur
	 */
	public static void moitieSupérieure(Personnage a, Personnage b, Scanner scannerJoueur)
	{
		PhasesJoueur.choixSup(a, b, scannerJoueur);
	}
	
	/**
	 * it suppose that a.getLife() <= Personnage.HALF_LIFE
	 * @param a
	 * @param b
	 * @param scannerJoueur
	 */
	public static void moitieInferieure(Personnage a, Personnage b, Scanner scannerJoueur)
	{
		PhasesJoueur.choixInf(a, b, scannerJoueur);
	}
}