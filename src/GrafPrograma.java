import java.util.LinkedList;
import java.util.List;

public class GrafPrograma {

	private List<StudijskiProgram> graf;

	public GrafPrograma() {
		super();
		this.graf = new LinkedList<StudijskiProgram>();
	}

	public List<StudijskiProgram> getGraf() {
		return graf;
	}

	public void setGraf(List<StudijskiProgram> graf) {
		this.graf = graf;
	}

	public boolean dodajProgram(String naziv) {
		StudijskiProgram s = new StudijskiProgram(naziv);
		if (!graf.contains(s)) {
			graf.add(s);
			return true;
		} else {
			System.out.println("Studijski program sa nazivom " + naziv + " vec postoji u grafu programa.");
			return false;
		}
	}

	public void prikaz() {
		for (int i = 0; i < graf.size(); i++) {
			System.out.println(graf.get(i).toString());
		}
	}

	public int brojIstihPredmeta(String p1, String p2) {
		if (p1.equalsIgnoreCase(p2)) {
			System.out.println("Unijeli ste dva ista naziva programa.");
			return -1;
		}
		StudijskiProgram s1 = null;
		StudijskiProgram s2 = null;
		for (int i = 0; i < graf.size(); i++) {
			if (graf.get(i).getNaziv().equalsIgnoreCase(p1)) {
				s1 = graf.get(i);
				break;
			}
		}
		if (s1 == null) {
			System.out.println("Studijski program sa imenom " + p1 + " ne postoji u grafu.");
			return -1;
		}
		for (int i = 0; i < graf.size(); i++) {
			if (graf.get(i).getNaziv().equalsIgnoreCase(p2)) {
				s2 = graf.get(i);
				break;
			}
		}
		if (s2 == null) {
			System.out.println("Studijski program sa imenom " + p2 + " ne postoji u grafu.");
			return -1;
		}

		int brojac = 0;
		for (int i = 0; i < s1.getPredmeti().size(); i++) {
			for (int j = 0; j < s2.getPredmeti().size(); j++) {
				if (s1.getPredmeti().get(i).equalsIgnoreCase(s2.getPredmeti().get(j))) {
					brojac++;
				}
			}
		}
		return brojac;
	}

	public boolean delete(int pos) {
			System.out.println("Brise se studijski program " + graf.get(pos).getNaziv());
			graf.remove(graf.get(pos));
			return true;

	}

	public void slicni() {

		for (int i = 0; i < graf.size(); i++) {
			int broj = 0;
			int prog = 0;
			for (int j = 0; j < graf.size(); j++) {
				if (i != j && broj < brojIstihPredmeta(graf.get(i).getNaziv(), graf.get(j).getNaziv())) {
					broj = brojIstihPredmeta(graf.get(i).getNaziv(), graf.get(j).getNaziv());
					prog = j;
				}
			}
			System.out.println("Programu " + graf.get(i).getNaziv() + " najslicniji je " + graf.get(prog).getNaziv()
					+ " sa " + broj + " istih predmeta.");
		}
	}

	public int viseOdPola(String nazivPrograma) {
		StudijskiProgram s=null;
		for (int i = 0; i < graf.size(); i++) {
			if(graf.get(i).getNaziv().equalsIgnoreCase(nazivPrograma)) {
				 s = graf.get(i);
				 
				 
				
			}
		}
		if(s==null) {
			
			return -1;
		}				
		int broj = 0;
		int predmeta = (s.getPredmeti().size()) / 2;
		for (int i = 0; i < graf.size(); i++) {
			if (!s.equals(graf.get(i)) && predmeta < brojIstihPredmeta(s.getNaziv(), graf.get(i).getNaziv())) {
				broj++;
			}
		}
		return broj;
	}
}
