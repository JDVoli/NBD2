object Main {

    def zad1(x: String) : String = x match {

      case "Poniedzialek" => "Praca"
      case "Wtorek" => "Praca"
      case "Sroda" => "Praca"
      case "Czwartek" => "Praca"
      case "Piatek" => "Praca"
      case "Sobota" => "Weekend"
      case "Niedziela" => "Weekend"
      case _ => "Nie ma takiego dnia"
    }

    class KontoBankowe(stanPoczatkowy: Double)
    {
      private var stanKonta = stanPoczatkowy

      def this()
      {
        this(0)
      }

      def wplata(wplata: Double)
      {
        stanKonta += wplata
      }

      def wyplata(wyplata: Double)
      {
        if(wyplata <= stanKonta)
        {
          stanKonta -= wyplata
        }

      }

      def getStanKonta : Double = stanKonta
    }

    def zad2(){

      println("Poczatkowy stan konta bankowego wynosi: 1000")
      val k1 = new KontoBankowe(1000)
      println("Pobranie stanu konta : " + k1.getStanKonta)
      k1.wplata(100)
      println("Następuje wpłata w wysokości 100")
      println("Pobranie stanu konta : " + k1.getStanKonta)
      k1.wyplata(50)
      println("Następuje wypłata w wysokości 50")
      println("Pobranie stanu konta : " + k1.getStanKonta)
      println("Następuje wypłata w wysokości 2500")
      k1.wyplata(2500)
      println("Pobranie stanu konta : " + k1.getStanKonta)
    }

    case class Osoba(imie: String, nazwisko: String)

    def zad3()
    {
      val o1 = Osoba("Harry", "Potter")
      val o2 = Osoba("Pawel", "Pawlowski")
      val o3 = Osoba("Nick", "To")

      zad3_patternMatching(o1)
      zad3_patternMatching(o2)
      zad3_patternMatching(o3)

    }

    def zad3_patternMatching(x: Osoba): Unit = x match
    {
      case Osoba("Harry", _) => println("Na mą duszę to on! Cześć Harry")
      case Osoba(_,"Pawlowski") => println("Szalom Pawel! Ile dzisiaj chcesz wplacic?")
      case Osoba(imie, nazwisko) => println(s"Dzień dobry, $imie $nazwisko")

    }



    def main(args: Array[String]):Unit ={
      println("\n====== ZADANIE 1 ======")
      println("\nPiatek - " + zad1("Piatek"))
      println("Sobota - " + zad1("Sobota"))
      println("PonSob - " + zad1("PonSob"))
      println("Sobota - " + zad1("Sobota"))

      println("\n====== ZADANIE 2 ======")
      zad2()

      println("\n====== ZADANIE 3 ======")
      zad3()
    }


}
