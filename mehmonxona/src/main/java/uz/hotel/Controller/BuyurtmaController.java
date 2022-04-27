package uz.hotel.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.hotel.entity.Buyurtma;
import uz.hotel.service.BuyurtmaService;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("/api/buyurtma")
public class BuyurtmaController {
    @Autowired
    BuyurtmaService bs;

    Logger logger= (Logger) LoggerFactory.getLogger(BuyurtmaController.class.getName());

    @GetMapping()
    public ResponseEntity<List<Buyurtma>> getAll(Pageable pageable){
        return ResponseEntity.ok(bs.getAll(pageable).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buyurtma> getById(@PathVariable Long id)throws Exception{
        try {
            return ResponseEntity.ok(bs.getById(id));
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Buyurtma buyurtma)throws Exception{
        try{
            return new ResponseEntity<>(bs.create(buyurtma), HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Buyurtma buyurtma)throws Exception {
        try {
            return new ResponseEntity<>(bs.update(buyurtma), HttpStatus.CREATED);
        } catch (Exception e) {

            throw  new Exception("Update bulmadi");
        }

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        bs.deleteById(id);
    }



}
