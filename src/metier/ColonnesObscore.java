package metier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import util.Configuration;


/**
 * Classe qui contient l'ensemble des champs obscore
 * @author Mallory Marcot
 *
 */
public class ColonnesObscore {
	
	/**
	 * Methode statique qui renvoie l'ensemble des colonnes obscores
	 * à incorporer dans le plug-in
	 * @return ArrayList<String> liste colonnes
	 */
	public static ArrayList<UnChampsObscore> getColonnesObscore() {
		ArrayList<UnChampsObscore> liste_col = new ArrayList<UnChampsObscore>();
		
		liste_col.add(new UnChampsObscore("sky_pixel_csa", Configuration.INTEGER));
		liste_col.add(new UnChampsObscore("dataproduct_type", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("calib_level", Configuration.INTEGER));
		liste_col.add(new UnChampsObscore("target_name", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("obs_id", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("obs_collection", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("obs_creator_name", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("obs_publisher_did", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("data_rights", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("access_url", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("access_format", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("access_estsize", Configuration.INTEGER));
		liste_col.add(new UnChampsObscore("datalink", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("s_ra", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("s_dec", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("s_fov", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("s_region", Configuration.REGION));
		liste_col.add(new UnChampsObscore("s_resolution", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("t_min", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("t_max", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("t_exptime", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("t_resolution", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("em_min", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("em_max", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("em_res_power", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("em_resolpower_min", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("em_resolpower_max", Configuration.DOUBLE));
		liste_col.add(new UnChampsObscore("o_ucd", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("pol_stat", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("facility_name", Configuration.VARCHAR));
		liste_col.add(new UnChampsObscore("instrument_name", Configuration.VARCHAR));
		
		return liste_col;
	}

}
