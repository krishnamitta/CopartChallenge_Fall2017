import com.aspose.ocr.ImageStream;
import com.aspose.ocr.OcrEngine; 

public class ReadTextfrImage {
    public static void main(String[] args) {
  
        String imagePath = "image2.jpg";
        OcrEngine ocrEngine = new OcrEngine();
      //Set the Image property by loading the image from file path location
      ocrEngine.setImage(ImageStream.fromFile(imagePath));
        try {
            //Process the image
            if (ocrEngine.process())
            {
                //Display the recognized text
                System.out.println(ocrEngine.getText());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}