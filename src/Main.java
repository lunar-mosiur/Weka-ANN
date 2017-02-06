public class Main 
{

	

	public static void main(String[] args) 
	{
		String fileName = new String("trainingData_Updated_1.csv");
		int pos = fileName.lastIndexOf(".");

		String arffName = fileName.substring(0, pos)+".arff";
		
		String testFileName = new String("validationData_1.csv");
		pos = testFileName.lastIndexOf(".");

		String testArffName = testFileName.substring(0, pos)+".arff";
		
		
		CSV2Arff csv2Arff = new CSV2Arff();
		//csv2Arff.proceed(fileName, arffName);
		//csv2Arff.proceed(testFileName, testArffName);


		// TODO Auto-generated method stub
		MultiLayerPerceptionAnalysis multiLayerPerception = new MultiLayerPerceptionAnalysis(0.1, 0.2, 100, "3");
		multiLayerPerception.simpleWekaTrain(arffName);
		multiLayerPerception.analyzeTest(testArffName);
		//multiLayerPerception.evaluateError(testArffName);
		
	}

}
