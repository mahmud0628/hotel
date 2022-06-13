package uz.hotel.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hotel.entity.Xona;
import uz.hotel.service.XonaService;

import java.util.List;


@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/xona")
public class XonaController {

    @Autowired
    XonaService xonaService;


    Logger logger= (Logger) LoggerFactory.getLogger(XonaController.class.getName());

    @GetMapping()
    public ResponseEntity<Page<Xona>> getAll(Pageable pageable){

        return ResponseEntity.ok(xonaService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Xona> getById(@PathVariable Long id)throws Exception{
        try {
            return ResponseEntity.ok(xonaService.getById(id));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Xona xona)throws Exception{
        try{
            return new ResponseEntity<>(xonaService.create(xona), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Xona xona)throws Exception {
        try {
            return new ResponseEntity<>(xonaService.update(xona), HttpStatus.CREATED);
        } catch (Exception e) {

            throw  new Exception("Update bulmadi");
        }

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        xonaService.deleteById(id);
    }
    


}
