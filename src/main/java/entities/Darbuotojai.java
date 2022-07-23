package entities;

public class Darbuotojai {
    private int id;
    private String vardas;
    private String pavarde;
    private int stazas;
    private String profesija;
    private double atlyginimas;

    public Darbuotojai() {
    }

    public Darbuotojai(String vardas, String pavarde, int stazas, String profesija, double atlyginimas) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.stazas = stazas;
        this.profesija = profesija;
        this.atlyginimas = atlyginimas;
    }

    public Darbuotojai(int id, String vardas, String pavarde, int stazas, String profesija, double atlyginimas) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.stazas = stazas;
        this.profesija = profesija;
        this.atlyginimas = atlyginimas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public int getStazas() {
        return stazas;
    }

    public void setStazas(int stazas) {
        this.stazas = stazas;
    }

    public String getProfesija() {
        return profesija;
    }

    public void setProfesija(String profesija) {
        this.profesija = profesija;
    }

    public double getAtlyginimas() {
        return atlyginimas;
    }

    public void setAtlyginimas(double atlyginimas) {
        this.atlyginimas = atlyginimas;
    }

    @Override
    public String toString() {
        return "Darbuotojai{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", stazas=" + stazas +
                ", profesija='" + profesija + '\'' +
                ", atlyginimas=" + atlyginimas +
                '}';
    }
}
