package tests;

import java.io.File;

import org.junit.Test;

import junit.framework.Assert;
import part1.ReadFiles;

public class Part1Test {
	
	
    // Test to check only supported file formats are displayed from the inout directory
	@Test
	public void validateSupportedFileFormatsInPart1()
	{
		String xlsxExtension = "xlsx";
		String xlsExtension = "xls";
		String csvExtension = "csv";
		
		String directoryName = ReadFiles.directoryLinuxMac;
		File[] allFiles = ReadFiles.listFiles(directoryName);
		
		for (File aFile : allFiles)
		{
			String fileName = aFile.getName();
			String extension = "";
			int i = fileName.lastIndexOf('.');
			if (i >= 0) {
			    extension = fileName.substring(i+1);
			}
			if(!(extension.contains(xlsxExtension) 
					|| extension.contains(xlsExtension) 
					|| extension.contains(csvExtension)))
					{
						System.out.println("extension: " + extension);
						Assert.fail("Part1 Not Implemented Properly. Files with not supported format returned");
					}
		}
	}
}
