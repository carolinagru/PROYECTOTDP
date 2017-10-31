package Visitor;

public class ElementoFuego implements Elemento{

	@Override
	public boolean dejoPasar(Visitor v) {
		// TODO Auto-generated method stub
		return v.puedoPasar(this);
	}

	public boolean dejoAtacar(Visitor v) {
		return false;
	}

	
}
