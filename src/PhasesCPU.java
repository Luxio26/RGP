public class PhasesCPU
{
	public static void jouer(Personnage cpu, Personnage joueur) {
		if(cpu.getLife() > Personnage.HALF_LIFE) {
			cpu.attaquer(cpu, false);
		}
		else {
			double choixCpu = Math.floor(Math.random()*4); // [0, 1, 2, 3] 
			
			if(choixCpu == 0 && !cpu.outOfMana())
				cpu.seSoigner();
			else
				cpu.attaquer(cpu, false);
		}
	}
}