import java.util.Scanner;

public class Main
{
	// TODO: Mode extr�me --> Si le personnage rejoue, sa vie n'est pas reset : il garde la m�me quoi... faut pas �tre con dans la vie PUTAIN !!
	// TODO: Ajouter une fonctionnalit� limitant le nombre de coup de gr�ce utilisable
	
	public static void main(String[] args)
	{
		boolean rejouer = false;
		Scanner saisieUtilisateur = new Scanner(System.in);
		Personnage joueur = new Personnage(Personnage.DEFAULT_MANA);
		Personnage cpu = new Personnage(Personnage.DEFAULT_MANA);
		do {
			do {
				System.out.println("Vous : "+joueur.getLife()+"\tCpu : "+cpu.getLife()+"\n");
				
				// Player turn
				PhasesJoueur.jouer(joueur, cpu, saisieUtilisateur);
				// Cpu turn
				PhasesCPU.jouer(cpu, joueur);
			}while(!joueur.isDead() && !cpu.isDead());

			System.out.println("joueur est mort : "+joueur.isDead());
			System.out.println("cpu est mort : "+cpu.isDead());
			
			// Replay ?
			System.out.println("\nVoulez-vous rejouer ?");
			System.out.println("1.Oui\t2.Non");
			int replayChoice = saisieUtilisateur.nextInt();
			
			switch(replayChoice)
			{
				case 1:
					rejouer = true;
					joueur.avoirUnLoot();
					
					joueur = new Personnage(joueur.getMana());
					cpu = new Personnage(joueur.getMana());
					break;
				default:
					rejouer = false;
					break;
			}
		} while(rejouer);
		saisieUtilisateur.close();
	}
}