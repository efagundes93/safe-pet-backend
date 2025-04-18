package org.trainning.safepetbackend.repository;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.trainning.safepetbackend.domain.Animal;

public class AnimalRepositoryCustomImpl implements AnimalRepositoryCustom {
    private final MongoTemplate mongoTemplate;

    public AnimalRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Método criado para realizar a atualização dos dados de animais na base
     * seguindo o intuito de não sobrescrever o que ja está na base.
     *
     * @param animal
     * @return
     */
    @Override
    public Animal updateByExample(Animal animal) {
        Update update = new Update();

        if(animal.getCor() != null){
            update.set("cor", animal.getCor());
        }

        if(animal.getEspecie() != null){
            update.set("especie", animal.getEspecie());
        }


        if(animal.getPorte() != null){
            update.set("porte", animal.getPorte());
        }


        if(animal.getRaca() != null){
            update.set("raca", animal.getRaca());
        }

        Query query = new Query(Criteria.where("id").is(animal.getId()));
        return mongoTemplate.findAndModify(query, update, Animal.class);
    }
}
