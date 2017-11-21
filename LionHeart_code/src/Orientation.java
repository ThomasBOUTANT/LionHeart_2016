/**
 * la liste des orientations possibles
 * 
 * @author belaid
 *
 */
public enum Orientation {

	NORD("Nord"), SUD("Sud"), EST("Est"), OUEST("Ouest");

	String value;

	Orientation(String value) {
		this.value = value;
	}
}
