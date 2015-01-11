package drone_missle_strategy;

import battlecode.common.Clock;
import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.Team;

public class BEAVERRobot extends BaseRobot {




	public BEAVERRobot(RobotController rc) throws GameActionException {
		super(rc);
	}

	@Override
	public void run() {
		try {
		    if (getEnemiesInAttackingRange().length>0) {
                if (rc.isWeaponReady()) {
                    attackLeastHealthEnemy(getEnemiesInAttackingRange());
                }
		    } else if (rc.isCoreReady()) {
		        RobotPlayer.tryMove(RobotPlayer.directions[RobotPlayer.rand.nextInt(8)]);
		    }
		    rc.broadcast(BEAVER_CURRENT_CHAN, rc.readBroadcast(BEAVER_CURRENT_CHAN)+1);
		    rc.yield();
		} catch (Exception e) {
			//                    System.out.println("caught exception before it killed us:");
			//                    System.out.println(rc.getRobot().getID());
			//e.printStackTrace();
		}
	}
}
