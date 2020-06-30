package fmi.java.exam;

import javax.lang.model.type.UnknownTypeException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.SQLOutput;
import java.util.*;

public class BookStore {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Въведете име на автор: ");
        String author = sc.nextLine();
        List<Book> books = new List<>() {
            public int size() {
                return 0;
            }

            public boolean isEmpty() {
                return false;
            }

            public boolean contains(Object o) {
                return false;
            }

            public Iterator<Book> iterator() {
                return null;
            }

            public Object[] toArray() {
                return new Object[0];
            }

            public <T> T[] toArray(T[] a) {
                return null;
            }

            public boolean add(Book book) {
                return false;
            }

            public boolean remove(Object o) {
                return false;
            }

            public boolean containsAll(Collection<?> c) {
                return false;
            }

            public boolean addAll(Collection<? extends Book> c) {
                return false;
            }

            public boolean addAll(int index, Collection<? extends Book> c) {
                return false;
            }

            public boolean removeAll(Collection<?> c) {
                return false;
            }

            public boolean retainAll(Collection<?> c) {
                return false;
            }

            public void clear() {

            }

            public boolean equals(Object o) {
                return false;
            }

            public int hashCode() {
                return 0;
            }

            public Book get(int index) {
                return null;
            }

            public Book set(int index, Book element) {
                return null;
            }

            public void add(int index, Book element) {

            }

            public Book remove(int index) {
                return null;
            }

            public int indexOf(Object o) {
                return 0;
            }

            public int lastIndexOf(Object o) {
                return 0;
            }

            public ListIterator<Book> listIterator() {
                return null;
            }

            public ListIterator<Book> listIterator(int index) {
                return null;
            }

            public List<Book> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        BufferedReader read;
        try {
            read = new BufferedReader(new FileReader("Books.txt"));
            String line = read.readLine();
            while (line != null) {
                if (line.toLowerCase().contains(author.toLowerCase())){
                    String type = "";
                    for (int i = 0; line.toCharArray()[i] != ';'; ++i) {
                        type += "" + line.toCharArray()[i];
                    }

                    switch (type.toLowerCase()){
                        case "classic":
                            books.add(ClassicBook(line)); break;
                        case "ebook":
                            books.add(eBook(line)); break;
                        case "audio":
                            books.add(AudioBook(line)); break;
                    }
                }
                line = read.readLine();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        int audio = 0;
        int classic = 0;
        int ebook = 0;

        File toWrite = new File("Spravka.txt");

        try {
            FileWriter myWriter = new FileWriter("Spravka.txt");
            myWriter.write("Вид\t\t\tЗаглавие\t\tГодина\tISBN\t\tСтраници\t\tКорици\t\tВреме\t\tФормат\n");
            for (Book b: books) {
                myWriter.write(b.toString());
                if (b instanceof Audio) ++audio;
                else if (b instanceof Classic) ++classic;
                else if (b instanceof EBook) ++ebook;
            }
            myWriter.write("\nКниги на " + author + ": " + (audio+classic+ebook) + "( audio: " + audio + ", classic: " + classic + ", e-book: " + ebook + " );");
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public static Audio AudioBook(String line){
        char[] str = line.toCharArray();
        splitStr(str);
        return new Audio(splitStr(str), splitStr(str), splitStr(str), splitStr(str), Double.parseDouble(splitStr(str)), Integer.parseInt(splitStr(str)), splitStr(str));
    }

    public static EBook eBook(String line){
        char[] str = line.toCharArray();
        splitStr(str);
        return new EBook(splitStr(str), splitStr(str), splitStr(str), splitStr(str), Double.parseDouble(splitStr(str)), Integer.parseInt(splitStr(str)), splitStr(str));
    }

    public static Classic ClassicBook(String line){
        char[] str = line.toCharArray();
        splitStr(str);
        return new Classic(splitStr(str), splitStr(str), splitStr(str), splitStr(str), Double.parseDouble(splitStr(str)), Integer.parseInt(splitStr(str)), splitStr(str).contains("hard"));
    }

    public static String splitStr(char[]  str){
        String res = "";
        int i;
        for (i = 0; str.length > i && ';' != str[i]; ++i) {
            res += str[i];
            str[i] = ' ';
        }
        str[i] = ' ';
        res = res.trim();
        return res;
    }

}
