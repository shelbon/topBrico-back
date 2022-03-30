package ma.topbackend.topbrico.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ma.topbackend.topbrico.Dto.ArtisanDTO;
import ma.topbackend.topbrico.dao.*;
import ma.topbackend.topbrico.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/artisans")
public class ArtisanController {


    ArtisanRepository artisanRepository;


    VilleRepository villeRepository;


    ServiceArtRepository serviceArtRepository;


    RealisationRepository realisationRepository;


    PhotoRepository photoRepository;
    @Autowired
    public ArtisanController(ArtisanRepository artisanRepository, VilleRepository villeRepository, ServiceArtRepository serviceArtRepository, RealisationRepository realisationRepository, PhotoRepository photoRepository) {
        this.artisanRepository = artisanRepository;
        this.villeRepository = villeRepository;
        this.serviceArtRepository = serviceArtRepository;
        this.realisationRepository = realisationRepository;
        this.photoRepository = photoRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Artisan> getAllArtisan() {
       return artisanRepository.findAll();
    }

    @PostMapping
    public Artisan saveArtisan(@RequestBody ArtisanDTO artisan,HttpServletRequest request) {
//      Ville ville= villeRepository.findByNomVille(artisan.getVille());

        Artisan newArtisan= new Artisan();
//        newArtisan.setVille(ville);
//     Collection<Realisation> realisations= artisan.getRealisations();
//        MultipartFile file = artisan.getPhoto();
//        if(!file.isEmpty()) {
//            System.out.println("Nom du champ     : "+file.getName());
//            System.out.println("Nom du fichier   : "+file.getOriginalFilename());
//            System.out.println("Type de fichier  : "+file.getContentType());
//            System.out.println("Taille en octets : "+file.getSize());
//        }
//     realisations.forEach(realisation -> photoRepository.saveAll(realisation.getPhoto()));
//      List<Realisation> real=realisationRepository.saveAll(realisations);
//      List<ServiceArt> listeServices=  artisan.getServiceArt().stream().map(serviceArt -> serviceArtRepository.findByNomService(serviceArt.getNomService())).map(serviceArt -> {serviceArt.setRealisation(real); serviceArt.setArtisans(List.of(artisan)); return serviceArt; }).collect(Collectors.toList());

//     artisan.setServiceArt(listeServices );

        return artisanRepository.save(newArtisan);
    }

}