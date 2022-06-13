package uz.hotel.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.hotel.entity.Tulov;
import uz.hotel.repository.TulovRepository;
import uz.hotel.service.TulovService;

@Service
public class TulovServiceImpl implements TulovService {

    @Autowired
    TulovRepository tr;

    @Override
    public Page<Tulov> getAll(Pageable pageable) {
        return tr.findAll(pageable);
    }

    @Override
    public Tulov getById(Long id) throws Exception {
        return tr.findById(id).get();
    }

    @Override
    public Tulov create(Tulov data) throws Exception {
        if (data.getId() == null)
            try {
                return tr.save(data);
            } catch (Exception ex) {
                System.out.printf("xatolik: yangilashda muommo bor!");
            }
        throw new Exception("id null ga teng bulmasligi kerak");
    }

    @Override
    public Tulov update(Tulov data) throws Exception {
        if (data.getId() != null)
            try {
                return tr.save(data);
            } catch (Exception ex) {
                System.out.printf("xatolik: yangilashda muommo bor!");
            }
        throw new Exception("id null ga teng bulmasligi kerak");
    }

    @Override
    public void delete(Tulov data) {
       tr.delete(data);
    }

    @Override
    public void deleteById(Long id) {
       tr.deleteById(id);
    }
}
