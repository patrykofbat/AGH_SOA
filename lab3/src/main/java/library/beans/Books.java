package library.beans;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import library.pojo.Book;
import library.utils.BooksUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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

    private double sum;

    public Books() {
        this.booksData = BooksUtil.loadDataFromCsv(getClass().getClassLoader().getResource("assets/books.csv").getFile());
        this.books = new ArrayList<>(booksData);
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
                        this.books.removeIf(book -> !book.getAuthor().toLowerCase().contains(entry.getValue().toLowerCase()));
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

    public void submit() {
        this.setSum(0);
        int checkedCounter = 0;
        for (Map.Entry<Integer, Boolean> entry: this.checked.entrySet()) {
            if (entry.getValue()) {
                this.sum += this.books.get(entry.getKey()).getPrice();
                checkedCounter++;
            }
        }
        this.sum = Math.round(this.sum * 100.0) / 100.0;
        this.checkedCount = checkedCounter;

    }

}
