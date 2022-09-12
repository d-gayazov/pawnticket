package my.app.site.controllers;

import my.app.site.models.PawnTicket;
import my.app.site.service.PawnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private final PawnService pawnService;


    @Autowired
    public MainController(PawnService pawnService) {
        this.pawnService = pawnService;
    }

    //правом создавать залоговый билет обладает и пользователь со статусом ADMIN, и пользователь со статусом USER
    @PostMapping(value = "/tickets")
    public ResponseEntity<?> create(@RequestBody PawnTicket pawnTicket){
        pawnService.create(pawnTicket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //правом получать инфо о всех залоговых билетах обладает и пользователь со статусом ADMIN, и пользователь со статусом USER
    @GetMapping(value = "tickets")
    public ResponseEntity<List<PawnTicket>> readAll(){
        final List<PawnTicket> pawnTickets = pawnService.readAll();
        return pawnTickets != null && !pawnTickets.isEmpty() ?
                new ResponseEntity<>(pawnTickets,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //правом получать инфо о конкретном залоговом билете обладает и пользователь со статусом ADMIN, и пользователь со статусом USER
    @GetMapping(value = "/tickets/{id}")
    public ResponseEntity<PawnTicket>read(@PathVariable(name="id") int id){
        final PawnTicket pawnTicket = pawnService.read(id);
        return pawnTicket != null ?
                new ResponseEntity<>(pawnTicket,HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //правом вносить изменения в залоговый билет, в т.ч. ПРОЛОНГИРОВАТЬ (выставлять большее количество дней пользования
    // деньгами за залог) обладает только пользователь со статусом ADMIN
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "/tickets/{id}")
    public ResponseEntity<?>update(@PathVariable(name="id") int id, @RequestBody PawnTicket pawnTicket){

        final boolean isUpdate = pawnService.update(id,pawnTicket);

        return isUpdate ?
                new ResponseEntity<>(HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    //правом удалять залоговый билет обладает только пользователь со статусом ADMIN
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping(value = "/tickets/{id}")
    public ResponseEntity<?>delete(@PathVariable(name="id") int id){
        final boolean isDelete = pawnService.delete(id);
        return isDelete ?
                new ResponseEntity<>(HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
