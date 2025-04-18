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

    /**
     * Método que vai permitir ao cliente (quem chama) solicitar o cadastro (insersão no bd) de um
     * novo registro de "animal"
     * @param cadastrarAnimalRequest
     * @return o identificador do animal salvo
     */
    @PostMapping
    public CadastrarAnimalResponse cadastrar(@RequestBody @Valid CadastrarAnimalRequest cadastrarAnimalRequest){
        Animal animal = AnimalMapper.map(cadastrarAnimalRequest);
        animal = animalService.cadastrar(animal);
        return AnimalMapper.map(animal);
    }

    /**
     * Permite ao cliente deletar o registro de um animal
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        animalService.deletarPorId(id);
    }

    /**
     * Permite solicitar a atualização parcial de um registro existente
     * @param atualizarAnimalRequest
     * @return
     */
    @PatchMapping
    public ResponseEntity<?> atualizarEspecificamente(@RequestBody @Valid AtualizarAnimalRequest atualizarAnimalRequest){
        try{
            Animal animal = AnimalMapper.map(atualizarAnimalRequest);
            animalService.atualizarEspecificamente(animal);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }  catch (AnimalNaoEncontradoException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Permite atualizar o registro na totalidade
     * @param atualizarAnimalRequest
     * @return
     */
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

    /**
     * Permite buscar os dados de um registro por id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable String id){
        try{
            return new ResponseEntity<Animal>(animalService.buscarPorId(id), HttpStatus.OK);
        } catch (AnimalNaoEncontradoException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retorna a lista de animais registrados na base de dados
     * @return
     */
    @GetMapping
    public List<Animal> buscarTodos(){
        return animalService.buscarTodos();
    }
}
