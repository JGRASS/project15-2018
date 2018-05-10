package kafic;

import java.util.LinkedList;

public class Sto {
	private int brojStola;
	private LinkedList<Racun> racuniNaStolu = new LinkedList<Racun>();

	public int getBrojStola() {
		return brojStola;
	}

	public void setBrojStola(int brojStola) {
		this.brojStola = brojStola;
	}

	public LinkedList<Racun> getRacuniNaStolu() {
		return racuniNaStolu;
	}

	public void setRacuniNaStolu(LinkedList<Racun> racuniNaStolu) {
		this.racuniNaStolu = racuniNaStolu;
	}
	
	@Override
	public String toString() {
		String returnThis = "";
		for (int i = 0; i < racuniNaStolu.size(); i++) {
			returnThis += racuniNaStolu.get(i).getSifraRacuna() + "\n";
		}
		return returnThis;
	}

}
