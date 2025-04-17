package org.trainning.safepetbackend.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.trainning.safepetbackend.api.request.AtualizarAnimalRequest;
import org.trainning.safepetbackend.api.request.CadastrarAnimalRequest;
import org.trainning.safepetbackend.api.response.CadastrarAnimalResponse;
import org.trainning.safepetbackend.domain.Animal;
import org.trainning.safepetbackend.exception.AnimalNaoEncontradoException;
import org.trainning.safepetbackend.maper.AnimalMapper;
import org.trainning.safepetbackend.service.AnimalService;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class AnimalApi {
    private final AnimalService animalService;

    public AnimalApi(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping
    public CadastrarAnimalResponse cadastrar(@RequestBody @Valid CadastrarAnimalRequest cadastrarAnimalRequest){
        Animal animal = AnimalMapper.map(cadastrarAnimalRequest);
        animal = animalService.cadastrar(animal);
        return AnimalMapper.map(animal);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        animalService.deletarPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> atualizar(@RequestBody @Valid AtualizarAnimalRequest atualizarAnimalRequest){
        try{
            Animal animal = AnimalMapper.map(atualizarAnimalRequest);
            animalService.atualizar(animal);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }  catch (AnimalNaoEncontradoException e){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable String id){
        try{
            return new ResponseEntity<Animal>(animalService.buscarPorId(id), HttpStatus.OK);
        } catch (AnimalNaoEncontradoException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Animal> buscarTodos(){
        return animalService.buscarTodos();
    }
}
