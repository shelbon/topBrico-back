package ma.topbackend.topbrico.controller;

import ma.topbackend.topbrico.Dto.ArtisanDTO;
import ma.topbackend.topbrico.dao.*;
import ma.topbackend.topbrico.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/artisans")
public class ArtisanController {

    @Autowired
    ArtisanRepository artisanRepository;

    @Autowired
    VilleRepository villeRepository;

    @Autowired
    ServiceArtRepository serviceArtRepository;

    @Autowired
    RealisationRepository realisationRepository;

    @Autowired
    PhotoRepository photoRepository;



    @RequestMapping(method = RequestMethod.GET)
    List<Artisan> getAllArtisan() {
       return artisanRepository.findAll();
    }

    @PostMapping
    public Artisan saveArtisan(@ModelAttribute(name="artisanForm") ArtisanDTO artisan,HttpServletRequest request) {

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
