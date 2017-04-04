package cn.mybuffer.demo;

public class TestDemo1 {
	/**
	* @param args
	* 需求1：通过键盘录入的数据，将数据保存到一个文件中
	* 
	* 
	* 明确一：有源吗？有    有目的吗？  有
	* 	源：InputStream  Reader
	* 	目的：OutputStream    Writer
	* 明确二：是纯文本数据吗？ 是
	* 	源：Reader
	* 	目的：Writer
	* 明确三：具体设备
	* 	源设备：System.in
	* 	目的设备：硬盘
	* 
	* InputStrean is=System.in;
	* FileWriter =fw=new FileWriter("a.txt");'
	* 
	* 将读取的字节存储到数组read(byte[])
	* 将字节数组转成字符数组
	* 通过fw.write(string)写入到文件中
	* 
	* 但是麻烦。因为明确源是Reader。需要将字节流转成字符流，这样操作文字就方便了
	* 
	* 明确四：需要功能吗？
	* 需要，转换  。 字节--->字符  InputStreamReader
	* InputStreamReader isr=new InputStreamReader(System.in);
	* FileWriter fw= new FileWriter("a.txt");
	* 一次读取一个字节
	* 将读到的字节写入
	* 当然也可以定义字符数组缓冲区
	* 
	* 需要其他功能吗？
	* 需要，高效。Buffered
	* 
	* BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
	* BufferedWriter bufw=new BufferedWriter(new FileWriter("a.txt"));
	* 
	* line=bufw.readLine();
	*bufw.write(string);
	*bufw.flush();
	*
	*
	*
	*
	*需求二：读取文本文件中的数据，将其打印到控制台上
	* 明确一：有源吗？有    有目的吗？  有
	* 	源：InputStream  Reader
	* 	目的：OutputStream    Writer
	* 
	* 明确二：是纯文本
	* 	源：Reader
	* 	目的：Writer
	* 明确三：明确设备
	* 	源设备：硬盘：File XXX
	* 	目的设备：显示器：System.out
	* 
	* FileReader fr=new FileReader("a.txt");
	* fr读取数据到数组中
	* 使用PrintStream直接调用println方法就可以打印了。如果使用OutputStream可以调用writer方法就可以将数据写到显示器上
	* 
	* 麻烦：
	* 因为源都是字符数据。可以通过字符流操作，将字符转成字节再给显示器
	* 需要额外的功能吗？
	* 需要转换  字符--->字节
	* OutputStreamWriter osw=new OutputStreamWriter(System.out);
	* 
	* 还需要额外功能吗？
	* 需要高效
	* BufferedReader bufr=new BufferedReader(new FileReader("a.txt"));
	* BbufferedWriter bufw=new BuffferedWriter(new OutputStreamWriter(System.out));
	* 
	*
	*/
	public static void main(String[] args) {
		
	}
}
