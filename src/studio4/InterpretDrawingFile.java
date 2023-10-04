package studio4;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import edu.princeton.cs.introcs.StdDraw;

/**
 * 
 */
public class InterpretDrawingFile {

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("resources");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		
		String shapeType = in.next();
		
		int redComponent = in.nextInt();
		int greenComponent = in.nextInt();
		int blueComponent = in.nextInt();
		Color shapeColor = new Color(redComponent, greenComponent, blueComponent);
		boolean isFilled = in.nextBoolean();
		double parameterOne = in.nextDouble();
		double parameterTwo = in.nextDouble();
		double parameterThree = in.nextDouble();
		double parameterFour = in.nextDouble();
		
		if (shapeType.equals("ellipse") && isFilled == true) {
			StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
			StdDraw.filledEllipse(parameterOne, parameterTwo, parameterThree, parameterFour);
		}
		else if (shapeType.equals("ellipse") && isFilled == false) {
			StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
			StdDraw.ellipse(parameterOne, parameterTwo, parameterThree, parameterFour);
		}
		else if (shapeType.equals("rectangle") && isFilled == true) {
			StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
			StdDraw.filledRectangle(parameterOne, parameterTwo, parameterThree, parameterFour);
		}
		else if (shapeType.equals("rectangle") && isFilled == false){
			StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
			StdDraw.rectangle(parameterOne, parameterTwo, parameterThree, parameterFour);
		}
		else if (shapeType.equals("triangle") && isFilled == true) { //use polygon to create triangle
			
			double parameterFive = in.nextDouble();
			double parameterSix = in.nextDouble();
			
			double[] xCoordinate = {parameterOne, parameterThree, parameterFive};
			double[] yCoordinate = {parameterTwo, parameterFour, parameterSix};
			
			StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
			StdDraw.filledPolygon(xCoordinate, yCoordinate);
		}
		else if (shapeType.equals("triangle") && isFilled == false) {
			
			double parameterFive = in.nextDouble();
			double parameterSix = in.nextDouble();
		
			double[] xCoordinate = {parameterOne, parameterThree, parameterFive};
			double[] yCoordinate = {parameterTwo, parameterFour, parameterSix};
			
			StdDraw.setPenColor(redComponent, greenComponent, blueComponent);
			StdDraw.polygon(xCoordinate, yCoordinate);
		}
	}
} 