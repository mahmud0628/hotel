package uz.hotel.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hotel.entity.Bino;
import uz.hotel.service.BinoService;

import java.util.List;


@RestController
@RequestMapping("/api/bino")
@CrossOrigin(maxAge = 3600)
public class BinoController {

    @Autowired
    BinoService binoService;

    Logger logger= (Logger) LoggerFactory.getLogger(BinoController.class.getName());

    @GetMapping()
    public ResponseEntity<List<Bino>> getAll(Pageable pageable){

        return ResponseEntity.ok(binoService.getAll(pageable).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bino> getById(@PathVariable Long id)throws Exception{
        try {
            return ResponseEntity.ok(binoService.getById(id));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Bino bino)throws Exception{
        try{
            return new ResponseEntity<>(binoService.create(bino), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Bino bino)throws Exception {
        try {
            return new ResponseEntity<>(binoService.update(bino), HttpStatus.CREATED);
        } catch (Exception e) {

            throw  new Exception("Update bulmadi");
        }

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        binoService.deleteById(id);
    }



}
