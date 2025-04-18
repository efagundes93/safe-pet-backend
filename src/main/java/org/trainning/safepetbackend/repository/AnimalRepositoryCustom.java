package org.trainning.safepetbackend.repository;

import org.trainning.safepetbackend.domain.Animal;

public interface AnimalRepositoryCustom {
    Animal updateByExample(Animal animal);
}
