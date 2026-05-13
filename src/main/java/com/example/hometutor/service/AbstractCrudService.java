package com.example.hometutor.service;

import com.example.hometutor.model.IdentifiableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractCrudService<T extends IdentifiableEntity> {
    private final JpaRepository<T, String> repository;

    protected AbstractCrudService(JpaRepository<T, String> repository) {
        this.repository = repository;
    }

    public void create(T entity) {
        if (repository.existsById(entity.getId())) {
            throw new IllegalArgumentException("Record already exists with ID " + entity.getId());
        }
        repository.save(entity);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public Optional<T> findById(String id) {
        return repository.findById(id);
    }

    public boolean update(T entity) {
        if (!repository.existsById(entity.getId())) {
            return false;
        }
        repository.save(entity);
        return true;
    }

    public boolean delete(String id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    public abstract List<T> search(String keyword);
}
