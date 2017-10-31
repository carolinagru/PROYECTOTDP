package Visitor;

public class ElementoAgua implements Elemento{

	@Override
	public boolean dejoPasar(Visitor v) {
		// TODO Auto-generated method stub
		return v.puedoPasar(this);
	}

	@Override
	public boolean dejoAtacar(Visitor v) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
