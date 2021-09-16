import java.util.Scanner;

public class Test {
	public void test() {
		Scanner sc = new Scanner(System.in);
		GrafPrograma g = new GrafPrograma();

		g.dodajProgram("FIT");
		g.dodajProgram("FVU");
		g.dodajProgram("MBS");

		g.getGraf().get(0).dodajPredmet("Mata");
		g.getGraf().get(0).dodajPredmet("Engleski");
		g.getGraf().get(0).dodajPredmet("Srpski");
		g.getGraf().get(0).dodajPredmet("Baze");

		g.getGraf().get(1).dodajPredmet("Geografija");
		g.getGraf().get(1).dodajPredmet("Baze");
		g.getGraf().get(1).dodajPredmet("Mata");
		g.getGraf().get(1).dodajPredmet("Pingvini");

		g.getGraf().get(2).dodajPredmet("Baze");
		g.getGraf().get(2).dodajPredmet("Engleski");
		g.getGraf().get(2).dodajPredmet("Mata");
		g.getGraf().get(2).dodajPredmet("Srpski");

		int izbor = -1;
		while (izbor != 0) {
			System.out.println("--------------------------------------------------------");
			System.out.println("Izaberite opciju:");
			System.out.println("1. Dodaj studijski program");
			System.out.println("2. Dodaj predmet u studijski program");
			System.out.println("3. Izbrisi studijski program");
			System.out.println("4. Izbrisi predmet");
			System.out.println("5. Promijeni ime studijskog programa");
			System.out.println("6. Promijeni ime predmeta");
			System.out.println("7. Ispis najslicnijih programa");
			System.out.println("8. Broj programa koji imaju vise od pola istih predmeta");
			System.out.println("9. Broj istih predmeta");
			System.out.println("10. Prikaz programa i njihovih predmeta");
			System.out.println("0. Izadjite");
			System.out.println("--------------------------------------------------------");
			System.out.println();
			izbor = sc.nextInt();
			while(izbor != (int) izbor) {
				if (izbor != (int) izbor) {
			        throw new NullPointerException("Molim vas unesite broj:  ");
			    }
				System.out.println("Molim vas unesite broj: ");
				izbor = sc.nextInt();
				
			}

			String s = "";
			int pos, pos2;
			switch (izbor) {
			case 1:
				System.out.println("Unesite naziv studijskog programa");
				sc.nextLine();
				s = sc.nextLine();
				g.dodajProgram(s);
				break;

			case 2:
				System.out.println("Izaberi u koji program dodajete predmet:");
				for (int i = 0; i < g.getGraf().size(); i++) {
					System.out.println(i + 1 + ". " + g.getGraf().get(i));
				}
				pos = sc.nextInt();
				if (pos < 1 || pos > g.getGraf().size()) {
					System.out.println("Unesena pozicija nije validna");
					break;
				}
				System.out.println("Unesite naziv predmeta");
				sc.nextLine();
				s = sc.nextLine();
				g.getGraf().get(pos - 1).dodajPredmet(s);
				break;

			case 3:
				System.out.println("Izaberite studijski program koji brisete");
				for (int i = 0; i < g.getGraf().size(); i++) {
					System.out.println((i + 1) + ". " + g.getGraf().get(i));
				}
				pos = sc.nextInt();
				if (pos < 1 || pos > g.getGraf().size()) {
					System.out.println("Unesena pozicija nije validna");
					break;
				}
				g.delete(pos - 1);
				break;

			case 4:
				System.out.println("Izaberite studijski program iz kojeg brisete predmet");
				for (int i = 0; i < g.getGraf().size(); i++) {
					System.out.println((i + 1) + ". " + g.getGraf().get(i));
				}
				pos = sc.nextInt();
				if (pos < 1 || pos > g.getGraf().size()) {
					System.out.println("Unesena pozicija nije validna");
					break;
				}
				System.out.println("Izaberite koji predmet brisete");
				for (int i = 0; i < g.getGraf().get(pos - 1).getPredmeti().size(); i++) {
					System.out.println((i + 1) + ". " + g.getGraf().get(pos - 1).getPredmeti().get(i));
				}
				pos2 = sc.nextInt();
				if (pos2 < 1 || pos2 > g.getGraf().get(pos - 1).getPredmeti().size()) {
					System.out.println("Unesena pozicija nije validna");
					break;
				}
				g.getGraf().get(pos - 1).delete(pos2 - 1);
				break;

			case 5:
				System.out.println("Izaberite studijski program kojem mijenjate ime");
				for (int i = 0; i < g.getGraf().size(); i++) {
					System.out.println((i + 1) + ". " + g.getGraf().get(i));
				}
				pos = sc.nextInt();
				if (pos < 1 || pos > g.getGraf().size()) {
					System.out.println("Unesena pozicija nije validna");
					break;
				}
				System.out.println("Unesite novo ime");
				sc.nextLine();
				s = sc.nextLine();
				g.getGraf().get(pos - 1).setNaziv(s);
				break;

			case 6:
				System.out.println("Izaberite studijski program iz kojeg mijenjate ime predmeta");
				for (int i = 0; i < g.getGraf().size(); i++) {
					System.out.println((i + 1) + ". " + g.getGraf().get(i));
				}
				pos = sc.nextInt();
				if (pos < 1 || pos > g.getGraf().size()) {
					System.out.println("Unesena pozicija nije validna");
					break;
				}
				System.out.println("Izaberite kojem predmetu mijenjate ime");
				for (int i = 0; i < g.getGraf().get(pos - 1).getPredmeti().size(); i++) {
					System.out.println((i + 1) + ". " + g.getGraf().get(pos - 1).getPredmeti().get(i));
				}
				pos2 = sc.nextInt();
				if (pos2 < 1 || pos2 > g.getGraf().get(pos - 1).getPredmeti().size()) {
					System.out.println("Unesena pozicija nije validna");
					break;
				}
				System.out.println("Unesite novo ime za predmet");
				sc.nextLine();
				s = sc.nextLine();
				g.getGraf().get(pos - 1).rename(pos2 - 1, s);

				break;
			case 7:
				g.slicni();
				break;
			case 8:
				System.out.println("Unesite ime studijskog programa");
				sc.nextLine();
				s = sc.nextLine();

				g.viseOdPola(s);
				if (g.viseOdPola(s) == -1) {
					System.out.println("Nema programa sa tim nazivom");
				} else {
					System.out.println("Broj predmeta koji imaju vise od pola istih predmeta sa programom " + s
							+ " je: " + g.viseOdPola(s));
				}
				break;
			case 9:
				for (int i = 0; i < g.getGraf().size(); i++) {
					System.out.println((i + 1) + ". " + g.getGraf().get(i));
				}
				System.out.println("Izaberite prvi studijski program");
				pos = sc.nextInt();
				if (pos < 1 || pos > g.getGraf().size()) {
					System.out.println("Unesena pozicija nije validna");
					break;
				}
				System.out.println("Izaberite drugi studijski program");
				pos2 = sc.nextInt();
				if (pos2 < 1 || pos2 > g.getGraf().size()) {
					System.out.println("Unesena pozicija nije validna");
					break;
				}
				System.out.println(
						g.brojIstihPredmeta(g.getGraf().get(pos - 1).getNaziv(), g.getGraf().get(pos2 - 1).getNaziv()));
				break;
			case 10:
				g.prikaz();
				break;

			default:
				System.out.println("Invalid number, pls try again");
				break;
			}
		}
		sc.close();
	}
}
