package uz.hotel.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.hotel.entity.Xona;
import uz.hotel.repository.XonaRepository;
import uz.hotel.service.XonaService;
@Service
public class XonaServiceImpl implements XonaService {

    @Autowired
    XonaRepository xr;

    @Override
    public Page<Xona> getAll(Pageable pageable) {
        return xr.findAll(pageable);
    }

    @Override
    public Xona getById(Long id) throws Exception {
        return xr.findById(id).get();
    }

    @Override
    public Xona create(Xona data) throws Exception {
        if (data.getId()==null)
            try{
                return xr.save(data);
            }catch (Exception ex){
                System.out.printf("yaratib bulmadi xatolik!");
            }
        throw new Exception("id null bulish kerak");
    }

    @Override
    public Xona update(Xona data) throws Exception {
        if (data.getId()!=null)
            try{
                return xr.save(data);
            }catch (Exception ex){
                System.out.printf("xatolik: yangilashda muammo bor!");
            }
            throw new Exception("id null ga teng bulmasligi kerak");
    }

    @Override
    public void delete(Xona data) {
       xr.delete(data);
    }

    @Override
    public void deleteById(Long id) {
      xr.deleteById(id);
    }
}
