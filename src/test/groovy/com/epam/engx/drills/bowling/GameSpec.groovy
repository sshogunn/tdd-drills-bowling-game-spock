package com.epam.engx.drills.bowling

import spock.lang.Specification


class GameSpec extends Specification {
    def game = new Game()

    def "should have zero score when we roll zero every time"() {
        when:
        roll(0, 20)

        then:
        this.game.getScore() == 0
    }

    def "should twenty score when we roll one every time"() {
        when:
        roll(1, 20)

        then:
        game.getScore() == 20
    }

    def "should double roll after spare" () {
        when:
        game.roll(4)
        game.roll(6)
        game.roll(3)
        roll(0, 17)

        then:
        game.getScore() == 16
    }

    def "should not double roll when spare happens in not the same frame"() {
        when:
        game.roll(0)
        game.roll(6)
        game.roll(4)
        game.roll(3)
        roll(0, 16)
        then:
        game.getScore() == 13
    }

    def "should double next frame when strike happens" () {
        when:
        game.roll(10)
        game.roll(4)
        game.roll(3)
        roll(0, 16)

        then:
        game.getScore() == 24
    }

    private void roll(int pins, int times) {
        for (int i = 0; i < times; i++) {
            game.roll(pins)
        }
    }


}