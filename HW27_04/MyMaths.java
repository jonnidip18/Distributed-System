package HW27_04;

public class MyMaths implements Runnable{
	private int n;

	public MyMaths(int n) {
		this.n = n;
	}
	
	public int aMethod() {
		int result = 1;
		
		for (int i = 2; i <= n; i++) {
			result = result*i;
		}
		
		return result;
	}
	
	public void run() {
		int result = aMethod();
		System.out.println("Output is " + result);
	}

	public static void main(String[] args) {
		Thread worker = new Thread(new MyMaths(4));
		worker.start();
	}
}
