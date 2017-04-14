package cn.network.demo;

public class MouseByUSB implements USB {


	@Override
	public void open() {
		System.out.println("mouse open");
	}

	/* (non-Javadoc)
	 * @see cn.network.demo.USB#close()
	 */
	@Override
	public void close() {
		System.out.println("mouse close");
	}
	
}
