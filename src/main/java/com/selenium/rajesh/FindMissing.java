package com.selenium.rajesh;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

public class FindMissing {

	public static void main(String[] args) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		List<String> lines = FileUtils.readLines(new File("F:\\Workfiles\\FrogStore\\SiteTagApi\\published1.txt"), "utf-8");
		System.out.println("lines "+lines.size());
		List<String> remain = FileUtils.readLines(new File("F:\\Workfiles\\FrogStore\\SiteTagApi\\published2.txt"), "utf-8");
		System.out.println("remain "+remain.size());
		for(String str: remain){
			if(lines.contains(str)){
				lines.remove(str);
			}
		}
		System.out.println(lines);
	}

}
