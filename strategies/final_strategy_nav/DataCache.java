package final_strategy_nav;
import battlecode.common.*;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class DataCache {

	public static BaseRobot robot;
	public static RobotController rc;

	public static MapLocation enemyHQ;
	public static MapLocation ourHQ;

	public static MapLocation mapCenter;

	public static MapLocation[] enemyTowers;
	public static MapLocation[] ourTowers;

	public static MapLocation currentLoc;
	public static MapLocation internalLoc;
	public static MapLocation prevRobotLoc = new MapLocation(-1, -1);

	public static int xmodifier;
	public static int ymodifier;

	public static boolean collecting = false;


	public static MapLocation bestOreLoc = new MapLocation(-1, -1);

	public static MapLocation secondbestOreLoc = new MapLocation(-1, -1);
	
	public static MapLocation thirdbestOreLoc = new MapLocation(-1, -1);



	public static List<MapLocation> seenLocs=new ArrayList<MapLocation>();


	//INITIALIZATION
	public static void init(BaseRobot myRobot) {
		robot = myRobot;
		rc = robot.rc;
		enemyHQ = rc.senseEnemyHQLocation();
		ourHQ = rc.senseHQLocation();
		enemyTowers = rc.senseEnemyTowerLocations();
		ourTowers = rc.senseTowerLocations();

		mapCenter = new MapLocation((ourHQ.x+enemyHQ.x)/2, (ourHQ.y+enemyHQ.y)/2);
		xmodifier = ourHQ.x;
		ymodifier = ourHQ.y;

	}

	//UPDATE CURRENT LOCATION
	public static void updateRoundVariables() throws GameActionException {
		currentLoc = rc.getLocation();
		internalLoc = Functions.locToInternalLoc(currentLoc);

		int myAliveCount = BroadcastSystem.read(BroadcastSystem.myAliveChannel);
		BroadcastSystem.write(BroadcastSystem.myAliveChannel,myAliveCount+1);

		// if (Clock.getRoundNum() > 500){
		// 	BroadcastSystem.setNotCollecting();
		// }
		//MOVE ENEMYROBOT CHECKING TO HERE
	}

	public static boolean hasMoved() throws	GameActionException {
		if (currentLoc.equals(prevRobotLoc)){
			return false;
		} else {
			prevRobotLoc = currentLoc;
			return true;
		}
	}

	public static boolean hasMovedAndCollecting() throws	GameActionException {
		if (currentLoc.equals(prevRobotLoc)){
			return false;
		} else if (!collecting){
			return false;
		}
		else {
			prevRobotLoc = currentLoc;
			return true;
		}
	}

	public static boolean withinStructRange(MapLocation loc){
		if (loc.distanceSquaredTo(enemyHQ)<25){
			return true;
		} else{
			for (MapLocation tower: enemyTowers){
				if (loc.distanceSquaredTo(tower)<25){
					return true;
				}
			}

		}
		return false;
	}

	public static void updateSeenLocs(List<MapLocation> newLocs){
		seenLocs.addAll(newLocs);
	}

	public static void displaySeenLocs(){
		for (MapLocation loc: seenLocs){
			rc.setIndicatorDot(loc, 255, 255, 255);
		}
	}
}
	