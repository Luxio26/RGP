import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner saisieUtilisateur = new Scanner(System.in);
		Personnage joueur = new Personnage();
		Personnage cpu = new Personnage();
		
		do
		{
			System.out.println("Vous : "+joueur.getLife()+"\tCpu : "+cpu.getLife()+"\n");
			// Player turn
			if(joueur.getLife() > Personnage.HALF_LIFE)
				PhasesJoueur.moitieSupérieure(joueur, cpu, saisieUtilisateur);
			else
				PhasesJoueur.moitieInferieure(joueur, cpu, saisieUtilisateur);
			
			// Cpu turn
			if(cpu.getLife() > Personnage.HALF_LIFE)
				PhasesCPU.moitieSuperieure(cpu, joueur);
			else
				PhasesCPU.moitieInferieure(cpu, joueur);
		}while(!joueur.isDead() && !cpu.isDead());
		saisieUtilisateur.close();
		
		System.out.println("joueur est mort : "+joueur.isDead());
		System.out.println("cpu est mort : "+cpu.isDead());
	}
}