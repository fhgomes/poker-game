package org.fernando.gg.core.services.contracts;

public interface IGameRoomManager {

	String createGame(String roomName);
	void deleteGame(String gameRef);
	void addDeckToGame(String gameRef);

}
