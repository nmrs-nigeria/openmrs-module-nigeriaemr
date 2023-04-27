/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.nigeriaemr.util;

import org.openmrs.module.nigeriaemr.NDREvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
	
	private List<String> fileList;
	
	private static String SOURCE_FOLDER;
	
	public ZipUtil(String sourceFolder) {
		fileList = new ArrayList<String>();
		SOURCE_FOLDER = sourceFolder;
	}
	
	/*public static void main(String[] args) {
		ZipUtil appZip = new ZipUtil();
		appZip.generateFileList(new File(SOURCE_FOLDER));
		appZip.zipIt(OUTPUT_ZIP_FILE);
	}*/
	public void zipIt(String output_zipFile) {
		File zipFile = new File(output_zipFile);
		if (zipFile.exists())
			zipFile.delete();
		byte[] buffer = new byte[1024];
		String source = new File(SOURCE_FOLDER).getName();
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		try {
			fos = new FileOutputStream(output_zipFile);
			zos = new ZipOutputStream(fos);
			
			LoggerUtils.write(NDREvent.class.getName(), "Output to Zip : " + output_zipFile, LoggerUtils.LogFormat.INFO,
			    LoggerUtils.LogLevel.live);
			
			FileInputStream in = null;
			
			for (String file : this.fileList) {
				System.out.println("File Added : " + file);
				ZipEntry ze = new ZipEntry(source + File.separator + file);
				zos.putNextEntry(ze);
				try {
					in = new FileInputStream(SOURCE_FOLDER + File.separator + file);
					int len;
					while ((len = in.read(buffer)) > 0) {
						zos.write(buffer, 0, len);
					}
				}
				finally {
					in.close();
				}
			}
			
			zos.closeEntry();
			System.out.println("Folder successfully compressed");
			
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				zos.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void zipBatch(String parent_zipFile, int batch) {
		File parentFile = new File(parent_zipFile);
		String[] fileName = parentFile.getName().split("\\.");
		String output_zipFilePrefix = parentFile.getParent()+ File.separator +fileName[0];
		List<List<String>> partitions = Partition.ofSize(this.fileList, batch);
		byte[] buffer = new byte[1024];
		String source = new File(SOURCE_FOLDER).getName();

		List<String> zipList = new ArrayList<>();
		for (int i = 0; i < partitions.size(); i++) {
			String output_zipFile = output_zipFilePrefix + "_" + i + ".zip";
			zipList.add(output_zipFile);
			FileOutputStream fos;
			ZipOutputStream zos = null;
			try {
				fos = new FileOutputStream(output_zipFile);
				zos = new ZipOutputStream(fos);
				List<String> partition = partitions.get(i);
				File zipFile = new File(output_zipFile);

				if (zipFile.exists())
					zipFile.delete();

				LoggerUtils.write(ZipUtil.class.getName(), "Output to Zip : " + output_zipFile, LoggerUtils.LogFormat.INFO,
						LoggerUtils.LogLevel.live);

				FileInputStream in = null;

				for (String file : partition) {
					System.out.println("File Added : " + file + "in batch " + i);
					ZipEntry ze = new ZipEntry(source + File.separator + file);
					zos.putNextEntry(ze);
					try {
						in = new FileInputStream(SOURCE_FOLDER + File.separator + file);
						int len;
						while ((len = in.read(buffer)) > 0) {
							zos.write(buffer, 0, len);
						}
					} finally {
						in.close();
					}
				}
				zos.closeEntry();
				System.out.println("Folder " + i + " successfully compressed");
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try {
					zos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		//zip the zip files

		FileInputStream in = null;
		File dir = new File(SOURCE_FOLDER);
		String parentFolder = dir.getParent();
		String newSource = new File(parentFolder).getName();
		FileOutputStream fos;
		ZipOutputStream zos = null;
		try {
			fos = new FileOutputStream(parent_zipFile);
			zos = new ZipOutputStream(fos);
			for (String file : zipList) {
				File zipFile = new File(file);
				ZipEntry ze = new ZipEntry(zipFile.getName());
				zos.putNextEntry(ze);
				try {
					in = new FileInputStream(file);
					int len;
					while ((len = in.read(buffer)) > 0) {
						zos.write(buffer, 0, len);
					}
				} finally {
					in.close();
				}
				zipFile.delete();
			}
		zos.closeEntry();
	}catch (Exception ignored){} finally {
			try {
				zos.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void generateFileList(File node) {
		// add xml or json files only
		if (node.isFile() && (node.getName().endsWith("xml") || node.getName().endsWith("json"))) {
			fileList.add(generateZipEntry(node.toString()));
		} else if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateFileList(new File(node, filename));
			}
		}
	}
	
	private String generateZipEntry(String file) {
		return file.substring(SOURCE_FOLDER.length() + 1, file.length());
	}
}
