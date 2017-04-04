package cn.myio.demo;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.jar.Attributes.Name;

public class FileBySuffix implements FilenameFilter{
	
	private String suffix;
	public FileBySuffix(String suffix) {
		super();
		this.suffix=suffix;
	}
	//	 Name被遍历目录中的文件夹或者文件的名称
	
	@Override 
	public boolean accept(File dir, String name) {
		return name.endsWith(suffix);
	}
}
