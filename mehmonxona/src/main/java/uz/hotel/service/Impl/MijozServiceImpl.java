package uz.hotel.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.hotel.entity.Mijoz;
import uz.hotel.repository.MijozRepository;
import uz.hotel.service.MijozService;

@Service

public class MijozServiceImpl implements MijozService {

    @Autowired
    MijozRepository mjr;
    @Override
    public Page<Mijoz> getAll(Pageable pageable) {
        return mjr.findAll(pageable);
    }

    @Override
    public Mijoz getById(Long id) throws Exception {
        return mjr.findById(id).get();
    }

    @Override
    public Mijoz create(Mijoz data) throws Exception {
        if (data.getId()==null)
            try{
            return mjr.save(data);
        }catch (Exception ex){
                throw  new Exception("Bunday nom mavjud!");
            }
        throw new Exception("id null bo'lishi  kerak!");
    }

    @Override
    public Mijoz update(Mijoz data) throws Exception {
        if (data.getId() != null)
            try{
                return mjr.save(data);
            }catch (Exception ex){
                throw new Exception("xato");
            }
        throw new Exception("id null bo'lmasligi kerak");
    }

    @Override
    public void delete(Mijoz data) {
      mjr.delete(data);
    }

    @Override
    public void deleteById(Long id) {
     mjr.deleteById(id);
    }
}
