package uz.hotel.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hotel.entity.Xodim;
import uz.hotel.service.XodimService;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/xodim")
public class XodimController {
    @Autowired
    XodimService xs;

    Logger logger= (Logger) LoggerFactory.getLogger(XodimController.class.getName());

    @GetMapping()
    public ResponseEntity<Page<Xodim>> getAll(Pageable pageable){

        return ResponseEntity.ok(xs.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Xodim> getById(@PathVariable Long id)throws Exception{
        try {
            return ResponseEntity.ok(xs.getById(id));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Xodim xodim)throws Exception{
        try{
            return new ResponseEntity<>(xs.create(xodim), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Xodim xodim)throws Exception {
        try {
            return new ResponseEntity<>(xs.update(xodim), HttpStatus.CREATED);
        } catch (Exception e) {

            throw  new Exception("Update bulmadi");
        }

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        xs.deleteById(id);
    }


}
