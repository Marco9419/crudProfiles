package com.swift.controller;

import com.swift.exception.ResourceNotFoundException;
import com.swift.model.ProfilesModel;
import com.swift.repository.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/profiles")
public class ProfilesController {

    @Autowired
    private ProfilesRepository profilesRepository;

    //Obtener todos los perfiles
    @RequestMapping(value="/getProfiles", method = RequestMethod.GET)
    public List<ProfilesModel> getProfiles(){
        return profilesRepository.findAll();
    }


    //Insertar un perfil
    @RequestMapping(value = "/newProfile", method = RequestMethod.POST)
    public ProfilesModel addProfile(@RequestBody ProfilesModel profilesModel){
        return profilesRepository.save(profilesModel);
    }

    //Eliminacion de Perfil
    @DeleteMapping("/delProfile/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePerfil(@PathVariable Long id){
        ProfilesModel profilesModel = profilesRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El perfil con id " + " no existe"));

        profilesRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        return ResponseEntity.ok(response);
    }

    //Update Profile
    @PutMapping("/getProfiles/{id}")
    public ResponseEntity<ProfilesModel> updateProfile(@PathVariable Long id, @RequestBody ProfilesModel profilesModel){
        ProfilesModel model = profilesRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("El perfil con el id " + " no existe"));

        model.setNombre(profilesModel.getNombre());
        model.setUsuario(profilesModel.getUsuario());
        model.setPerfil(profilesModel.getPerfil());

        ProfilesModel update = profilesRepository.save(model);

        return ResponseEntity.ok(update);
    }

}
