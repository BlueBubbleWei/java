package cn.myio.demo;

import java.io.File;
import java.io.FilenameFilter;

public class FilerByContain implements FilenameFilter {
	private String content;
	
	/**
	 * @param content
	 */
	public FilerByContain(String content) {
		super();
		this.content = content;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.contains(content);
	}
	
}
