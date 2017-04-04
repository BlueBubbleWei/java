package cn.myio.demo;

import java.io.File;
import java.io.FileFilter;

public class FilerByFile implements FileFilter {

	@Override
	public boolean accept(File pathname) {
		return pathname.isFile();
	}
	/**
	* @param args
	*/
}
