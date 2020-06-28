package uebung_12_1.variant_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import uebung_12_1.base.ControlConstants;
import uebung_12_1.base.MyItem;
import uebung_12_1.base.StorageBase;

public class LockStorage extends StorageBase implements ControlConstants {
	
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	private LockStorage() {

	}
	
	public static LockStorage getInstance() {
		if(storageObject == null) {
			storageObject = new LockStorage();
		}
		return (LockStorage) storageObject;
	}

	public void deliver(MyItem item, String name) {
		lock.lock();
		try {
			while (storage.size() >= MAX_STORAGE_SIZE) {
				System.out.println("Lager ist voll, bitte warten");
				notFull.await();
			}
			storage.add(item);
			System.out.println(item.toString() + " wurde von " + name + " eingelagert");
			notEmpty.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}

	}

	public void fetch(int position, String name) {
		lock.lock();
		try {
			while (storage.size() == 0) {
				System.out.println("Lager ist leer, bitte warten");
				notEmpty.await();
			}
			
			MyItem fetchedItem = storage.remove(position);
			System.out.println(fetchedItem.toString() + " wurde von " + name + " abgeholt");
			notFull.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
	public int getStorageCount() {
		return storage.size();
	}

}
