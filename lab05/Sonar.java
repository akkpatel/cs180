
import com.ridgesoft.io.Display;
import com.ridgesoft.intellibrain.IntelliBrain;
import com.ridgesoft.robotics.Servo;
import com.ridgesoft.intellibrain.IntelliBrainDigitalIO;

public class MyBot 
{
	public static void main(String args[]) 
	{
		try 
		{
			Display display = IntelliBrain.getLcdDisplay();
			display.print(0, "MyBot");
			display.print(1, "Version 0.1");
			Thread.sleep(1000);
			Servo leftServo = IntelliBrain.getServo(1);
			Servo rightServo = IntelliBrain.getServo(2);
			IntelliBrainDigitalIO Sonar = IntelliBrain.getDigitalIO(3);
			Sonar.enablePulseMeasurement(true);
			int distance;
			int i=0;
			leftServo.setPosition(100);
			rightServo.setPosition(0);
			do
			{
				Sonar.pulse(2);
				Thread.sleep(50);
				distance=Sonar.readPulseDuration();
				if(distance<500){
					leftServo.setPosition(100);
					rightServo.setPosition(100);
					Thread.sleep(1200);
				}
				else{
					leftServo.setPosition(100);
					rightServo.setPosition(0);
				}
				display.print(0, "Distance from object: ");
				display.print(1, "" + distance);
			}while(1==1);
		}	
		catch (Throwable t) 	
		{
			t.printStackTrace();
		}
	}
}