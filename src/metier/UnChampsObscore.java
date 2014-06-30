package metier;


/**
 * Classe qui modélise un champs (ou une colonne) du modèle de donnée obscore
 * @author Mallory Marcot
 *
 */
public class UnChampsObscore {
	
	private String name;
	private String datatype;
	
	/**
	 * Constructeur d'un champs obscore
	 * @param name Nom du champs
	 * @param datatype Type de la donnée
	 */
	public UnChampsObscore(String name, String datatype) {
		this.name = name;
		this.datatype = datatype;
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
		String ret = new String("Data type : " + this.datatype);
		
		return ret;
	}
}
