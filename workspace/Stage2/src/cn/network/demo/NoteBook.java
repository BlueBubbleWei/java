package cn.network.demo;

public class NoteBook {
	public void run() {
		System.out.println("notebook run!");
	}
	/**
	 * 使用USB设备
	 */
	public void useUSB(USB usb) {
		if(usb!=null){
			usb.open();
			usb.close();
		}
	}
}
