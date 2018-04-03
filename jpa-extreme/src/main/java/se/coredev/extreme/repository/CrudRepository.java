package se.coredev.extreme.repository;

import se.coredev.extreme.data.AbstractEntity;

import java.util.List;

public interface CrudRepository<E extends AbstractEntity> {

    E saveOrUpdate(E entity);

    E remove(E entity);

    E findById(Long id);

    List<E> findAll();
}
