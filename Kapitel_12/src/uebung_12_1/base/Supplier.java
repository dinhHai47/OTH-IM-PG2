package uebung_12_1.base;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Supplier implements Runnable, ControlConstants {
	StorageBase storage;
	String name;

	public Supplier(StorageBase storage, String name) {
		this.storage = storage;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Random random = new Random();
				MyItem item = new MyItem(random.nextInt(4000000), "An Item");
				this.storage.deliver(item, this.name);
				TimeUnit.MILLISECONDS.sleep(random.nextInt(2000) + 1 + MIN_DELIVER_TIME);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
