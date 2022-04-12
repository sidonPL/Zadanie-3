import java.io.IOException;
import java.util.Scanner;

class WrongChoice extends Exception {
}
class WrongStudentName extends Exception {
}
class WrongStudentAge extends Exception{
}
class ParseError extends Exception {
}
class WrongStudentDate extends Exception{
}
class Main {
  public static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      try {
      /*Service1 s = new Service1();
      s.addStudent(new Student("Krzysztof", 20));
      s.addStudent(new Student("Janusz", 40));

      var students = s.getStudents();
      for(Student current : students) {
        System.out.println(current.ToString());
      }*/
        int ex = menu();
        switch (ex) {
          case 1:
            exercise1();
            break;
          case 2:
            exercise2();
            break;
          default:
            return;
        }
      } catch (IOException e) {

      } catch (WrongStudentName e) {
        System.out.println("Błędne imię studenta!");
      } catch (WrongStudentAge e) {
        System.out.println("Błędny wiek studenta!");
      } catch (ParseError e) {
        System.out.println("Error");
      } catch (WrongChoice e) {
        System.out.println("Błędny wybór");
      } catch (WrongStudentDate e){
        System.out.println("Błędna data studenta");
      }
      }
    }
  public static int menu() throws WrongChoice {
    System.out.println();
    System.out.println("Wciśnij:");
    System.out.println("1 - aby dodać studenta");
    System.out.println("2 - aby wypisać wszystkich studentów");
    System.out.println("0 - aby wyjść z programu");
    return ReadChoice();
  }

  public static int ReadChoice() throws WrongChoice {
    String wybor = scan.nextLine();
    if (!wybor.equals("0") && !wybor.equals("1") && !wybor.equals("2"))
      throw new WrongChoice();
    return Integer.parseInt(wybor);
  }

  public static String ReadName() throws WrongStudentName {
    System.out.println("Podaj imię studenta: ");
    String name = scan.nextLine();
    if (name.contains(" "))
      throw new WrongStudentName();

    return name;
  }

  public static int ReadAge() throws WrongStudentAge {
    System.out.println("Podaj wiek studenta: ");
    int age = scan.nextInt();
    if (age > 100 || age < 0)
      throw new WrongStudentAge();
    else
      return age;
  }
  public static String ReadDate() throws WrongStudentDate {
    scan.nextLine();
    System.out.println("Podaj datę urodzenia studenta (DD-MM-YYYY): ");
    String date = scan.nextLine();
    if (date.length() != 10 || date.charAt(2) != '-' || date.charAt(5) != '-'
            || (date.charAt(0) > '3' && date.charAt(1) > '1') || (date.charAt(3) > '1' && date.charAt(4) > '2'))
      throw new WrongStudentDate();

    return date;
  }
  public static void exercise1() throws IOException, WrongStudentName, WrongStudentAge, WrongStudentDate {
    var name = ReadName();
    var age = ReadAge();
    var date = ReadDate();
    (new Service1()).addStudent(new Student(name, age, date));

  }
  public static void exercise2() throws IOException, ParseError {
    var students = (new Service1()).getStudents();
    for (Student current : students) {
      System.out.println(current.ToString());
    }
  }

}