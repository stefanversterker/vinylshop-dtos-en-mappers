package nl.novi.vinylshop.services;


import java.util.List;

public interface BaseServiceInterface<T> {
    List<T> findAllPublishers();

    T findPublishersById(Long id);

    T createPublishers(T input);

    T updatePublishers(Long id, T input);

    void deletePublishers(Long id);
}
