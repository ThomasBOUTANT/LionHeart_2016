/**
 * la liste des valeurs des des
 * 
 * 
 * @author boutant
 *
 */
public enum ValeurDe {

	HACHE("H"), FLECHE("F"), PANIQUE("P"), VIDE("V");
	//VIDE va permettre de combler le vide laisse par les des non lances
	
	
	String value;
	
	ValeurDe(String value) {
		this.value= value;
	}
}
