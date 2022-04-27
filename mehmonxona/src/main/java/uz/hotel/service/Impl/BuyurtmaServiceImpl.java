package uz.hotel.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.hotel.entity.Buyurtma;
import uz.hotel.repository.BuyurtmaRepository;
import uz.hotel.service.BuyurtmaService;
@Service
public class BuyurtmaServiceImpl implements BuyurtmaService {
    @Autowired
    BuyurtmaRepository br;

    @Override
    public Page<Buyurtma> getAll(Pageable pageable) {
        return br.findAll(pageable);
    }

    @Override
    public Buyurtma getById(Long id) throws Exception {
        return br.findById(id).get();
    }

    @Override
    public Buyurtma create(Buyurtma data) throws Exception {
        if (data.getId()==null)
        try {
            return br.save(data);
        }catch (Exception e){
            throw new Exception("xatolik ruy berdi!");
        }
        throw  new Exception("id null bulishi kerak!");
    }

    @Override
    public Buyurtma update(Buyurtma data) throws Exception {
        if (data.getId()!=null)
            try {
                return br.save(data);
            }catch (Exception e){
                throw new Exception("xatolik ruy berdi!");
            }
        throw  new Exception("id null bulishi kerak!");
    }

    @Override
    public void delete(Buyurtma data) {
   br.delete(data);
    }

    @Override
    public void deleteById(Long id) {
   br.deleteById(id);
    }
}
