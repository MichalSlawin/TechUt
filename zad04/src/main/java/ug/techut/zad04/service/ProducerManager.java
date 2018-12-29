package ug.techut.zad04.service;

import ug.techut.zad04.domain.Producer;

import java.util.List;

public interface ProducerManager {
    void addProducer(Producer producer);
    void deleteProducer(Producer producer);

    List<Producer> getAllProducers();
    Producer getProducer(Long id);
    Producer getProducer(String name);
}
