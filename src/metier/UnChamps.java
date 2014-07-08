package metier;


/**
 * Classe qui modélise un champs (ou une colonne) du modèle de donnée obscore
 * @author Mallory Marcot
 *
 */
public class UnChamps {
	
	private String name;
	private String datatype;
	private String unit;
	private String ucd;
	private String utype;
	
	/**
	 * Constructeur d'un champs obscore
	 * @param name Nom du champs
	 * @param datatype Type de la donnée
	 * @param unit L'unité de mesure
	 * @param ucd Unité de la donnée
	 * @param utype Type de l'unité
	 */
	public UnChamps(String name, String datatype, String unit, String ucd, String utype) {
		this.name = name;
		this.datatype = datatype;
		this.unit = unit;
		this.ucd = ucd;
		this.utype = utype;
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @return the datatype
	 */
	public String getDatatype() {
		return datatype;
	}

	
	@Override
	public String toString() {
		String ret = new String("<html>");
		ret += "datatype : " + this.datatype + "<br/>";
		ret += "unit : " + this.unit + "<br/>";
		ret += "ucd : " + this.ucd + "<br/>";
		ret += "utype : " + this.utype;
		ret += "</html>";
		
		return ret;
	}
}