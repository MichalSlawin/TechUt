package ug.techut.zad04.service;

import ug.techut.zad04.domain.Lock;

import java.util.List;

public interface LockManager {
    void addLock(Lock lock);
    void deleteLock(Lock lock);
    void updateLock(Lock lock);

    List<Lock> getAllLocks();
    Lock getLock(Long id);
}
