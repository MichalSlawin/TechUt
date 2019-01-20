package ug.techut.zad04.service;

import ug.techut.zad04.domain.Handles;

import java.util.List;

public interface HandlesManager {
    void addHandles(Handles handles);
    void deleteHandles(Handles handles);
    void updateHandles(Handles handles);

    List<Handles> getAllHandles();
    List<Handles> getHandles(String shape);
    Handles getHandles(Long id);
}
