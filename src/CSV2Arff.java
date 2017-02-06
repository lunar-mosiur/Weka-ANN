import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

public class CSV2Arff 
{
	public CSV2Arff() {
		// TODO Auto-generated constructor stub
	}
	
	public void proceed(String fileName, String arffName)
	{
		Instances data = null;
		try {
			// load CSV
			CSVLoader loader = new CSVLoader();
			loader.setSource(new File(fileName));
			data = loader.getDataSet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// save ARFF
		try {
			ArffSaver saver = new ArffSaver();
			saver.setInstances(data);
			saver.setFile(new File(arffName));
			saver.setDestination(new File(arffName));
			saver.writeBatch();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
