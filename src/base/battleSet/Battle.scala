package base.battleSet

import base.actions.BasicActions
import base.objects.Actor

/**
  * Created by Dave on 09-Apr-17.
  */
//I'd like to use the Set for characters here so no duplicates but 'target' will be enemies therefore no Set
case class Battle(characters: Set[Actor], enemies: List[Actor]) {

  val turnOrder: List[Actor] = (characters ++ enemies).toList.sortBy(x => x.speed)

  def battle(): Unit = {

    def innerBattle(actorAttackOrder: List[Actor]) {
      println(s"${actorAttackOrder.head.name} currently has ${actorAttackOrder.head.hitPoints} hit points remaining")
      println(s"${actorAttackOrder(1).name} currently has ${actorAttackOrder(1).hitPoints} hit points remaining")

      //NB the | character is typed using ALT and 124
      if (actorAttackOrder.head.hitPoints <= 0 || actorAttackOrder(1).hitPoints <= 0) {
        println("Winner decided!")
      }

      else {
        val firstPlace = actorAttackOrder.head.copy(hitPoints = BasicActions.remainingHitPoints(actorAttackOrder(1), actorAttackOrder.head))
        val secondPlace = actorAttackOrder(1).copy(hitPoints = BasicActions.remainingHitPoints(actorAttackOrder.head, actorAttackOrder(1)))
        innerBattle(List(firstPlace, secondPlace))
      }
    }

    innerBattle(turnOrder)
  }
}
