package fmi.java.exam;

public class Classic extends Book {
    public int pages;
    public boolean hard;

    public Classic(String auth, String nm, String year, String isbn, double price, int pages, boolean hard){
        super(auth, nm, year, isbn, price);
        this.hard = hard;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Classic\t\t" + super.toString() + "\t" + pages + "\t" + (hard ? "hardcover" : "papercover");
    }
}
