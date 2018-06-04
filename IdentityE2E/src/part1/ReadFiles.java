package part1;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;

public class ReadFiles {
	
	public static String directoryLinuxMac ="/Users/gangambikagogga/TestDirectory";
	 //Windows directory example
    final String directoryWindows ="C://test";

	/**
	 * Lists files and directories using File[] listFiles(FilenameFilter) method
	 */
	public static File[] listFiles(String directoryName) {

		// Filter to look for excel/csv files
		FilenameFilter fileFilter = new FilenameFilter() {
			public boolean accept(File file, String name) {
				if (name.endsWith(".xlsx") || name.endsWith(".xls") || name.endsWith(".csv")) {
					// filters files whose extension is .xlsx || .xls || .csv
					return true;
				} else {
					return false;
				}
			}
		};

		File dir = new File(directoryName);
		File[] files = dir.listFiles(fileFilter);
		
		if (files.length == 0) {
			System.out.println("There is no excel or csv files");
		} else {
			for (File aFile : files) {
				String fileName = aFile.getName();
				long bytesSize = aFile.length();
				double fileSizeInKB = (bytesSize / 1024);
				String extension = "";
				int i = fileName.lastIndexOf('.');
				if (i >= 0) {
				    extension = fileName.substring(i+1);
				}
				
				StringBuilder file = new StringBuilder();
				file.append("FileName: " + fileName);
				file.append(" File Size in KB: " + fileSizeInKB);
				file.append(" File Extension: " + extension);
				file.append(" MimeType: " + new MimetypesFileTypeMap().getContentType(aFile));
				System.out.println(file);
			}
		}
			return files;
	}



	public static void main(String[] args) {
		ReadFiles listFilesUtil = new ReadFiles();
	    File[] fileList = listFilesUtil.listFiles(directoryLinuxMac);
	}
}
