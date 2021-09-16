import java.util.LinkedList;
import java.util.List;

public class StudijskiProgram {

	private String naziv;
	private List<String> predmeti;

	public StudijskiProgram(String naziv) {
		super();
		this.naziv = naziv;
		this.predmeti = new LinkedList<String>();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<String> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<String> predmeti) {
		this.predmeti = predmeti;
	}

	public boolean dodajPredmet(String p) {
		if (!predmeti.contains(p)) {
			predmeti.add(p);
			return true;
		} else {
			System.out.println("Predmet sa imenom " + p + " vec postoji u studijskom programu " + naziv);
			return false;
		}
	}

	@Override
	public String toString() {
		String s = naziv + ":";
		for (int i = 0; i < predmeti.size(); i++) {
			s += " - " + predmeti.get(i);
		}
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StudijskiProgram) {
			StudijskiProgram o = (StudijskiProgram) obj;
			if (o.getNaziv().equalsIgnoreCase(naziv)) {
				return true;
			}
		}
		return false;
	}

	public boolean delete(int pos) {
		for (int i = 0; i < predmeti.size(); i++) {
			if (pos == i) {
				System.out.println("Brise se predmet " + predmeti.get(i));
				predmeti.remove(predmeti.get(i));
				return true;

			}
		}
		return false;
	}

	public boolean rename(int pos, String n) {

		System.out.println("Mijenja se ime predmeta " + predmeti.get(pos) + " u " + n);
		predmeti.set(pos, n);
		return true;
	}
}
