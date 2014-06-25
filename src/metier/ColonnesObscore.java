package metier;

import java.util.ArrayList;
import java.util.Collections;


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
	public static ArrayList getColonnesObscore() {
		ArrayList<String> liste_col = new ArrayList<String>();
		
		liste_col.add("sky_pixel_csa");
		liste_col.add("dataproduct_type");
		liste_col.add("calib_level");
		liste_col.add("target_name");
		liste_col.add("target_class");
		liste_col.add("obs_id");
		liste_col.add("obs_collection");
		liste_col.add("obs_creator_name");
		liste_col.add("obs_publisher_did");
		liste_col.add("bib_reference");
		liste_col.add("data_rights");
		liste_col.add("access_url");
		liste_col.add("access_format");
		liste_col.add("access_estsize");
		liste_col.add("datalink");
		liste_col.add("s_ra");
		liste_col.add("s_dec");
		liste_col.add("s_fov");
		liste_col.add("s_region");
		liste_col.add("s_resolution");
		liste_col.add("s_ucd");
		liste_col.add("t_min");
		liste_col.add("t_max");
		liste_col.add("t_exptime");
		liste_col.add("t_resolution");
		liste_col.add("t_cal_status");
		liste_col.add("t_stat_err");
		liste_col.add("em_min");
		liste_col.add("em_max");
		liste_col.add("em_res_power");
		liste_col.add("em_resolpower_min");
		liste_col.add("em_resolpower_max");
		liste_col.add("em_resolution");
		liste_col.add("em_stat_err");
		liste_col.add("o_ucd");
		liste_col.add("o_calib_status");
		liste_col.add("o_stat_err");
		liste_col.add("pol_stat");
		liste_col.add("facility_name");
		liste_col.add("instrument_name");
		
		Collections.sort(liste_col);
		
		return liste_col;
	}

}
