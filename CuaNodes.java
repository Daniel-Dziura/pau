public class CuaNodes
{
	class Node
	{
		String informacio;
		Node seguent;
	}
//commit 2
	private Node primer, darrer, recorrer, anterior;

	public CuaNodes()
	{
		primer = null;
		darrer = null;
	}

	private boolean cuaBuida()
	{
		return (primer == null);
	}

	public void entrar(String informacio)
	{
		if (cercar(informacio))
			System.out.format("Ja és a la cua: %s\n", informacio);
		else
		{
			Node nou = new Node();

			nou.informacio = informacio;
			nou.seguent = null;
			if (cuaBuida())
			{
				primer = nou;
				darrer = nou;
			}
			else
			{
				darrer.seguent = nou;
				darrer = nou;
			}
			System.out.format("Entra a la cua: %s\n", nou.informacio);
		}
	}

	public void sortir()
	{
		if (!cuaBuida())
		{
			System.out.format("Surt de la cua: %s\n", primer.informacio);
			if (primer == darrer)
			{
				primer = null;
				darrer = null;
			}
			else
				primer = primer.seguent;
		}
		else
			System.out.println("Cua buida");
	}

	public void sortir(String informacio)
	{
		if (cercar(informacio))
		{
			if (recorrer == primer)
				primer = recorrer.seguent;
			else
				anterior.seguent = recorrer.seguent;
		}
		else
			System.out.format("No és a la cua: %s\n", informacio);
	}

	public void mostrar()
	{
		System.out.println("\n");
		if (!cuaBuida())
		{
			recorrer = primer;
			while (recorrer != null)
			{
				System.out.println(recorrer.informacio);
				recorrer = recorrer.seguent;
			}		
		}
		else
			System.out.println("Cua buida");
		System.out.println();
	}

	private boolean cercar(String informacio)
	{
		recorrer = primer;
		anterior = primer;

		while (recorrer != null)
		{
			if (recorrer.informacio == informacio) return true;
			anterior = recorrer;
			recorrer = recorrer.seguent;
		}
		return false;
	}

	public static void main(String[] args)
	{
		CuaNodes c = new CuaNodes();

		c.mostrar();
		c.entrar("dilluns");
		c.entrar("dilluns");
		c.entrar("dimarts");
		c.entrar("dimecres");
		c.entrar("dijous");
		c.entrar("divendres");
		c.entrar("dissabte");
		c.entrar("diumenge");
		c.entrar("diumenge");
		c.mostrar();
		c.sortir();
		c.sortir();
		c.sortir();
		c.sortir();
		c.sortir();
		c.sortir();
		c.sortir();
		c.sortir();
		c.mostrar();
	}
}