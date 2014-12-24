import com.ridgesoft.io.Display;
import com.ridgesoft.intellibrain.IntelliBrain;
import com.ridgesoft.robotics.Servo;
import com.ridgesoft.intellibrain.IntelliBrainDigitalIO;


public class MyBot 
{
    public static void main(String args[]) 
 {
  try{
		

   //print on bot display
		Display display = IntelliBrain.getLcdDisplay();

   //first line "My Bot"
		display.print(0, "MyBot");

   //sexond line "Collision Avoidance"
		display.print(1, "Collison Avoidance");
		Thread.sleep(1000);

   //set up servo's and sonar
		Servo leftServo = IntelliBrain.getServo(1);
		Servo rightServo = IntelliBrain.getServo(2);
		IntelliBrainDigitalIO Sonar = IntelliBrain.getDigitalIO(3);
		Sonar.enablePulseMeasurement(true);
    
   //set up variable's
		int distance = 0;
		int i=1, iter = 1, j;
		
   //move robot forward
		leftServo.setPosition(100);
		rightServo.setPosition(0);
   //while loop{
		while(i==1){
			Sonar.pulse(2);
			Thread.sleep(50);
			distance = Sonar.readPulseDuration();

     //nested for loop{

			if(distance<=500){
				for(j=0; j<4; j++){ 
					if (0 == (j%2)){
						leftServo.setPosition(100);
						rightServo.setPosition(100);
						Thread.sleep(1200);
					}
					else{
						leftServo.setPosition(0);
						rightServo.setPosition(0);
						Thread.sleep(1200);
					}
					i=0;
				}
			}
			else if((iter%125) == 0){
				if((iter%2) == 0){
					leftServo.setPosition(100);
					rightServo.setPosition(100);
					Thread.sleep(600);
				}
				else{
					leftServo.setPosition(0);
					rightServo.setPosition(0);
					Thread.sleep(600);
				}
			}
			else{
				leftServo.setPosition(100);
				rightServo.setPosition(0);
			}
			iter++;
		}				
  }
  catch (Throwable t)  
  {
   t.printStackTrace();
  }
    }
}

