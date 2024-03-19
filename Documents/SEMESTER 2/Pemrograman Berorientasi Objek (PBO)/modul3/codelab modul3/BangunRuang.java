public class BangunRuang {
    private String name;

    BangunRuang(String namee){
        this.name = namee;
    }

    public void inputNilai(){
        System.out.println("\nInput nilai");
    }

    public void luasPermukaan() {
        System.out.println("\nMenghitung luas permukaan " + name);
    }

    public void volume(){
        System.out.println("\nMenghitung volume " + name);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
