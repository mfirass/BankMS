package com.sir.banquems.web;

import com.sir.banquems.entities.Compte;
import com.sir.banquems.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import java.util.List;

//@RestController
@RequestMapping("/banque")
public class CompteRestController {
    @Autowired
    private CompteRepository compteRepository;
    @GetMapping(path = "/comptes", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }


    @GetMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Compte getOne(@PathVariable Long id){
        return compteRepository.findById(id).get();
    }

    @PostMapping(path = "/comptes", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Compte saveOne(@RequestBody Compte compte){
        return compteRepository.save(compte);
    }

    @PutMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Compte updateOne(@RequestBody Compte compte,@PathVariable Long id){
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public void updateOne(@PathVariable Long id){
        compteRepository.deleteById(id);
    }
}
