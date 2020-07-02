package uebung_12_2;

public class Main {

	public static void main(String[] args) {
		int exponent = 19;

		int i = 3;

		//Creating 8 new Thread. Every single one is dead, because we did not start it.
		Primzahltest p1 = new Primzahltest(0);
		Primzahltest p2 = new Primzahltest(0);
		Primzahltest p3 = new Primzahltest(0);
		Primzahltest p4 = new Primzahltest(0);
		Primzahltest p5 = new Primzahltest(0);
		Primzahltest p6 = new Primzahltest(0);
		Primzahltest p7 = new Primzahltest(0);
		Primzahltest p8 = new Primzahltest(0);

		//If one of our threads has done its job, it dies. So if the thread is not alive anymore, we can create a new one with a new number to test.
		while (true) {
			if (!p1.isAlive()) {
				p1 = new Primzahltest(i);
				p1.start();
				i++;
				if (stop(i, exponent)) {
					break;
				}
			}
			if (!p2.isAlive()) {
				p2 = new Primzahltest(i);
				p2.start();
				i++;
				if (stop(i, exponent)) {
					break;
				}
			}
			if (!p3.isAlive()) {
				p3 = new Primzahltest(i);
				p3.start();
				i++;
				if (stop(i, exponent)) {
					break;
				}
			}
			if (!p4.isAlive()) {
				p4 = new Primzahltest(i);
				p4.start();
				i++;
				if (stop(i, exponent)) {
					break;
				}
			}
			if (!p5.isAlive()) {
				p5 = new Primzahltest(i);
				p5.start();
				i++;
				if (stop(i, exponent)) {
					break;
				}
			}
			if (!p6.isAlive()) {
				p6 = new Primzahltest(i);
				p6.start();
				i++;
				if (stop(i, exponent)) {
					break;
				}
			}
			if (!p7.isAlive()) {
				p7 = new Primzahltest(i);
				p7.start();
				i++;
				if (stop(i, exponent)) {
					break;
				}
			}
			if (!p8.isAlive()) {
				p8 = new Primzahltest(i);
				p8.start();
				i++;
				if (stop(i, exponent)) {
					break;
				}
			}
		}

		//wait for all running threads before we end the programm
		try {
			p1.join();
			p2.join();
			p3.join();
			p4.join();
			p5.join();
			p6.join();
			p7.join();
			p8.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//If the maximum exponent is reached, we want to break the while-loop
	private static boolean stop(int index, int exponent) {
		if (index > exponent) {
			return true;
		}
		return false;
	}
}
