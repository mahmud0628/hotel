package uz.hotel.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hotel.entity.Bino;
import uz.hotel.entity.Tulov;
import uz.hotel.service.TulovService;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/tulov")
public class TulovController {

    @Autowired
    TulovService tulovServicel;


    Logger logger= (Logger) LoggerFactory.getLogger(TulovController.class.getName());

    @GetMapping()
    public ResponseEntity<List<Tulov>> getAll(Pageable pageable){

        return ResponseEntity.ok(tulovServicel.getAll(pageable).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tulov> getById(@PathVariable Long id)throws Exception{
        try {
            return ResponseEntity.ok(tulovServicel.getById(id));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Tulov tulov)throws Exception{
        try{
            return new ResponseEntity<>(tulovServicel.create(tulov), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Tulov tulov)throws Exception {
        try {
            return new ResponseEntity<>(tulovServicel.update(tulov), HttpStatus.CREATED);
        } catch (Exception e) {

            throw  new Exception("Update bulmadi");
        }

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        tulovServicel.deleteById(id);
    }
}
