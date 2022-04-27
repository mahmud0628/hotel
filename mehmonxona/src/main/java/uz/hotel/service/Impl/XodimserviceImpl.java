package uz.hotel.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.hotel.entity.Xodim;
import uz.hotel.repository.XodimRepository;
import uz.hotel.service.XodimService;
@Service
public class XodimserviceImpl implements XodimService {

    @Autowired
    XodimRepository xr;
    @Override
    public Page<Xodim> getAll(Pageable pageable) {
        return xr.findAll(pageable);
    }

    @Override
    public Xodim getById(Long id) throws Exception {
        return xr.findById(id).get();
    }

    @Override
    public Xodim create(Xodim data) throws Exception {
        if (data.getId()==null)
            try {
                return xr.save(data);
            }catch (Exception e){
                throw new Exception("Xatolik ruy berdi!");
            }
        throw new Exception("id null bulishi kerak");
    }

    @Override
    public Xodim update(Xodim data) throws Exception {
        if (data.getId()!=null)
            try {
                return xr.save(data);
            }catch (Exception e){
                throw new Exception("Xatolik ruy berdi!");
            }
        throw new Exception("id null bulmasligi kerak!");
    }

    @Override
    public void delete(Xodim data) {
       xr.delete(data);
    }

    @Override
    public void deleteById(Long id) {
      xr.deleteById(id);
    }

}
