package cn.inprint.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SplitFileTest {
	/**
	* @param args
	 * @throws IOException 
	*/
	public static void main(String[] args) throws IOException {
//		文件切割器
//		一个读取流对应多个输出流，而且生成的碎片文件都有有序的编号
		File srcFile=new File("obj.txt");
		File destDir=new File("myproperties");
		fileSpilt(srcFile,destDir);
	}

	/**
	 * @param srcFile
	 * @throws IOException 
	 */
	private static void fileSpilt(File srcFile,File destDir) throws IOException {
		if(!srcFile.exists()){
			throw new RuntimeException(srcFile.getAbsolutePath()+"源文件不存在");
		}
		if(!destDir.exists()){
			destDir.mkdirs();
		}
//		读取源文件
		FileInputStream fileInputStream=new FileInputStream(srcFile);
//		创建目的引用
		FileOutputStream fileOutputStream=null;
//		创建一个缓冲区
		byte[] buf=new byte[1024*1024];
		int len=0;
		int count=0;
		while((len=fileInputStream.read())!=-1){
//			创建输出流
			File partFile=new File(destDir,(++count)+".part");
			fileOutputStream=new FileOutputStream(partFile);
			fileOutputStream.write(buf, 0, len);
			fileOutputStream.close();
		}
//		应该在产生隋品文件是，需要产生一个配置文件。记录碎片的个数和源文件的名字
//		配置文件中存储的键值信息，使用Properties集合
		Properties properties=new Properties();
		properties.setProperty("partcount", Integer.toString(count));
		properties.setProperty("filename", srcFile.getName());
		File configFile=new File(destDir,(++count)+".properties");
		
		fileOutputStream=new FileOutputStream(configFile);
		properties.store(fileOutputStream, "save part file info");
		fileInputStream.close();
	}
}
