package library.services;

import library.dao.ReaderDao;
import library.model.entities.Reader;

import java.util.List;
import java.util.Optional;

public class ReaderService {

    private ReaderDao readerDao;

    public ReaderService() {
        this.readerDao = new ReaderDao();
    }

    public List<Reader> getAllReaders() {
        return this.readerDao.getAll();
    }

    public Optional<Reader> getReader(int readerId) {
        return this.readerDao.get(readerId);
    }
}
