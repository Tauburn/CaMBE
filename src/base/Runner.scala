package base

import base.battleSet.Battle
import base.objects.Actor

/**
  * Created by Dave on 09-Apr-17.
  */
object Runner extends App {

  val monster = Actor("Slime", 100, 5, 3)
  val character = Actor("Ronald", 100, 10, 5)

  val battle = Battle(Set(character), List(monster))

  battle.battle()

}
