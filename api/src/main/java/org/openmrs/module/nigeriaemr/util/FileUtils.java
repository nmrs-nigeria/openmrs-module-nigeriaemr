package org.openmrs.module.nigeriaemr.util;

import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class FileUtils {
	
	static DecimalFormat df = new DecimalFormat("#.##");
	
	public static boolean deleteNonZip(String folder) {
		boolean success = false;
		File file = new File(folder);
		File[] files = file.listFiles();
		if (files != null && files.length > 0) {
			for (File subFile : files) {
				if (subFile.getName().toLowerCase().endsWith(".zip"))
					if (subFile.isDirectory()) {
						success = deleteFolder(subFile.getPath(), true);
					}
			}
		}
		return success;
	}
	
	public static boolean deleteFolder(String folder, boolean deleteSource) {
		boolean success = false;
		File file = new File(folder);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files != null && files.length > 0) {
				for (File subFile : files) {
					success = subFile.delete();
				}
			}
			if (deleteSource)
				success = file.delete();
		} else {
			success = true;
		}
		
		return success;
	}
	
	public static String getFileSize(long value) {
		df.setRoundingMode(RoundingMode.CEILING);
		long kb = value / 1024;
		if (kb > 1024) {
			return df.format(kb / 1024) + " Mb";
		}
		return df.format(kb) + " Kb";
	}
	
	public static String getFileSize(File file) {
		if (file.exists() && file.isFile()) {
			return getFileSize(file.length());
		} else {
			File[] files = file.listFiles();
			long length = 0L;
			if (files != null) {
				for (File subFile : files) {
					length += subFile.length();
				}
			}
			return getFileSize(length);
		}
	}
	
	public static int getFileCount(File file) {
		if (file.exists() && !file.isFile()) {
			File[] files = file.listFiles();
			if (files != null) {
				return files.length;
			}
		}
		return 0;
	}
	
	public static String getFileProgress(File file, int total) {
		return getFileCount(file) + " of " + total + " patients processed";
	}
}
