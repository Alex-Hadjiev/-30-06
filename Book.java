package fmi.java.exam;

public abstract class Book {
    public String author;
    public String name;
    public String year;
    public String isbn;
    public double price;

    public Book(String auth, String nm, String year, String isbn, double price){
        this.author = auth.substring(0, Math.max(100, nm.length()) );
        this.year = year;
        this.isbn = isbn;
        this.price = price;
        name = nm.substring(0, Math.max(200, nm.length()));

    }
    public String toString(){
        return name + "\t\t" + year + "\t\t" + isbn + "\t\t" + price;
    }
}
