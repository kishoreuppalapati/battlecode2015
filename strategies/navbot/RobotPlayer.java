package navbot;

import battlecode.common.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Random;
//export PATH=/usr/local/apache-ant/bin:"$PATH"

public class RobotPlayer {
	static RobotController rc;
	static MapLocation loc;
	static Team myTeam;
	static Team enemyTeam;
	static int myRange;
	static Random rand;
	static MapLocation[] theMap;


	static int numUnknown=0;
	static int numOffmap=0;
	static int numNormal=0;
	static int numVoid=0;
	
	public static void run(RobotController rcIn) {
		rc= rcIn;
		BaseRobot robot = null;
		loc = rc.getLocation();

		//int randseed = rc.getID();
        //Util.randInit(randseed, randseed * Clock.getRoundNum());


		// if (rc.getType() == RobotType.HQ){
		// 	System.out.println("I am HQ at string:" + rc.senseHQLocation().toString());
		// 	System.out.println("I am HQ at :" + loc);
		// 	theMap = MapLocation.getAllMapLocationsWithinRadiusSq(loc, 10000);
		// 	for (MapLocation mapLoc:theMap){
		// 		if (rc.senseTerrainTile(mapLoc)==TerrainTile.UNKNOWN){
		// 			numUnknown++;
		// 		}else if (rc.senseTerrainTile(mapLoc)==TerrainTile.OFF_MAP){
		// 			numOffmap++;
		// 			System.out.println(mapLoc);
		// 		}else if (rc.senseTerrainTile(mapLoc)==TerrainTile.NORMAL){
		// 			numNormal++;
		// 		}
		// 		else if (rc.senseTerrainTile(mapLoc)==TerrainTile.VOID){
		// 			numVoid++;
		// 		}
		// 		//System.out.println(mapLoc.toString());
		// 	}
		// 	System.out.println(numUnknown);
		// 	System.out.println(numOffmap);
		// 	System.out.println(numNormal);
		// 	System.out.println(numVoid);

		// } else if (rc.getType() == RobotType.TOWER){
		// 	System.out.println("I am tower at :" + loc);
		// }

        try {
            switch(rc.getType()) {

            case HQ:
                rc.broadcast(211,1000);
            	robot = new HQRobot(rc);
            	break;       

            case TOWER:
                    robot = new TOWERRobot(rc);
                    break;



            // Structures //
            case AEROSPACELAB:
                    robot = new AEROSPACELABRobot(rc);
                    break;

            case BARRACKS :
                    robot = new BARRACKSRobot(rc);
                    break;        	

            case HANDWASHSTATION  :
                    robot = new HANDWASHSTATIONRobot(rc);
                    break;  

            case HELIPAD:
                    robot = new HELIPADRobot(rc);
                    break;   

            case MINERFACTORY:
                    robot = new MINERFACTORYRobot(rc);
                    break;    

            case SUPPLYDEPOT:
                    robot = new SUPPLYDEPOTRobot(rc);
                    break;             

            case TANKFACTORY:
                    robot = new TANKFACTORYRobot(rc);
                    break;  

            case TECHNOLOGYINSTITUTE:
                    robot = new TECHNOLOGYINSTITUTERobot(rc);
                    break;                           
           	
           	case TRAININGFIELD:
                    robot = new TRAININGFIELDRobot(rc);
                    break;   
            ///////////////

            // Units //
            case BASHER:
                    robot = new BASHERRobot(rc);
                    break;

            case BEAVER:
                    robot = new BEAVERRobot(rc);
                    break;        	

            case COMMANDER:
                    robot = new COMMANDERRobot(rc);
                    break;  

            case COMPUTER:
                    robot = new COMPUTERRobot(rc);
                    break;   

            case DRONE:
                    robot = new DRONERobot(rc);
                    break;    

            case LAUNCHER:
                    robot = new LAUNCHERRobot(rc);
                    break;             

            case MINER:
                    robot = new MINERRobot(rc);
                    break;     
           	
           	case MISSILE:
                    robot = new MISSILERobot(rc);
                    break;   
 
           	case SOLDIER:
                    robot = new SOLDIERRobot(rc);
                    break;     

           	case TANK:
                    robot = new TANKRobot(rc);
                    break;                                           
            ///////////////
            }
            robot.loop();
        } catch (Exception e) {
        	//e.printStackTrace();
    	}
    }
    
    
}

