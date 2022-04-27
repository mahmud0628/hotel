package uz.hotel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommonService<T, T1> {
    /**
     * Hammasini olish
     * @return Entity list
     * */
    public Page<T> getAll(Pageable pageable);
    public T getById(T1 id) throws Exception;
    public T create(T data) throws Exception;
    public T update(T data) throws Exception;
    public void delete(T data);
    public void deleteById(T1 id);
}
