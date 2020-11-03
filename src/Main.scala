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

    class KontoBankowe(val stanPoczatkowy: Double)
    {
      private var _stanKonta = stanPoczatkowy

      def this()
      {
        this(0)
      }

      def wplata(wplata: Double)
      {
        _stanKonta += wplata
      }

      def wyplata(wyplata: Double)
      {
        if(wyplata <= _stanKonta)
        {
          _stanKonta -= wyplata
        }

      }

      def stanKonta : Double = _stanKonta
    }

    def zad2(){

      println("Poczatkowy stan konta bankowego wynosi: 1000")
      val k1 = new KontoBankowe(1000)
      println("Pobranie stanu konta : " + k1.stanKonta)
      k1.wplata(100)
      println("Następuje wpłata w wysokości 100")
      println("Pobranie stanu konta : " + k1.stanKonta)
      k1.wyplata(50)
      println("Następuje wypłata w wysokości 50")
      println("Pobranie stanu konta : " + k1.stanKonta)
      println("Następuje wypłata w wysokości 2500")
      k1.wyplata(2500)
      println("Pobranie stanu konta : " + k1.stanKonta)
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

    def zad4(x : Int, f: Int => Int):Int = f(f(f(x)))
    def foo_for_4(n: Int):Int = n * 2

    class Person(val firstName: String, val lastName: String){
      private var _tax : Double = 0
      def tax : Double = _tax
    }

    trait Student extends Person{
      override def tax: Double = 0
    }

    trait Pracownik extends Person{
      private var _pensja : Double = 0

      def pensja : Double = _pensja
      def pensja_= (value:Double):Unit=_pensja=value

      override def tax: Double = _pensja * 0.2
    }

    trait Nauczyciel extends Pracownik{
      override def tax : Double = pensja * 0.1

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

      println("\n====== ZADANIE 4 ======")
      println("Wynik: " + zad4(2, foo_for_4))

      println("\n====== ZADANIE 5 ======")

      val stud = new Person("Paweł", "Pawłowski") with Student
      val prac = new Person("Ala", "Alowska") with Pracownik
      prac.pensja = 4000

      val naucz = new Person("Daniel", "Jabłoński") with Nauczyciel
      naucz.pensja = 4000

      println("Student: " + stud.firstName + " " + stud.lastName + " musi zapłacić: "  + stud.tax + " Simoleonów podatku")
      println("Pracownik: " + prac.firstName + " " + prac.lastName + " musi zapłacić: "  + prac.tax + " Simoleonów podatku")
      println("Nauczyciel: " + naucz.firstName + " " + naucz.lastName + " musi zapłacić: "  + naucz.tax + " Simoleonów podatku")

      val tr1 = new Person("Jan", "Janowski") with Student with Pracownik
      tr1.pensja = 10000
      println("\nNajpierw trait Student potem Pracownik - podatek: "+tr1.tax + " z pensji: " + tr1.pensja)

      val tr2 = new Person("Klaudiusz", "Sevković") with Pracownik with Student
      tr2.pensja = 8000
      println("Najpierw trait Pracownik potem Student - podatek: " + tr2.tax + "z pensji: " + tr2.pensja)
    }


}
