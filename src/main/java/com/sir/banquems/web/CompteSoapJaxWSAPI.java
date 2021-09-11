package com.sir.banquems.web;

import com.sir.banquems.entities.Compte;
import com.sir.banquems.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Component
@WebService(serviceName = "BanqueWS")
public class CompteSoapJaxWSAPI {
    @Autowired
    private CompteRepository compteRepository;

    @WebMethod
    public List<Compte> compteList() {
        return compteRepository.findAll();
    }


    @WebMethod
    public Compte getOne(@WebParam(name = "id") Long id) {
        return compteRepository.findById(id).get();
    }


    @WebMethod
    public Compte saveOne(Compte compte) {
        return compteRepository.save(compte);
    }


    @WebMethod
    public Compte updateOne(Compte compte, @WebParam(name = "id") Long id) {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @WebMethod
    public void updateOne(@WebParam(name = "id") Long id) {
        compteRepository.deleteById(id);
    }
}
