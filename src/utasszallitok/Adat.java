package utasszallitok;

/**
 *
 * @author Tóth Milán
 */
public class Adat {

    private String tipus;
    private String ev;
    private int utas;
    private String szemelyzet;
    private int utazosebesseg;
    private String sebessegkategoria;
    private int felszallotomeg;
    private double fesztav;

    public Adat(String[] sor) {

        this.tipus = sor[0];
        this.ev = sor[1];

        if (!sor[2].contains("-")) {
            this.utas = Integer.parseInt(sor[2]);
        } else {
            this.utas = Integer.parseInt(sor[2].split("-")[1]);
        }

        this.szemelyzet = sor[3];
        this.utazosebesseg = Integer.parseInt(sor[4]);

        Sebessegkategoria s = new Sebessegkategoria(utazosebesseg);
        this.sebessegkategoria = s.getKategorianev();

        this.felszallotomeg = Integer.parseInt(sor[5]);
        this.fesztav = Double.parseDouble(sor[6].replace(",", "."));
    }

    public void kiir() {
        System.out.println(this.tipus + ";" + this.ev + ";" + this.utas + ";" + this.szemelyzet + ";" + this.utazosebesseg
                + ";" + this.sebessegkategoria + ";" + this.felszallotomeg + ";" + this.fesztav + ";");
    }

    public void seged() {
        System.out.println("\tTípus: " + this.tipus + "\n\tElső felszállás: " + this.ev + "\n\tUtasok száma: " + this.utas
                + "\n\tSzemélyzet: " + this.szemelyzet + "\n\tUtazósebesség: " + this.utazosebesseg);
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getEv() {
        return ev;
    }

    public void setEv(String ev) {
        this.ev = ev;
    }

    public int getUtas() {
        return utas;
    }

    public void setUtas(int utas) {
        this.utas = utas;
    }

    public String getSzemelyzet() {
        return szemelyzet;
    }

    public void setSzemelyzet(String szemelyzet) {
        this.szemelyzet = szemelyzet;
    }

    public int getUtazosebesseg() {
        return utazosebesseg;
    }

    public void setUtazosebesseg(int utazosebesseg) {
        this.utazosebesseg = utazosebesseg;
    }

    public String getSebessegkategoria() {
        return sebessegkategoria;
    }

    public void setSebessegkategoria(String sebessegkategoria) {
        this.sebessegkategoria = sebessegkategoria;
    }

    public int getFelszallotomeg() {
        return felszallotomeg;
    }

    public void setFelszallotomeg(int felszallotomeg) {
        this.felszallotomeg = felszallotomeg;
    }

    public double getFesztav() {
        return fesztav;
    }

    public void setFesztav(double fesztav) {
        this.fesztav = fesztav;
    }

}
