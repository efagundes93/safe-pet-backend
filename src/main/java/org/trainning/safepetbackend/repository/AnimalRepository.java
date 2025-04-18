package org.trainning.safepetbackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.trainning.safepetbackend.domain.Animal;

@Repository
public interface AnimalRepository extends MongoRepository<Animal, String> , AnimalRepositoryCustom{

}
