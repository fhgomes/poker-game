[![Build Status](https://app.travis-ci.com/fhgomes/poker-game.svg?branch=main)](https://app.travis-ci.com/fhgomes/poker-game)
[![Build Status Dev](https://app.travis-ci.com/fhgomes/poker-game.svg?branch=develop)](https://app.travis-ci.com/fhgomes/poker-game)

# Card Game 

This is a code practice 

# Assumptions

1 - I didn't identify a necessity or use to create a single deck and not use it.
So i decide to provide through API just add deck for now

2 - once the game is started, it's not possible to join

3 - it will be more view request them the play requests

4 - assuming the rule "53rd call" its to not throw an error, and cards are empty.
Other interpretation can be that a player can't receive more than 52 cards, then it will be other implementation

5 - it's not clear if it's possible to joing after a game has started, so i will not block
5.1 the same for adding new decks

6 - for now its not possible to reset cards e redistribute cards, we can implement it later

# Instructions

## Postman

./others/postman has a collection that can be used to manually test

## Build

> chmod -R +x ./mvnw

> ./mvnw clean install

## Build Docker Image

docker build -t fernandosgomes/poker-game . --build-arg VERSAO=1.0.0-SNAPSHOT
(i have not tested because my destkop pc has broken, my notebook has some issues with docker)

it's simple, so its supposed to work

## Using compose

> docker-compose -f docker-compose.yml up -d

It's using the image, but can be change to . (to build it)

