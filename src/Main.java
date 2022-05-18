import java.util.*;
public class Main {

        static List<Student> student = new ArrayList<Student>();

        public static void main (String[]args) throws MenuException {
            menu(print_menu());

        }
        // Процедура работы с меню
        public static void menu ( int menu_item) throws MenuException {
            Comparator fio_comparator = new FIOComparator(); // компоратор по ФИО
            Comparator age_comparator = new AgeComparator(); // компаратор по возрасту
            switch (menu_item) {
                case 1:  //меню 1 - добавление студента
                    addStudent();
                    menu(print_menu());
                    break;
                case 2:  //меню 2 - сортировка по возрастанию ФИО и возрасту
                    Collections.sort(student, fio_comparator.thenComparing(age_comparator));
                    System.out.println(student.toString());
                    menu(print_menu());
                    break;
                case 3:  //меню 4 - сортировка по убыванию ФИО и возрасту
                    Collections.sort(student, fio_comparator.thenComparing(age_comparator).reversed());
                    System.out.println(student.toString());
                    menu(print_menu());
                    break;
                case 4: //меню 4 - удаление студента по индексу
                    for (Student student1 : student) { //цикл вывода списка студентов с индексами
                        System.out.println(student.indexOf(student1) + ". " + student1.toString());
                    }
                    ;
                    System.out.println("Enter student's index to delete");
                    Scanner scr = new Scanner(System.in);
                    int index = scr.nextInt();
                    student.remove(index); //удаление по индексу
                    System.out.println("Student with index " + index + " has deleted");
                    menu(print_menu());
                    break;
                case 5: //меню 5 - распечатка списка студентов
                    System.out.println(student);
                    menu(print_menu());
                    break;
                case 6: //меню 6 - выход из программы
                    System.exit(404);
                    break;
            }
        }


        // Вывод меню в консоль и возвращаем выбранное значение из консоли
        public static int print_menu () throws MenuException {
            System.out.println(
                    "1 Enter student \n" +
                            "2 Sort students in ascending order \n" +
                            "3 Sort students in descending order \n" +
                            "4 Delete student by index \n" +
                            "5 Print array \n" +
                            "6 Exit");

            System.out.println("Choose menu item: ");
            Scanner scr = new Scanner(System.in);
            int menu_item = scr.nextInt();
            try {
                if (menu_item <= 0 || menu_item > 6) {
                    throw new MenuException(menu_item);
                }
            } catch (MenuException me) {
                System.out.println(me.getMenu() + " - Invalid value, please try again!");
                System.out.println();
                menu(print_menu());

            }
            return menu_item;
        }

        // Процедура добавления студента
        public static void addStudent () {
            Enum favotite_class;
            Scanner scr = new Scanner(System.in);
            System.out.println("Enter FIO");
            String fio = scr.nextLine();
            System.out.println("Enter age");
            int age = scr.nextInt();

            System.out.println("Enter class number");
            String class_num = scr.next();
            System.out.println("Choose favorite class");
            System.out.println("1. " + Subject.BIOLOGY);
            System.out.println("2. " + Subject.CHEMISTRY);
            System.out.println("3. " + Subject.MATHEMATICS);
            System.out.println("4. " + Subject.INFORMATICS);
            int favorite = scr.nextInt();

            switch (favorite) {

                case 1:
                    Student student1 = new Student(fio, age, class_num, Subject.BIOLOGY);
                    if (student.contains(student1)) {
                        System.out.println("This student exist already. Try again.");
                        addStudent();
                    } else student.add(student1);
                    break;
                case 2:
                    student1 = new Student(fio, age, class_num, Subject.CHEMISTRY);
                    if (student.contains(student1)) {
                        System.out.println("This student exist already. Try again.");
                        addStudent();
                    } else student.add(student1);
                    break;
                case 3:
                    student1 = new Student(fio, age, class_num, Subject.MATHEMATICS);
                    if (student.contains(student1)) {
                        System.out.println("This student exist already. Try again.");
                        addStudent();
                    } else student.add(student1);
                    break;
                case 4:
                    student1 = new Student(fio, age, class_num, Subject.INFORMATICS);
                    if (student.contains(student1)) {
                        System.out.println("This student exist already. Try again.");
                        addStudent();
                    } else student.add(student1);
                    break;
            }
        }
}
