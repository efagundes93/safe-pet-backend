package org.trainning.safepetbackend.maper;

import org.trainning.safepetbackend.api.request.AtualizarAnimalRequest;
import org.trainning.safepetbackend.api.request.CadastrarAnimalRequest;
import org.trainning.safepetbackend.api.response.CadastrarAnimalResponse;
import org.trainning.safepetbackend.domain.Animal;

public class AnimalMapper {
    public static Animal map(CadastrarAnimalRequest cadastrarAnimalRequest){
        Animal animal = new Animal();
        animal.setCor(cadastrarAnimalRequest.getCor());
        animal.setNome(cadastrarAnimalRequest.getNome());
        animal.setEspecie(cadastrarAnimalRequest.getEspecie());
        animal.setRaca(cadastrarAnimalRequest.getRaca());
        animal.setDataNascimento(cadastrarAnimalRequest.getDataNascimento());
        animal.setPorte(cadastrarAnimalRequest.getPorte());
        return animal;
    }

    public static Animal map(AtualizarAnimalRequest atualizarAnimalRequest){
        Animal animal = new Animal();
        animal.setId(atualizarAnimalRequest.getId());
        animal.setCor(atualizarAnimalRequest.getCor());
        animal.setNome(atualizarAnimalRequest.getNome());
        animal.setEspecie(atualizarAnimalRequest.getEspecie());
        animal.setRaca(atualizarAnimalRequest.getRaca());
        animal.setDataNascimento(atualizarAnimalRequest.getDataNascimento());
        animal.setPorte(atualizarAnimalRequest.getPorte());
        return animal;
    }
    public static CadastrarAnimalResponse map(Animal animal){
        CadastrarAnimalResponse cadastrarAnimalResponse = new CadastrarAnimalResponse();
        cadastrarAnimalResponse.setId(animal.getId());
        return cadastrarAnimalResponse;
    }
}
