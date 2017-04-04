package cn.myio.demo;

import java.io.File;
import java.io.FileFilter;

/**
 * @author john5
 *
 */
public class FilterBySuffix implements FileFilter {
	private String suffix;
	@Override
	public boolean accept(File pathname) {
		return pathname.getName().endsWith(suffix);
	}
	/**
	 * @param suffix
	 */
	public FilterBySuffix(String suffix) {
		super();
		this.suffix = suffix;
	}
	
}
