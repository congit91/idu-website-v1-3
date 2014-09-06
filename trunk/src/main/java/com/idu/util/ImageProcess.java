package com.idu.util;

import java.io.IOException;

import javax.servlet.http.Part;

public class ImageProcess {
	public static String getFilename(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String filename = cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1)
						.substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
			}
		}
		return null;
	}

	public static String saveImage(Part image,String folder) {
		final int  SIZE_CODE = 8;
		String fileName = "default.png";
		try {
			if (image == null) 
				return fileName;
			String arr[] = getFilename(image).split("\\.");
			String type = arr[arr.length - 1];
			if (type.equals("PNG") || type.equals("png") || type.equals("jpg")
					|| type.equals("JPG")) {
				fileName = Support.randomCode(SIZE_CODE) + "." + type;
				image.write(folder + fileName);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			return "default.png";
		}
		return fileName;
	}
}
