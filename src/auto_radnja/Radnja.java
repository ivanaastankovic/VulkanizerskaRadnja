package auto_radnja;

import java.util.LinkedList;

import auto_radnja.gume.AutoGuma;

/**
 * Interfejs koji predstavlja radnju
 * 
 * @author Ivana Stankovic
 *
 */
public interface Radnja {
	/**
	 * Dodaje novu gumu u radnju.
	 * @param a Auto guma koja se dodaje u radnju.
	 * @throws java.lang.NullPointerException ako je uneta guma null.
	 * @throws java.lang.RuntimeException ako guma vec postoji u radnji.
	 */
	void dodajGumu(AutoGuma a);
	/**
	 * Vraca listu auto guma za prosledjeni model marke. 
	 * @param markaModel model marke auto gume
	 * @return 
	 * <ul>
	 * <li>null ako je uneti model marke null.</li>
	 * <li>nova lista koja sadrzi sve gume zadatog modela marke.</li>
	 * </ul>
	 */
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);
}
