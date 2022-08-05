package org.fernando.gg.core.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.fernando.gg.core.domain.GameRoom;
import org.fernando.gg.core.repository.GameInMemoryManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GamePlayersServiceTest {

	@InjectMocks
	GamePlayersService target;

	@Mock
	GameManagerService gamesControl;

	@Mock
	GameRoom gameMock;

	@Test
	@DisplayName("When given gameRef and player, should join game")
	void joinGame() {
		when(gamesControl.retrieveGame("REF123")).thenReturn(gameMock);
		assertDoesNotThrow(() -> target.joinGame("REF123", "Fernando"));
	}

	@Test
	@DisplayName("When given gameRef and player, should leave game")
	void leaveGame() {
		when(gamesControl.retrieveGame("REF123")).thenReturn(gameMock);
		assertDoesNotThrow(() -> target.leaveGame("REF123", "Fernando"));
	}
}