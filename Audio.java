package fmi.java.exam;

public class Audio extends Book {
    public String format;
    public int duration;


    public Audio(String auth, String nm, String year, String isbn, double price, int length, String format){
        super(auth, nm, year, isbn, price);
        this.format = format;
        this.duration = length;
    }
    public String toString() {
        return "Audio\t\t" + super.toString() + "\t\t\t\t\t" + duration + "\t\t" + format;
    }
}
