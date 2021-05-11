package HW27_04;

class MyThread implements Runnable {
	private int id;

	public MyThread(int id) {
		this.id = id;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			System.out.println("Thread ID=" + id);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread worker1 = new Thread(new MyThread(1));
		Thread worker2 = new Thread(new MyThread(5));
		worker1.start();
		worker2.start();
	}
}