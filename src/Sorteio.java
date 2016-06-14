import java.util.Random;

public class Sorteio {
	
	//private double numerosorteado=Math.random()*100+1;
	
	//Outro forma de gerar números randomicos.
	private Random rn = new Random();
	private int numero;

	public int getNumerosorteado() {
		return numero;
	}

	public void sortear() {
		numero=rn.nextInt(100)+1;
	}
	
	public boolean comparar(int n){
		if (n==numero)
			return true;
		else
			return false;
	}
	
	public String posicao(int n){
		if(n<numero)
			return "TENTE UM NÚMERO MAIOR QUE ";
		else
			return "TENTE UM NÚMERO MENOR QUE ";
	}
	
	public String dica(int n){
		if (n<numero+5 && n>numero-5)
			return "ESTA QUENTE!";
		else
			return "ESTA FRIO!";
					
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sorteio s = new Sorteio();
		
		System.out.println(s.numero);
		System.out.println(s.getNumerosorteado());
		
		System.out.println(s.dica(36));

	}

}
