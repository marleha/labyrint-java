import java.util.ArrayList;

abstract class Rute {
    protected int kolonne;
    protected int rad;
    protected Labyrint labyrint;
    private ArrayList<Rute> naboruter;

    public Rute(int kolonne, int rad, Labyrint labyrint) {
        this.kolonne = kolonne;
        this.rad = rad;
        this.labyrint = labyrint;
    }

    public void finnUtvei() {
        String stringKolonne = Integer.toString(kolonne);
        String stringRad = Integer.toString(rad);
        String koordinat = "(" + stringKolonne + "," + stringRad + ")";
        // String koordinat = "(" + kolonne + "," + rad + ")";
        for (Rute naborute : naboruter) {
            // For aa komme til naboruten. Sende inn ruten vi er i(this)
            // som ruten vi kom fra og dens koordinater i String.
            naborute.gaa(koordinat, this);
            
        }
    }
    

    // Naa har vi gatt videre inn i et annet objekt, ruten sin naboruten, som
    // var ruten vi kom fra sin naborute.
    public abstract void gaa(String forelopigVeiKoordinater, Rute rutenViKomFra);
    
    public boolean erAapning(){
        // Hvis vi er i en av kantene maa vi vaere en aapning
        return labyrint.erAapning(kolonne, rad);
    }

    public abstract char tilTegn();
        //returnerer rutens tegnrepresentasjon
        // (denne skal følge filformatet som beskrevet lenger opp!).

	/**
	 * @return the kolonne
	 */
	public int getKolonne() {
		return kolonne;
    }
    
    public int getRad() {
        return rad;
    }

    public ArrayList<Rute> hentNaboruter() {
        return naboruter;
    }

    public void settNaboruter() {
        naboruter = labyrint.finnNaboruter(kolonne, rad);
    }

    public String toString() {
        return "" + tilTegn();
    }
}

// I tillegg skal klassen ha referanser til sine eventuelle
// nabo-ruter (nord/syd/vest/øst).
