package utasszallitok;

/**
 *
 * @author Tóth Milán
 */
class Sebessegkategoria {

    private int utazosebesseg;

    public String getKategorianev() {
        if (utazosebesseg < 500) {
            return "Alacsony sebességű";
        } else if (utazosebesseg < 1000) {
            return "Szubszonikus";
        } else if (utazosebesseg < 1200) {
            return "Transzszonikus";
        } else {
            return "Szuperszonikus";
        }
    }

    Sebessegkategoria(int utazosebesseg) {
        this.utazosebesseg = utazosebesseg;
    }
}
