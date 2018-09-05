package pocketgems.mud.components;

import java.util.ArrayList;
import java.util.HashSet;

import pocketgems.mud.Entity;
import pocketgems.mud.World;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

/*
 * RoomComponent
 * =============
 * Room entities should have a RoomComponent, which allows them to contain inhabitants and exits to
 * other rooms.
 */
public class RoomComponent extends Component {
	public HashSet<String> inhabitantIds;
	public HashSet<String> exitIds;
	
	public RoomComponent() {
		inhabitantIds = new HashSet<String>();
		exitIds = new HashSet<String>();
	}
	
	public void CleanUp(World world) throws EntityNotFoundException, ComponentNotFoundException  {
		String playerId = world.GetPlayer().getIdentityComponent().id;
		HashSet<String> originalIds = (HashSet<String>) inhabitantIds.clone();
		for(String id : originalIds) {
			if(id == playerId)
			{
				world.GetPlayer().getLocationComponent().roomId = null;
			}
			else
			{
				world.RemoveEntity(id);
			}
		}
		inhabitantIds.clear();
		
		originalIds = (HashSet<String>) exitIds.clone();
		for(String id : originalIds) {
			world.RemoveEntity(id);
		}
		exitIds.clear();
		
		ArrayList<PortalComponent> allExitComps = world.getAllComponents(PortalComponent.class);
		for(PortalComponent exit : allExitComps)
		{
			if(exit.destinationRoomId == entity.getIdentityComponent().id)
			{
				world.RemoveEntity(exit.entity.getIdentityComponent().id);
			}
		}
	}
}
