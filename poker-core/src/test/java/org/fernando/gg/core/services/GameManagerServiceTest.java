package org.fernando.gg.core.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.fernando.gg.core.repository.GameInMemoryManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameManagerServiceTest {

	@InjectMocks
	GameManagerService target;

	@Mock
	GameInMemoryManager gamesControl;

	@Test
	@DisplayName("When given gameName, should create game")
	void createGame() {
		assertDoesNotThrow(() -> target.createGame("newGame01"));
	}

	@Test
	@DisplayName("When given gameRef, should delete game")
	void deleteGame() {
		assertDoesNotThrow(() -> target.deleteGame("REF123"));
	}

}