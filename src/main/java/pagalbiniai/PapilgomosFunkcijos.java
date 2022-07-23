package pagalbiniai;

import entities.Darbuotojai;

import java.util.ArrayList;

public class PapilgomosFunkcijos {
    public PapilgomosFunkcijos() {
    }
    public static void isvestiDarbuotojuListaEilutemis(ArrayList<Darbuotojai>darbuotojas){
        for (Darbuotojai darbuotojai : darbuotojas){
            System.out.println("darbuotojai = " + darbuotojai);
            
        }
    }
}
