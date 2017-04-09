package base.objects

/**
  * Created by Dave on 09-Apr-17.
  */
trait Actor {
  val name: String
  val hitPoints: BigInt
  val attack: BigInt
}

case class PlayerCharacter(name: String, hitPoints: BigInt, attack: BigInt) extends Actor
case class Monster(name: String, hitPoints: BigInt, attack: BigInt) extends Actor
