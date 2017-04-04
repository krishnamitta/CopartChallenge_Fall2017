import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.imageio.ImageIO;

import javax.imageio.ImageIO;




/**
 * This is a test harness class to test the
 * image conversion utility.
 * @author Debadatta Mishra(PIKU)
 *
 */
public class imagetoText 
{
	private static String IMAGE_TYPE = "jpg";
	public static void main(String[] args) 
	{
		String sourceImagePath = "image2.jpg";
		//Convert the image into text file
		convertImageToText(sourceImagePath);
	}




public static void convertImageToText( String imagePath )
{
	File file = new File( imagePath );
	String fileName = file.getAbsolutePath();
	String textFilePath = new StringBuilder(fileName.substring(0, fileName
			.lastIndexOf("."))).append(".txt").toString();
	writeImageAsTextFile(textFilePath, getImageAsString(imagePath));
	/*
	 * There may be requirement to delete the original image,
	 * write the code here for this purpose.
	 */
}


public static String getImageAsString( String imagePath )
{
	String imageString = null;
	try
	{
		File f = new File(imagePath);
		BufferedImage buffImage = ImageIO.read(f);
		ByteArrayOutputStream os= new ByteArrayOutputStream();
		ImageIO.write(buffImage, IMAGE_TYPE, os);
		byte[] data= os.toByteArray();
		imageString = new sun.misc.BASE64Encoder().encode(data);
	}
	catch( FileNotFoundException fnfe )
	{
		fnfe.printStackTrace();
		System.out.println("Image is not located in the proper path.");
	}
	catch (IOException e) 
	{
		e.printStackTrace();
		System.out.println("Error in reading the image.");
	}
	return imageString;
}


/**
 * This method is used to write the contents of an image into a text file.
 * @param filePath of type String indicating the path of the text file
 * @param imageContents of type String indicating the image contents as String
 * @author Debadatta Mishra(PIKU)
 */
public static void writeImageAsTextFile( String filePath , String imageContents )
{
	FileOutputStream fout=null;
	OutputStreamWriter osw = null;
	OutputStream bout = null;
	try
	{
		fout = new FileOutputStream (filePath);
		bout= new BufferedOutputStream(fout);
		osw = new OutputStreamWriter(bout, "utf-8");
		osw.write(imageContents);
		bout.close();
		fout.close();
	}
	catch( Exception e )
	{
		e.printStackTrace();
	}
}



}