package uz.hotel.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hotel.entity.Mijoz;
import uz.hotel.service.MijozService;
import uz.hotel.service.MijozService;
import uz.hotel.service.Impl.MijozServiceImpl;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/mijoz")
public class MijozController {

    @Autowired
    MijozService mijozService;

    Logger logger= (Logger) LoggerFactory.getLogger(MijozController.class.getName());

    @GetMapping()
    public ResponseEntity<Page<Mijoz>>getAll(Pageable pageable){
        return ResponseEntity.ok(mijozService.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mijoz> getById(@PathVariable Long id)throws Exception{
        try {
            return ResponseEntity.ok(mijozService.getById(id));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
       return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Mijoz mijoz)throws Exception{
      try{
          return new ResponseEntity<>(mijozService.create(mijoz), HttpStatus.CREATED);
      }catch (Exception e){
          return ResponseEntity.badRequest().build();
    }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Mijoz mijoz)throws Exception {
        try {
            return new ResponseEntity<>(mijozService.update(mijoz), HttpStatus.CREATED);
        } catch (Exception e) {

          throw  new Exception("Update bulmadi");
        }

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        mijozService.deleteById(id);
    }



}
