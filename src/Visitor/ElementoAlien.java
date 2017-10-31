package Visitor;

public class ElementoAlien implements Elemento{

	public boolean dejoPasar(Visitor v) {
		return v.puedoPasar(this);
	}
	
	public boolean dejoAtacar(Visitor v) {
		return v.puedoAtacar(this);
	}



}
