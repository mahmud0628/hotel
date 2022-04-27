package uz.hotel.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.hotel.entity.Lovozim;
import uz.hotel.repository.LovozimRepository;
import uz.hotel.service.LovozimService;

import java.util.List;

@Service

public class LovozimServiceImpl implements LovozimService {

    @Autowired
    LovozimRepository lr;

    @Override
    public Page<Lovozim> getAll(Pageable pageable) {
        return lr.findAll(pageable);
    }

    @Override
    public Lovozim getById(Long id) throws Exception {
        return lr.findById(id).get();
    }

    @Override
    public Lovozim create(Lovozim data) throws Exception {
        if (data.getId()==null)
        try {
       return lr.save(data);
        }catch (Exception e){
            throw  new Exception("Xatolik ruy berdi");
        }
        throw  new Exception("id nullga teng bulishi kerak!");

    }

    @Override
    public Lovozim update(Lovozim data) throws Exception {
        if (data.getId()!=null)
        try {
            return lr.save(data);
        }catch (Exception e){
            throw  new Exception("Xatolik ruy berdi");
        }
        throw  new Exception("id nullga teng bulmaligi kerak!");
    }

    @Override
    public void delete(Lovozim data) {
   lr.delete(data);
    }

    @Override
    public void deleteById(Long id) {
     lr.deleteById(id);
    }
}
