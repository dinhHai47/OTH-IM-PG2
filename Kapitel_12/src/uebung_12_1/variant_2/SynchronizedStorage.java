package uebung_12_1.variant_2;

import uebung_12_1.base.ControlConstants;
import uebung_12_1.base.MyItem;
import uebung_12_1.base.StorageBase;
import uebung_12_1.variant_2.SynchronizedStorage;

public class SynchronizedStorage extends StorageBase implements ControlConstants {

	private SynchronizedStorage() {

	}
	
	public static SynchronizedStorage getInstance() {
		if(storageObject == null) {
			storageObject = new SynchronizedStorage();
		}
		return (SynchronizedStorage) storageObject;
	}

	public synchronized void deliver(MyItem item, String name) {
		try {
			while (storage.size() >= MAX_STORAGE_SIZE) {
				System.out.println("Lager ist voll, bitte warten");
				wait();
			}
			storage.add(item);
			System.out.println(item.toString() + " wurde von " + name + " eingelagert");
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void fetch(int position, String name) {
		try {
			while (storage.size() == 0) {
				System.out.println("Lager ist leer, bitte warten");
				wait();
			}
			
			MyItem fetchedItem = storage.remove(position);
			System.out.println(fetchedItem.toString() + " wurde von " + name + " abgeholt");
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getStorageCount() {
		return storage.size();
	}

}
