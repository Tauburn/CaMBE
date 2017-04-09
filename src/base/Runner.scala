package base

import base.battleSet.Battle
import base.objects.{Monster, PlayerCharacter}

/**
  * Created by Dave on 09-Apr-17.
  */
object Runner extends App {

  val monster = Monster("Slime", 100, 5)
  val character = PlayerCharacter("Ronald", 100, 10)

  val battle = Battle(character, monster)

  battle.battle()

}
