import entities.Darbuotojai;
import pagalbiniai.PapilgomosFunkcijos;
import veiksmaiSuDuomenuBaze.VeiksmaiSuDuomenuBaze;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PagrindinePrograma {
    public static void main(String[] args) {
        Connection jungtis= null;
        try {

            jungtis = VeiksmaiSuDuomenuBaze.prisijungtiPrieDuombenuBazesMokykla();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko prisijungti prie duomenų bazės.");
        }
        try {
            ArrayList<Darbuotojai>visiDarbuotojai=VeiksmaiSuDuomenuBaze.grazintiVisusDarbuotojus(jungtis);

            PapilgomosFunkcijos.isvestiDarbuotojuListaEilutemis(visiDarbuotojai);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("------------------");
        ArrayList<Darbuotojai> darbuotojuStazas=VeiksmaiSuDuomenuBaze.grazintiStazas(jungtis, 10);
        System.out.println("Kuriu stazas yra");
        PapilgomosFunkcijos.isvestiDarbuotojuListaEilutemis(darbuotojuStazas);

        System.out.println("------------------");

        Darbuotojai pridedamasDarbuotojas = new Darbuotojai("Saulius","Sauliusas",56,"medkirtys", 152.45);
        VeiksmaiSuDuomenuBaze.pridetiDarbuotoja(jungtis, pridedamasDarbuotojas);
        try {
            ArrayList<Darbuotojai> visiDarbuotojai = VeiksmaiSuDuomenuBaze.grazintiVisusDarbuotojus(jungtis);
            PapilgomosFunkcijos.isvestiDarbuotojuListaEilutemis(visiDarbuotojai);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
