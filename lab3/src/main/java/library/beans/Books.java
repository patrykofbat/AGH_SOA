package library.beans;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import library.dao.BookDao;
import library.dao.Dao;
import library.model.entities.Book;
import library.utils.BooksUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

@ManagedBean(name="books")
@ViewScoped
public class Books {
    private int checkedCount;
    private ArrayList<Book> books;
    private ArrayList<Book> booksData;
    private Map<Integer, Boolean> checked = new HashMap<>();
    private Map<String, String> filtersLabels = new HashMap<>() {{
        put("title", "Title");
        put("author", "Author");
        put("category", "Category");
        put("priceMin", "Price Min");
        put("priceMax", "Price Max");

    }};
    private String[] currencies = {"USD", "PLN", "EUR"};
    private String currency = "PLN";
    private Map<String, String> filters = new HashMap<>();
    private Dao<Book> bookDao;
    private Book bookInsert;

    private double sum;
    private int checkedCounter = 0;

    public Books() {
        this.bookDao = new BookDao();
        List<Book> books = this.bookDao.getAll();
        this.booksData = new ArrayList<>(books);
        this.books = new ArrayList<>(booksData);
        this.bookInsert = new Book();
    }

    public Book getBookInsert() {
        return bookInsert;
    }

    public void setBookInsert(Book bookInsert) {
        this.bookInsert = bookInsert;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public String[] getCurrencies() {
        return currencies;
    }

    public void setCurrencies(String[] currencies) {
        this.currencies = currencies;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Map<Integer, Boolean> getChecked() {
        return checked;
    }

    public void setChecked(Map<Integer, Boolean> checked) {
        this.checked = checked;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Map<String, String> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, String> filters) {
        this.filters = filters;
    }

    public Map<String, String> getFiltersLabels() {
        return filtersLabels;
    }

    public void setFiltersLabels(Map<String, String> filtersLabels) {
        this.filtersLabels = filtersLabels;
    }

    public int getCheckedCount() {
        return checkedCount;
    }

    public void setCheckedCount(int checkedCount) {
        this.checkedCount = checkedCount;
    }

    public void filterData() {
        this.books = new ArrayList<>(booksData);
        for (Map.Entry<String, String> entry: this.filters.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                switch (entry.getKey()) {
                    case "title":
                        this.books.removeIf(book -> !book.getTitle().toLowerCase().contains(entry.getValue().toLowerCase()));
                        break;
                    case "author":
                        break;
                    case "category":
                        this.books.removeIf(book -> !book.getCategory().toLowerCase().contains(entry.getValue().toLowerCase()));
                        break;
                    case "priceMin":
                        this.books.removeIf(book -> !(book.getPrice() >= Double.parseDouble(entry.getValue())));
                        break;
                    case "priceMax":
                        this.books.removeIf(book -> !(book.getPrice() <= Double.parseDouble(entry.getValue())));
                        break;
                }
            }
        }
        BooksUtil.reIndex(this.books);
    }

    public void currencyListener() {
        String exchangeRateApiUrl = "https://api.exchangeratesapi.io/latest?base=" + this.books.get(0).getCurrency();
        BufferedReader br = null;
        JsonElement responseData = null;
        try{
            URL url = new URL(exchangeRateApiUrl);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            String line = null;

            while ((line = br.readLine()) != null) {
                if (line.equalsIgnoreCase("quit")) {
                    break;
                }
                System.out.println(line);
                responseData = new JsonParser().parse(line);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error while closing stream: " + ioe);
            }
        }

        String rate = responseData.getAsJsonObject().get("rates").getAsJsonObject().get(this.currency).getAsString();
        BooksUtil.changeCurrency(this.books, this.currency, Double.parseDouble(rate));
    }

    public void delete(String id) {
        Optional<Book> bookOptional = this.bookDao.get(Integer.parseInt(id));
        bookOptional.ifPresent(book -> this.bookDao.delete(book));
        this.updateBooks();
    }

    public void addBook() {
        this.bookInsert.setCurrency("PLN");
        this.bookDao.save(this.bookInsert);
        this.updateBooks();
    }

    public void edit(Book book) {
        System.out.println(book.toString());
    }

    public void submit() {
        this.setSum(0);
        for (Map.Entry<Integer, Boolean> entry: this.checked.entrySet()) {
            if (entry.getValue()) {
                this.books.forEach(book -> {
                    if (book.getId().equals(entry.getKey())) {
                        this.sum += book.getPrice();
                        this.checkedCounter++;
                    }
                });
            }
        }
        this.sum = Math.round(this.sum * 100.0) / 100.0;
        this.checkedCount = this.checkedCounter;
        this.checkedCounter = 0;

    }

    private void updateBooks() {
        this.booksData = new ArrayList<>(this.bookDao.getAll());
        this.books = new ArrayList<>(this.booksData);
    }


}
