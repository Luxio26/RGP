public class PhasesCPU
{
	/**
	 * It suppose that cpu.getLife() > Personnage.HALF_LIFE
	 * @param cpu
	 * @param cible
	 */
	public static void moitieSuperieure(Personnage cpu, Personnage cible)
	{
		cpu.attaquerN(cible);
	}
	
	/**
	 * It suppose that cpu.getLife() <= Personnage.HALF_LIFE
	 * @param cpu
	 * @param cible
	 */
	public static void moitieInferieure(Personnage cpu, Personnage cible)
	{
		double choixCpu = Math.floor(Math.random()*4);
		
		if(choixCpu == 0)
			cpu.seSoigner();
		else
			cpu.attaquerN(cible);
		
	}
}