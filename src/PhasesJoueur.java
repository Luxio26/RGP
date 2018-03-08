import java.util.Scanner;

public class PhasesJoueur
{
	private static void choix(Personnage joueur, Personnage cible, Scanner choixJoueur) {
		int choix;
		boolean loop;
		
		do {
			loop = false;
			
			System.out.println("Que voulez-vous faire ?");
			System.out.println("1.Attaquer");
			if(! joueur.outOfMana()) System.out.println("2.Soins ("+joueur.getMana()+" restants)");
			if(joueur.getLife() <= Personnage.HALF_LIFE) System.out.println("3.Coup de grace");
			choix = choixJoueur.nextInt();
			
			switch(choix)
			{
				case 1:
					joueur.attaquer(cible, false);
					break;
				case 2:
					if(joueur.outOfMana()) loop = true;
					else joueur.seSoigner();
					break;
				case 3:
					if(joueur.getLife() > Personnage.HALF_LIFE) loop = true;
					else joueur.attaquer(cible, true);
					break;
				case 666:
					cible.mjPower();
					break;
				default:
					loop = true;
					break;
			}
		} while(loop);
	}
	
	public static void jouer(Personnage a, Personnage b, Scanner scanner) {
		choix(a, b, scanner);
	}
}