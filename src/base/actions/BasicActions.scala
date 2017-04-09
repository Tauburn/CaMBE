package base.actions

import base.objects.Actor

/**
  * Created by Dave on 09-Apr-17.
  */
object BasicActions {

  def remainingHitPoints(attacker: Actor, defender: Actor): BigInt = {
    //This will be extended later to encompass bonuses and the like
    defender.hitPoints - attacker.attack
  }
}
