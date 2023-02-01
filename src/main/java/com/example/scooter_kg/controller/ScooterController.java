package com.example.scooter_kg.controller;


import com.example.scooter_kg.entity.Scooter;
import com.example.scooter_kg.entity.enums.Role;
import com.example.scooter_kg.exception_handling.NoSuchScooterException;
import com.example.scooter_kg.service.ScooterService;
import com.example.scooter_kg.util.MethodUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ScooterController {

    private ScooterService scooterService;
    private final String imagePath = "./src/main/java/resources/qrcodes/QrCode.jpg";

    @Autowired
    public ScooterController(ScooterService scooterService) {
        this.scooterService = scooterService;
    }

    @GetMapping("/scooters")
    public List<Scooter> showAllScooters() {
        List<Scooter> allScooters = scooterService.getAllScooters();

        return allScooters;
    }

    @GetMapping("/scooters/{id}")   //получаем id из самого url адреса
    public Optional<Scooter> getEmployee(@PathVariable int id) {
        Optional<Scooter> scooter = scooterService.findById(id);

        if(scooter == null) {
            throw  new NoSuchScooterException("There is no scooter with id: "+ id + " in DB");
        }

        return scooter;
    }

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping("/scooters/add")
    public Scooter addNewEmployee(@RequestBody Scooter scooter) {
        scooterService.saveScooter(scooter);

        return scooter;
    }

    @PutMapping("/scooters/update")
    public Scooter updateScooter(@RequestBody Scooter scooter) {
        scooterService.saveScooter(scooter);

        return scooter;
    }

    @DeleteMapping("/scooters/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Optional<Scooter> scooter = scooterService.findById(id);

        if(scooter == null) {
            throw new NoSuchScooterException("There is no scooter with ID = " + id + " in DataBase");
        }

        scooterService.deleteScooter(id);
        return "Scooter with ID = " + id + " was deleted";
    }

//    @GetMapping("/generateByteQRCode/{id}")
//    public ResponseEntity<Scooter> generateByteQRCode(@PathVariable("id") int id) {
//        Scooter scooterObject = null;
//        Optional<Scooter> scooter = scooterService.findById(id);
//        if (!scooter.isPresent()) {
//            throw new NoSuchScooterException("Scooter not found");
//        } else {
//            scooterObject = scooter.get();
//            scooterObject.setQr_code(MethodUtils.generateByteQRCode(scooterObject.getImage(), 250, 250));
//            scooterObject.add(linkTo(methodOn(ScooterController.class).showAllScooters()).withSelfRel());
//        }
//        return new ResponseEntity<>(scooterObject, HttpStatus.OK);
//    }

    @GetMapping("/generate-image-qr-code/{id}")
    public ResponseEntity<Scooter> generateImageQrCode(@PathVariable("id") int id) {
        Scooter scooterObject = null;
        Optional<Scooter> scooter = scooterService.findById(id);
        if(!scooter.isPresent()) {
            throw new NoSuchScooterException("Scooter not found");
        }else {
            scooterObject = scooter.get();
            MethodUtils.generateImageQrCode(scooterObject.getImage(), 250, 250, imagePath);
            scooterObject.add(linkTo(methodOn(ScooterController.class).showAllScooters()).withSelfRel());
        }
        return new ResponseEntity<>(scooterObject, HttpStatus.OK);
    }
}
