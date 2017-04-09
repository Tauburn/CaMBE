package base.battleSet

import base.objects.{Actor, Monster, PlayerCharacter}
import base.actions.BasicActions

/**
  * Created by Dave on 09-Apr-17.
  */
//I'd like to use the Set for characters here so no duplicates but 'target' will be enemies therefore no Set
case class Battle(character: PlayerCharacter, target: Monster) {

  val turnOrder: List[Actor] = List(character, target)

  def battle(): Unit = {
    //NB the | character is typed using ALT and 124
    while (character.hitPoints >= 0 || target.hitPoints >= 0) {
      turnOrder(1).asInstanceOf[Monster].copy(hitPoints = BasicActions.remainingHitPoints(turnOrder.head, turnOrder(1)))
      turnOrder.head.asInstanceOf[PlayerCharacter].copy(hitPoints = BasicActions.remainingHitPoints(turnOrder(1), turnOrder.head))
      println(s"Character currently has ${turnOrder.head.hitPoints} hit points remaining")
      println(s"Monster currently has ${turnOrder(1).hitPoints} hit points remaining")
    }
  }
}
