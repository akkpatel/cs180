import com.ridgesoft.io.Display;
import com.ridgesoft.intellibrain.IntelliBrain;
import com.ridgesoft.robotics.Servo;
import com.ridgesoft.intellibrain.IntelliBrainDigitalIO;

public class Mybot2 {
	Servo leftServo = IntelliBrain.getServo(1);
	Servo rightServo = IntelliBrain.getServo(2);
	public static void main(String args[])
	{

		int[] command = {4,0,1,0,2, 0,3, 2,4,0,4,1,2,1,2,4,0,1,4, 2,3,2,3,-1};
		int[] sleep = {0,3000,4000,1500,650,2000,650,1800,2,1200,1,1500,800,900,100,4,1200,1200,3,500,500,16				00,2500};
		String[] message = {"Hello World", "CS180", "Robot Lab 1", "Aditya Mathur", "Robots!!!"};

		int i = 0;

		while(true)
		{
			if(command[i] == 0){
				leftServo.setPosition(100);
				rightServo.setPosition(0);
			}
			else if(command[i] == 1){
				leftServo.setPosition(0);
				rightServo.setPosition(100);
			}
			else if(command[i] == 2){
			Thread.sleep(550);
			leftServo.setPosition(100);
			rightServo.setPosition(100);
			}

			i++;
}
		