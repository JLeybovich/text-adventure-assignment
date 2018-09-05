package pocketgems.mud.components;

import pocketgems.mud.Entity;
import pocketgems.mud.World;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

/*
 * Component
 * =========
 * A component contains data, and is owned by an Entity. Components should primarily define state, and
 * may include some methods to help manage the state. However, avoid putting game logic into components.
 */
public abstract class Component {
	Entity entity;
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	public Entity getEntity() { return entity; }
	public void CleanUp(World world) throws EntityNotFoundException, ComponentNotFoundException  {}
}
