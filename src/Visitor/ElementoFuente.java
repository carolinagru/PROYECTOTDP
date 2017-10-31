package Visitor;

public class ElementoFuente implements Elemento{

	@Override
	public boolean dejoPasar(Visitor v) {
		// TODO Auto-generated method stub
		return v.puedoPasar(this);
	}
	
	public boolean dejoAtacar(Visitor v) {
		return v.puedoAtacar(this);
	}

	
}
