package cameraapp;
public class CameraApp {
   
    public static void main(String[] args) {
        // Create arrays to store camera information
        String[] cameraBrand = {"CANON", "SONY", "NIKON"}; // single array to get camera names and 2d array for prices // (Olawanle, 2023)
        double[][] cameraInfo = {{10500.00, 8500.00}, {9500.00, 7200.00}, {12000.00, 8000.00}}; // (Oracle.com, 2022)

        // passing the array's
        displayCameraReport(cameraBrand, cameraInfo); // (GeeksforGeeks, 2017)
    }

    // Display the first half of the output
    private static void displayCameraReport(String[] cameraBrand, double[][] cameraInfo) { // (freeCodeCamp.org, 2022)
        // Calculate the price difference for each camera brand
        double[] priceDifference = calculatePriceDifference(cameraInfo);

        // Find the camera brand with the greatest price difference
        int index = greatestDifference(priceDifference);
        String cameraBrandBiggestDiff = cameraBrand[index];

        // Display the camera technology report
        displayCameraResult(cameraBrand, cameraInfo, priceDifference, cameraBrandBiggestDiff);
    }

    private static double[] calculatePriceDifference(double[][] cameraInfo) {
        double[] priceDifference = new double[cameraInfo.length];
        for (int i = 0; i < cameraInfo.length; i++) {
            priceDifference[i] = cameraInfo[i][0] - cameraInfo[i][1];
        }
        return priceDifference;
    }

    private static int greatestDifference(double[] priceDifference) { // (freeCodeCamp.org, 2022)
        int index = 0;
        double greatestPriceDifference = 0.0;
        for (int i = 0; i < priceDifference.length; i++) {
            if (priceDifference[i] > greatestPriceDifference) {
                greatestPriceDifference = priceDifference[i];
                index = i;
            }
        }
        return index;
    }
    
    // Display the result
    private static void displayCameraResult(String[] cameraBrand, double[][] cameraInfo, double[] priceDifference, String cameraBrandBiggestDiff) { // (freeCodeCamp.org, 2022)
        // Display the camera brand and the cost of a DSLR versus a Mirrorless camera
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Camera Technology Report");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("\t\tDSLR Cost\t\tMirrorless Cost");
        for (int i = 0; i < cameraBrand.length; i++) {
            System.out.println(cameraBrand[i] + "\t\tR " + cameraInfo[i][0] + "\t\tR " + cameraInfo[i][1]);
        }
        System.out.println();

        // Display the camera technology results
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("Camera Technology Results");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < cameraBrand.length; i++) {
            String stars = priceDifference[i] > 2500 ? "***" : ""; // Statement to Add 3 stars if the difference is more than 2500 or add "" (nothing) if under
            System.out.println(cameraBrand[i] + "    R" + priceDifference[i] +" "+ stars);
        }
        System.out.println();

        // Display the camera manufacturer with the greatest price difference
        System.out.println("CAMERA WITH THE MOST DIFFERENCE: " + cameraBrandBiggestDiff);
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
}


/** References
 *  GeeksforGeeks. (2017). Classes and Objects in Java. [online] Available at: https://www.geeksforgeeks.org/classes-objects-java/#:~:text=In%20Java%2C%20classes%20and%20objects,having%20similar%20properties%20and%20behavior. [Accessed 9 Oct. 2023].
    Oracle.com. (2022). Arrays (The JavaTM Tutorials > Learning the Java Language > Language Basics). [online] Available at: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html#:~:text=An%20array%20is%20a%20container,creation%2C%20its%20length%20is%20fixed. [Accessed 9 Oct. 2023].
    Olawanle, J. (2023). JavaScript 2D Array – Two Dimensional Arrays in JS. [online] freeCodeCamp.org. Available at: https://www.freecodecamp.org/news/javascript-2d-arrays/#:~:text=A%20two%2Ddimensional%20array%2C%20also,row%20and%20column%20indices%2Findexes. [Accessed 9 Oct. 2023].
    freeCodeCamp.org (2022). Java Programming for Beginners – Full Course. YouTube. Available at: https://www.youtube.com/watch?v=A74TOX803D0&ab_channel=freeCodeCamp.org [Accessed 9 Oct. 2023].
 */