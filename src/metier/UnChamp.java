package metier;


/**
 * Classe qui modélise un champs (ou une colonne) du modèle de donnée obscore
 * @author Mallory Marcot
 *
 */
public class UnChamp {
	
	private String name;
	private String datatype;
	private String unit;
	private String ucd;
	private String utype;
	private String description;
	
	/**
	 * Constructeur d'un champs obscore
	 * @param name Nom du champs
	 * @param datatype Type de la donnée
	 * @param unit L'unité de mesure
	 * @param ucd Unité de la donnée
	 * @param utype Type de l'unité
	 * @param description Description du champs
	 */
	public UnChamp(String name, String datatype, String unit, String ucd, String utype, String description) {
		this.name = name;
		this.datatype = datatype;
		this.unit = unit;
		this.ucd = ucd;
		this.utype = utype;
		this.description = description;
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	
	@Override
	public String toString() {
		String ret = new String("<html>");
		ret += "<strong>" + this.description + "</strong><br/>";
		ret += "<em>datatype :</em> " + this.datatype + "<br/>";
		ret += "<em>unit :</em> " + this.unit + "<br/>";
		ret += "<em>ucd :</em> " + this.ucd + "<br/>";
		ret += "<em>utype :</em> " + this.utype;
		ret += "</html>";
		
		return ret;
	}
}
