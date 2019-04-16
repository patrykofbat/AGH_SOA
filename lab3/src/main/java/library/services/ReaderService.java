package library.services;

import library.dao.ReaderDao;
import library.model.entities.Reader;

import java.util.List;

public class ReaderService {

    private ReaderDao readerDao;

    public ReaderService() {
        this.readerDao = new ReaderDao();
    }

    public List<Reader> getAllReaders() {
        return this.readerDao.getAll();
    }
}
