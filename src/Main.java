public class Main
{
	public static void main(String[] args)
	{
		Personnage a = new Personnage();
		Personnage b = new Personnage();
		
		a.attaquerN(b);
		System.out.println(b.getLife());
	}
}