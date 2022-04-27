package uz.hotel.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hotel.entity.Lovozim;
import uz.hotel.entity.Mijoz;
import uz.hotel.service.LovozimService;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/lovozim")

public class LovozimController {

    @Autowired
    LovozimService ls;

    Logger logger= (Logger) LoggerFactory.getLogger(LovozimController.class.getName());

    @GetMapping()
    public ResponseEntity<List<Lovozim>> getAll(Pageable pageable){
        return ResponseEntity.ok(ls.getAll(pageable).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lovozim> getById(@PathVariable Long id)throws Exception{
        try {
            return ResponseEntity.ok(ls.getById(id));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Lovozim lovozim)throws Exception{
        try{
            return new ResponseEntity<>(ls.create(lovozim), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Lovozim lovozim)throws Exception {
        try {
            return new ResponseEntity<>(ls.update(lovozim), HttpStatus.CREATED);
        } catch (Exception e) {

            throw  new Exception("Update bulmadi");
        }

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        ls.deleteById(id);
    }





}
