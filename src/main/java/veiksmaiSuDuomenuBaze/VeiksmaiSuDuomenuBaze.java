package veiksmaiSuDuomenuBaze;

import entities.Darbuotojai;

import java.sql.*;
import java.util.ArrayList;

public class VeiksmaiSuDuomenuBaze {
    public static final String DB_NUORODA = "jdbc:mysql://localhost:3306/mokykla?serverTimezone=UTC&characterEncoding=utf8";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";

    public VeiksmaiSuDuomenuBaze(){

    }
    public static Connection prisijungtiPrieDuombenuBazesMokykla() throws SQLException {
        return DriverManager.getConnection(DB_NUORODA, DB_USER, DB_PASSWORD);
    }
    public static ArrayList<Darbuotojai> grazintiVisusDarbuotojus(Connection jungtis)throws SQLException {
        ArrayList<Darbuotojai>visiDarbuotojai=new ArrayList<>();
        String sqlUzklausa="SELECT * FROM darbuotojai";

        PreparedStatement paruostukas= jungtis.prepareStatement(sqlUzklausa);
        ResultSet rezultatas= paruostukas.executeQuery();
        while (rezultatas.next()){
            int id =rezultatas.getInt("id");
            String vardas= rezultatas.getString("vardas");
            String pavarde= rezultatas.getString("pavarde");
            int stazas= rezultatas.getInt("stazas");
            String profesija= rezultatas.getString("profesija");
            double atlyginimas=rezultatas.getDouble("atlyginimas");
            Darbuotojai laikinaDarbuotojai= new Darbuotojai(id,vardas,pavarde,
                    stazas,profesija,atlyginimas);
            visiDarbuotojai.add(laikinaDarbuotojai);
        }
        return visiDarbuotojai;
    }
    public static ArrayList<Darbuotojai> grazintiStazas (Connection jungtis, int x) {
        ArrayList<Darbuotojai> darbuotojas = new ArrayList<>();
        String sqlUzklausa="SELECT * FROM darbuotojai WHERE stazas < ?";
        try {
            PreparedStatement paruostukas=jungtis.prepareStatement(sqlUzklausa);
            paruostukas.setInt(1,x);
            ResultSet rezultatas = paruostukas.executeQuery();
            while (rezultatas.next()) {
                darbuotojas.add(new Darbuotojai(rezultatas.getInt("id"), rezultatas.getString("vardas"), rezultatas.getString("pavarde"), rezultatas.getInt("stazas"), rezultatas.getString("profesija"),rezultatas.getDouble("atlyginimas")));
            }



        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko pasiekti duomenų.");
        }
        return darbuotojas;
    }
    public static void pridetiDarbuotoja(Connection jungtis, Darbuotojai darbuotojai){
        String sqlUzklausa = "INSERT INTO darbuotojai(vardas,pavarde,stazas,profesija,atlyginimas) VALUES (?, ?, ?, ?,?)";
        try {
            PreparedStatement paruostukas = jungtis.prepareStatement(sqlUzklausa);
            paruostukas.setString(1,darbuotojai.getVardas());
            paruostukas.setString(2, darbuotojai.getPavarde());
            paruostukas.setInt(3,darbuotojai.getStazas());
            paruostukas.setString(4,darbuotojai.getProfesija());
            paruostukas.setDouble(5,darbuotojai.getAtlyginimas());
            paruostukas.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Nepavyko įdėti duomenų į duomenų bazę");
        }
    }


}
