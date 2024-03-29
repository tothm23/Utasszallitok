package utasszallitok;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Tóth Milán
 */
public class Utasszallitok {

    ArrayList<Adat> adatok = new ArrayList<>();

    public Utasszallitok(String fajl) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fajl));
            String sor = br.readLine();

            while ((sor = br.readLine()) != null) {
                String[] darabok = sor.split(";");
                adatok.add(new Adat(darabok));
            }

            br.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void kiir() {
        for (Adat adat : adatok) {
            adat.kiir();
        }
    }

    public int boeingRepulogepTipus() {
        int db = 0;

        for (Adat adat : adatok) {
            if (adat.getTipus().startsWith("Boeing")) {
                db++;
            }
        }

        return db;
    }

    public Adat legtobbUtasRepulogepTipus() {
        Adat kis = adatok.get(0);

        for (Adat adat : adatok) {
            if (adat.getUtas() > kis.getUtas()) {
                kis = adat;
            }
        }

        return kis;
    }

    public String nemTalalhatoSebessegKategoria() {

        ArrayList<String> nemTalalhatoKategoriak = new ArrayList<>();

        nemTalalhatoKategoriak.add("Alacsony sebességű");
        nemTalalhatoKategoriak.add("Szubszonikus");
        nemTalalhatoKategoriak.add("Transzszonikus");
        nemTalalhatoKategoriak.add("Szuperszonikus");

        for (Adat adat : adatok) {
            // Ha van egyezés, akkor az adott sebesség kategória létezik
            nemTalalhatoKategoriak.remove(adat.getSebessegkategoria());
        }

        if (nemTalalhatoKategoriak.size() == 4) {
            return "Minden sebességkategóriából van repülőgéptípus.";
        } else {
            String kategoriak = "";
            for (String kategoria : nemTalalhatoKategoriak) {
                kategoriak += kategoria + " ";
            }
            return kategoriak;
        }

    }

    public void fajlIras(String fajl) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fajl));

            bw.write("típus;év;utas;személyzet;utazósebesség;felszállótömeg;fesztáv\n");
            for (Adat adat : adatok) {
                String szemelyzet = "";
                int felszalloTomeg = Math.round(adat.getFelszallotomeg() / 1000);
                int fesztav = (int) Math.round(adat.getFesztav() * 3.2808);

                if (adat.getSzemelyzet().contains("-")) {
                    szemelyzet = adat.getSzemelyzet().split("-")[1];
                } else {
                    szemelyzet = adat.getSzemelyzet();
                }

                bw.write(adat.getTipus() + ";" + adat.getEv() + ";" + adat.getUtas() + ";" + szemelyzet + ";" + adat.getUtazosebesseg()
                        + ";" + adat.getSebessegkategoria() + ";" + felszalloTomeg + ";" + fesztav + "\n"
                );
            }

            System.out.print("Az " + fajl + " sikeresen létrehozva!\n");
            bw.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Utasszallitok u = new Utasszallitok("utasszallitok.txt");
//        u.kiir();
        System.out.println("4. feladat: Adatsorok száma: " + u.adatok.size());
        System.out.println("5. feladat: Boeing típusok száma: " + u.boeingRepulogepTipus());

        Adat a = u.legtobbUtasRepulogepTipus();
        System.out.println("6. feladat: A legtöbb utast szállító repülőgép típus: ");
        a.seged();

        System.out.println("7. feladat:\n\t" + u.nemTalalhatoSebessegKategoria());
        System.out.print("8. feladat:\t");
        u.fajlIras("utasszallitok_new.txt");

    }

}
