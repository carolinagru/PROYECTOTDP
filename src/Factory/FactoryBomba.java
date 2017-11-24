package Factory;

import PowerUps.Bomba;
import PowerUps.MagiaTemporal;
import PowerUps.ObjetoPrecioso;

public class FactoryBomba implements ObjetoPreciosoMethodFactory {
	
	public ObjetoPrecioso crearBomba() {
		Bomba b = new Bomba();
		return b;
	}

}
