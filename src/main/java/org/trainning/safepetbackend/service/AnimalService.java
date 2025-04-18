package org.trainning.safepetbackend.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.trainning.safepetbackend.domain.Animal;
import org.trainning.safepetbackend.exception.AnimalNaoEncontradoException;
import org.trainning.safepetbackend.repository.AnimalRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal buscarPorId(String id){
        return animalRepository.findById(id)
                .orElseThrow(AnimalNaoEncontradoException::new);
    }
    public Animal cadastrar(@Valid Animal animal){
        animal.setCadastradoEm(LocalDateTime.now());
        return this.animalRepository.save(animal);
    }

    public List<Animal> buscarTodos(){
        return this.animalRepository.findAll();
    }

    public void atualizar(Animal animal) {

        Animal animalBD = animalRepository.findById(animal.getId())
                .orElseThrow(AnimalNaoEncontradoException::new);
        animal.setCadastradoEm(animalBD.getCadastradoEm());
        this.animalRepository.save(animal);
    }

    public void atualizarEspecificamente(Animal animal){
       Animal updatedAnimal =  this.animalRepository.updateByExample(animal);
       if(null == updatedAnimal) throw new AnimalNaoEncontradoException();
    }

    public void deletarPorId(String id) {
        animalRepository.deleteById(id);
    }
}
