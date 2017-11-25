package Factory;

import PowerUps.Bomba;
import PowerUps.ObjetoPrecioso;

public class FactoryBomba implements ObjetoPreciosoMethodFactory {
	
	public ObjetoPrecioso crearBomba() {
		Bomba b = new Bomba();
		return b;
	}

}
