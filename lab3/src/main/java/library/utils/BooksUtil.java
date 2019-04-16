package library.utils;

import library.model.entities.Book;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BooksUtil {

    public static ArrayList<Book> loadDataFromCsv(String path) {
        ArrayList<Book> books = new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
        try {
            br = new BufferedReader(new FileReader(path));
            br.readLine(); // to rid of headers
            int id = 0;
            while ((line = br.readLine()) != null) {

                String[] bookCsv = line.split(cvsSplitBy);

                Book book = new Book();
                book.setId(id);
                book.setTitle(bookCsv[0]);
                book.setCategory(bookCsv[2]);
                book.setPages(bookCsv[3]);
                book.setPrice(Double.parseDouble(bookCsv[5]));
                book.setCurrency(bookCsv[6]);

                books.add(book);
                id++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return books;
    }

    public static void reIndex(ArrayList<Book> books) {
        int counter = 0;
        for (Book book: books) {
            book.setId(counter);
            counter++;
        }
    }

    public static void changeCurrency(ArrayList<Book> books, String currency, double rate) {
        for (Book book: books) {
            book.setCurrency(currency);
            book.setPrice(Math.round(book.getPrice() * rate * 100.0) / 100.0);
        }
    }
}
