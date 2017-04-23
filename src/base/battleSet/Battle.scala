package base.battleSet

import base.objects.{Actor, Monster, PlayerCharacter}
import base.actions.BasicActions

/**
  * Created by Dave on 09-Apr-17.
  */
//I'd like to use the Set for characters here so no duplicates but 'target' will be enemies therefore no Set
case class Battle(character: PlayerCharacter, target: Monster) {

  def battle(): Unit = {

    def innerBattle(turnOrder: List[Actor]) {
      println(s"Character currently has ${turnOrder.head.hitPoints} hit points remaining")
      println(s"Monster currently has ${turnOrder(1).hitPoints} hit points remaining")

      //NB the | character is typed using ALT and 124
      if (turnOrder.head.hitPoints <= 0 || turnOrder(1).hitPoints <= 0) {
        println("Winner decided!")
      }
      else {
        val secondPlace = turnOrder(1).asInstanceOf[Monster].copy(hitPoints = BasicActions.remainingHitPoints(turnOrder.head, turnOrder(1)))
        val firstPlace = turnOrder.head.asInstanceOf[PlayerCharacter].copy(hitPoints = BasicActions.remainingHitPoints(turnOrder(1), turnOrder.head))
        innerBattle(List(firstPlace, secondPlace))
      }
    }
    innerBattle(List(character, target))
  }
}
