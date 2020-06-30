package fmi.java.exam;

public class EBook extends Book {
    public int pages;
    public String format;

    public EBook(String auth, String nm, String year, String isbn, double price, int pages, String format){
        super(auth, nm, year, isbn, price);
        this.pages = pages;
        this.format = format;
    }
    public String toString() {
        return "Audio\t\t" + super.toString() + pages + "\t\t\t" + "\t\t" + format;
    }
}
