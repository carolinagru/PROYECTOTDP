package Estate;

import Personajes.Personaje;

public class estadoSinMagia extends Estado {
	//Cuando los personajes se encuentran sin magia, la cantidad de vida que se le extrae al personaje es:
		// (el porcentaje de la fuerza del ataquante * la vida del personaje)
	 
	public estadoSinMagia () {
		
	}
	
	public void disminuirVida(float i, Personaje p) {
		float vida = p.getVida() * i;
		p.setVida(vida);
		
	} 

}
