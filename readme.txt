After reading through the documentation and code I got a sense for the current style and standards of the project.
I decided to add as little as possible to make the changeset easily reviewable and keep the new code in the same style.
I tried to keep new code close to other relevant code and followed the same flow as the previous authors.

I added two helper methods to the Entity class for the two new Component classes I added.
I added the InventoryComponent class to keep track of the items the player has picked up.
I added the ItemComponent to distinguish between items and things.

I added 'createItem' to EntityFactory as a helper function for creating a new item in the style of the project.
I added InventoryComponent to the 'createPlayer' function in EntityFactory.

I added a response for the "createItem" command in InputProcessor that follows the style of the neighboring create commands.
I added a response for the "inventory" / "inv" / "i" command in InputProcessor right after the "look" command because they are both read commands.
I added responses for "get" / "take" and "drop" at the bottom of the command if-else chain that utilize three new helper methods at the bottom of the file.
These new methods allow for retrieval of entities and checking against null if they are not found in a similar fashion to 'Entity.getComponentOrNull'.

I also added 'worlds/world_test' in order to quickly test the functionality.