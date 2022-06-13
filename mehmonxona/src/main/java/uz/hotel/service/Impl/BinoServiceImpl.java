package uz.hotel.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.hotel.entity.Bino;
import uz.hotel.repository.BinoRepository;
import uz.hotel.service.BinoService;
@Service
public class BinoServiceImpl implements BinoService {
    @Autowired
    BinoRepository br;


    @Override
    public Page<Bino> getAll(Pageable pageable) {
        return br.findAll(pageable);
    }

    @Override
    public Bino getById(Long id) throws Exception {
        return br.findById(id).get();
    }

    @Override
    public Bino create(Bino data) throws Exception {
       if (data.getId()==null)
           try{
              return br.save(data);
           }catch (Exception e){
               throw new Exception("Xatolik ro'y berdi!");
           }
       throw new Exception("id null ga teng bo'lmasligi kerak");
    }

    @Override
    public Bino update(Bino data) throws Exception {
        if (data.getId()!=null)
            try{
                return br.save(data);
            }catch (Exception e){
                throw new Exception("Xatolik ro'y berdi!");
            }
        throw new Exception("id null bo'lmasligi kerak");
    }

    @Override
    public void delete(Bino data) {
        br.delete(data);
    }

    @Override
    public void deleteById(Long id) {
      br.deleteById(id);
    }
}
