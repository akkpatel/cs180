import com.ridgesoft.io.Display;
import com.ridgesoft.intellibrain.IntelliBrain;
import com.ridgesoft.robotics.Servo;
import com.ridgesoft.intellibrain.IntelliBrainDigitalIO;
import java.util.*;

public class Mybot2 {
	
	public static void main(String args[])
	{
		try{
			IntelliBrainDigitalIO Sonar = IntelliBrain.getDigitalIO(3);
			Sonar.enablePulseMeasurement(true);

			Random r = new Random();
			Display display = IntelliBrain.getLcdDisplay();
			Servo leftServo = IntelliBrain.getServo(1);
			Servo rightServo = IntelliBrain.getServo(2);

			int[] command = {4,0,1,0,2,0,3,2,4,0,4,1,2,1,2,4,0,1,4,2,3,2,3,-1};
			int[] sleep = {0,3000,4000,1500,650,2000,650,1800,2,1200,1,1500,800,900,100,4,1200,1200,3,500,500,1600,2500};
			String[] message = {"Hello World", "CS180", "Robot Lab 1", "Aditya Mathur", "Robots!!!"};

			int i = 0, distance = 0;
			int ranint = r.nextInt();
			ranint = r.nextInt();
		
		while(true)
			{
				Sonar.pulse(2);
				Thread.sleep(50);
				distance=Sonar.readPulseDuration();

				if(distance<=500){
					display.print(0, "ERROR");
					display.print(1, "Wall Detected");
					break;
				}
			


				if(command[i] == 0){
					leftServo.setPosition(100);
					rightServo.setPosition(0);
					Thread.sleep(sleep[i]);
				}
				else if(command[i] == 1){
					leftServo.setPosition(0);
					rightServo.setPosition(100);
					Thread.sleep(sleep[i]);
				}
				else if(command[i] == 2){
					leftServo.setPosition(100);
					rightServo.setPosition(100);
					Thread.sleep(sleep[i]);
				}
				else if(command[i] == 3){
					leftServo.setPosition(0);
					rightServo.setPosition(0);
					Thread.sleep(sleep[i]);
				}
				else if(command[i] == 4){
					display.print(0, message[sleep[i]]);
				}
				else if(command[i] == -1){
					break;
				}

				i++;
			}
		} catch (Throwable t)  
		{
  			 t.printStackTrace();
  		}
	}
}		