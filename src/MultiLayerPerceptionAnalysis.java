import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;

public class MultiLayerPerceptionAnalysis 
{
	private double learningRate;
	private double momentum;
	private int trainingTime;
	private String hiddenlayer;
	private MultilayerPerceptron mlp = new MultilayerPerceptron();



	public MultiLayerPerceptionAnalysis(double learningRate, double momentum, int trainingTime, String hiddenlayer) 
	{
		// TODO Auto-generated constructor stub
		this.learningRate = learningRate;
		this.momentum = momentum;
		this.trainingTime = trainingTime;
		this.hiddenlayer = hiddenlayer;
	}




	public MultilayerPerceptron getMlp() {
		return mlp;
	}




	public void setMlp(MultilayerPerceptron mlp) {
		this.mlp = mlp;
	}




	public void simpleWekaTrain(String filepath)
	{
		try{
			//Reading training arff or csv file
			FileReader trainreader = new FileReader(filepath);
			Instances train = new Instances(trainreader);
			train.setClassIndex(train.numAttributes() - 1);
			//Instance of NN

			//Setting Parameters
			mlp.setLearningRate(learningRate);
			mlp.setMomentum(momentum);
			mlp.setTrainingTime(trainingTime);
			mlp.setHiddenLayers(hiddenlayer);
			mlp.buildClassifier(train);


		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	

	public void analyzeTest(String filePath)
	{
		try {
			FileReader testreader = new FileReader(filePath);
			Instances test = new Instances(testreader);
			test.setClassIndex(test.numAttributes() - 1);

			for(int i =0; i < test.numInstances(); i++)
			{
				double d = mlp.classifyInstance(test.instance(i));

				System.out.println(d);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void evaluateError(String filePath)
	{
		try {
			FileReader testreader = new FileReader(filePath);
			Instances test = new Instances(testreader);
			test.setClassIndex(test.numAttributes() - 1);
			Evaluation eval = new Evaluation(test);
			eval.evaluateModel(mlp, test);
			//System.out.println(eval.errorRate()); //Printing Training Mean root squared Error
			System.out.println(eval.toSummaryString()); //Summary of Training


			//System.out.println("Area under ROC: "+eval.areaUnderROC(test.numAttributes() - 1));


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
