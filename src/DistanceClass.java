import java.io.BufferedReader;
import java.io.FileReader;

public class DistanceClass 
{
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg) {
      return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad) {
      return (rad * 180.0 / Math.PI);
    }

	private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == 'K') {
			dist = dist * 1.609344;
		} else if (unit == 'N') {
			dist = dist * 0.8684;
		}
		return (dist);
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		DistanceClass distance_x = new DistanceClass();
		
		String fileName = "Book1.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) 
		{
		    for(String line; (line = br.readLine()) != null; ) 
		    {
		        // process the line.
		    	String [] s = line.split(",");
		    	double [] d = new double[4];
		    	for(int i =0; i < 4; i++)
		    	{
		    		d[i] = Double.parseDouble(s[i]);
		    	}
		    	double distance_calc = distance_x.distance(d[1]/100000,d[0]/100,d[3]/100000,d[2]/100,'N');
		    	System.out.println(distance_calc);
		    }
		    // line is not visible here.
		}
		catch (Exception e) {
			// TODO: handle exception
		}

	}

}
