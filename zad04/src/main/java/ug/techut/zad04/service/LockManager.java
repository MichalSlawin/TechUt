package ug.techut.zad04.service;

import ug.techut.zad04.domain.Lock;
import ug.techut.zad04.domain.Producer;

import java.util.List;

public interface LockManager {
    void addLock(Lock lock);
    void deleteLock(Lock lock);
    void updateLock(Lock lock);

    List<Lock> getAllLocks();
    List<Lock> getLocks(boolean electronic);
    List<Lock> getLocks(Producer producer);
    Lock getLock(Long id);
}
