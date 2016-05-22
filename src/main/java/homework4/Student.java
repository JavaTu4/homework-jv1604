package homework4;

import java.util.ArrayList;

/**
 * Created by root on 26.04.16.
 */
public class Student {
   public static ArrayList<Student> students = new ArrayList<Student>();

    int id;
    String surname;
    String name;
    String middleName;
    String dateOfBirth;
    String address;
    String phoneNumber;
    String faculty;
    int course;
    String group;

    public static String[] surnames = {"Смирнов", "Иванов", "Кузнецов", "Соколов", "Попов", "Лебедев", "Козлов", "Новиков", "Морозов", "Петров", "Волков", "Соловьёв", "Васильев", "Зайцев", "Павлов", "Семёнов", "Голубев", "Виноградов", "Богданов", "Воробьёв", "Фёдоров", "Михайлов", "Беляев", "Тарасов", "Белов", "Комаров", "Орлов", "Киселёв", "Макаров", "Андреев", "Ковалёв", "Ильин", "Гусев", "Титов", "Кузьмин", "Кудрявцев", "Баранов", "Куликов", "Алексеев", "Степанов", "Яковлев", "Сорокин", "Сергеев", "Романов", "Захаров", "Борисов", "Королёв", "Герасимов", "Пономарёв", "Григорьев", "Лазарев", "Медведев", "Ершов", "Никитин", "Соболев", "Рябов", "Поляков", "Цветков", "Данилов", "Жуков", "Фролов", "Журавлёв", "Николаев", "Крылов", "Максимов", "Сидоров", "Осипов", "Белоусов", "Федотов", "Дорофеев", "Егоров", "Матвеев", "Бобров", "Дмитриев", "Калинин", "Анисимов", "Петухов", "Антонов", "Тимофеев", "Никифоров", "Веселов", "Филиппов", "Марков", "Большаков", "Суханов", "Миронов", "Ширяев", "Александров", "Коновалов", "Шестаков", "Казаков", "Ефимов", "Денисов", "Громов", "Фомин", "Давыдов", "Мельников", "Щербаков", "Блинов", "Колесников", "Карпов", "Афанасьев", "Власов", "Маслов", "Исаков", "Тихонов", "Аксёнов", "Гаврилов", "Родионов", "Котов", "Горбунов", "Кудряшов", "Быков", "Зуев", "Третьяков", "Савельев", "Панов", "Рыбаков", "Суворов", "Абрамов", "Воронов", "Мухин", "Архипов", "Трофимов", "Мартынов", "Емельянов", "Горшков", "Чернов", "Овчинников", "Селезнёв", "Панфилов", "Копылов", "Михеев", "Галкин", "Назаров", "Лобанов"};
    public static String[] names = {"Абрам", "Август", "Авдей", "Аверкий", "Авксентий", "Авраам", "Автоном", "Агап", "Агафон", "Аггей", "Агей", "Адам", "Адриан", "Азарий", " Аким", " Александр", " Алексей", " Амвросий", " Амос", " Ананий", " Анатолий", " Андрей", " Андриан", " Андрон", " Андроник", " Аникей", " Аникита", " Анисим", " Онисим", " Антип", " Антон", " Антонин", " Аполлинарий", " Аполлон", " Арефий", " Аристарх", " Аркадий", " Арсен", " Арсений", " Артем", " Артём", " Артемий", " Архип", " Аскольд", " Афанасий", " Афиноген", " Бажен", " Богдан", " Болеслав", " Борис", " Борислав", " Боян", " Бронислав", " Будимир", " Вадим", " Валентин", " Валерий", " Валерьян", " Варлаам", " Варлам", " Варфоломей", " Василий", " Василиск", " Велимир", " Венедикт", " Вениамин", " Викентий", " Виктор", " Викторин", " Виссарион", " Виталий", " Владилен", " Владлен", " Владимир", " Владислав", " Влас", " Всеволод", " Всемил", " Всеслав", " Вышеслав", " Вячеслав", " Вадим", " Валентин", " Валерий", " Валерьян", " Варлаам", " Варлам", " Варфоломей", " Василий", " Василиск", " Велимир", " Венедикт", " Вениамин", " Викентий", " Виктор", " Викторин", " Виссарион", " Виталий", " Владилен", " Владлен", " Владимир", " Владислав", " Влас", " Всеволод", " Всемил", " Всеслав", " Вышеслав", " Вячеслав", " Гавриил", " Гаврила", " Галактион", " Гедеон", " Геннадий", " Георгий", " Егор", " Герасим", " Герман", " Глеб", " Гордей", " Гостомысл", " Гремислав", " Григорий", " Гурий", " Давыд", " Давид", " Даниил", " Даниил", " Данила", " Дементий", " Демид", " Демьян", " Денис", " Дмитрий", " Добромысл", " Доброслав", " Дорофей "};
    public static String[] middleNames = {"Ааронович", "Абрамович", "Августович", "Авдеевич", "Аверьянович", "Адамович", "Адрианович", "Аксёнович", "Александрович", "Алексеевич", "Анатольевич", "Андреевич", "Анисимович", "Антипович", "Антонович", "Ануфриевич", "Арсенович", "Арсеньевич", "Артёмович", "Артемьевич", "Артурович", "Архипович", "Афанасьевич", "Бенедиктович", "Богданович", "Бориславич", "Бориславович", "Борисович", "Брониславович", "Вадимович", "Валентинович", "Валерианович", "Валерьевич", "Валерьянович", "Васильевич", "Венедиктович", "Вениаминович", "Викентьевич", "Викторович", "Виленович", "Вилорович", "Витальевич", "Владиленович", "Владимирович", "Владиславович", "Владленович", "Власович", "Всеволодович", "Вячеславович", "Гавриилович", "Гаврилович", "Геннадиевич", "Георгиевич", "Герасимович", "Германович", "Гертрудович", "Глебович", "Гордеевич", "Григорьевич", "Гурьевич", "Давидович", "Давыдович", "Даниилович", "Данилович", "Демидович", "Демьянович", "Денисович", "Димитриевич", "Дмитриевич", "Дорофеевич", "Евсеевич", "Евстигнеевич", "Егорович", "Елизарович", "Елисеевич", "Еремеевич", "Ермилович", "Ермолаевич", "Ерофеевич", "Ефимович", "Ефимьевич", "Ефремович", "Ефстафьевич", "Жанович", "Жоресович", "Захарьевич", "Зиновьевич", "Игнатович", "Игнатьевич", "Игоревич", "Измаилович", "Изотович", "Иларионович", "Ильич", "Ильясович", "Иосипович", "Иосифович", "Исидорович", "Марсович", "Матвеевич", "Михайлович", "Петрович", "Семёнович", "Сидорович", "Тарасович", "Теймуразович", "Терентьевич", "Тимурович", "Тихонович", "Трифонович", "Трофимович", "Устинович", "Фадеевич", "Фёдорович", "Федосеевич", "Федосьевич", "Федотович", "Феликсович", "Феодосьевич", "Феоктистович", "Феофанович", "Филатович", "Филимонович", "Филиппович", "Фокич", "Фомич", "Фролович", "Харитонович", "Харламович", "Харлампович", "Харлампьевич", "Чеславович", "Эдгардович", "Эдгарович", "Эдуардович", "Юлианович"};
    public static String[] cities = {"Киев", "Харьков", "Одесса", "Днепропетровск", "Донецк", "Запорожье", "Львов", "Кривой Рог", "Николаев", "Мариуполь", "Луганск", "Севастополь", "Винница", "Макеевка", "Симферополь", "Херсон", "Полтава", "Чернигов", "Черкассы", "Житомир", "Сумы", "Хмельницкий", "Горловка", "Ровно", "Кировоград", "Днепродзержинск", "Черновцы", "Кременчуг", "Ивано-Франковск", "Тернополь", "Белая Церковь", "Луцк", "Краматорск", "Мелитополь", "Керчь", "Никополь", "Северодонецк", "Славянск", "Бердянск", "Ужгород", "Алчевск", "Павлоград", "Евпатория", "Лисичанск", "Каменец-Подольский"};
    public static String[] operatorCodes = {"93", "66", "95", "67", "97", "98", "99", "63", "73", "68"};
    public static String[] faculties = {"Электроэнэргетический", "Машиностроительный", "Компьютерных технологий", "Органическая химия", "Физико-математический"};

    public  int getId() {
        return id;
    }
    public  void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }

    public Student(int id, String surname, String name, String middleName, String dateOfBirth, String address, String phoneNumber, String faculty, int course){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = autoGroup();
        students.add(this);
    }

    public Student(){
        id = autoId(students.size());
        surname = autoSurname();
        name = autoName();
        middleName = autoMiddleName();
        dateOfBirth = autoDateOfBirth();
        address = autoAddress();
        phoneNumber = autoPhoneNumber();
        faculty = autoFaculty();
        course = autoCourse();
        group = autoGroup();
        students.add(this);
    }

    @Override
    public String toString(){
        return "\n"+"\n"+id +"\t"+surname+"\t"+name+"\t"+middleName +"\t"+ dateOfBirth+"\t"+address+"\t"+phoneNumber+"\t"+faculty+"\t"+course+"\t"+group;
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }

    public static int autoId(int previousId){
        return previousId++;
    }

    public static String autoSurname(){
        return surnames[random(0,surnames.length - 1)];
    }

    public static String autoName(){
        return names[random(0, names.length - 1)];
    }

    public static String autoMiddleName(){
        return middleNames[random(0, middleNames.length - 1)];
    }

    public static String autoDateOfBirth(){
        int day = random(1,31);
        int mounth = random(1,12);
        int year = random(1966,1999);
        return year+"."+mounth+"."+day;
    }

    public static String autoAddress(){
        return cities[random(0,cities.length - 1)];
    }

    public static String autoPhoneNumber(){
        return "+38 (0"+operatorCodes[random(0,operatorCodes.length - 1)]+") "+random(1111111, 9999999);
    }

    public static String autoFaculty(){
        return faculties[random(0,faculties.length - 1)];
    }

    public static int autoCourse(){
        return random(1,5);
    }

    public String autoGroup(){
        String course;

        if (this.faculty == faculties[0]){
            course = "Э-"+this.course;
        }
        else if (this.faculty == faculties[1]){
            course = "M-"+this.course;
        }
        else if (this.faculty == faculties[2]){
            course = "K-"+this.course;
        }
        else if (this.faculty == faculties[3]){
            course = "O-"+this.course;
        }
        else{
            course = "Ф-"+this.course;
        }
        return course;
    }



    public static void listOfFaculty(String faculty){
        ArrayList<Student> studentsOfFaculty = new ArrayList<Student>();
        for (int i = 0;i < students.size();i++){
            if (students.get(i).faculty == faculty) {
                studentsOfFaculty.add(students.get(i));
            }
        }
        System.out.println(studentsOfFaculty);
    }

    public static void listsOfFacultiesAndCourses(){
        ArrayList<Student> listOfFaculties = new ArrayList<Student>();
        ArrayList<Student> listOfCourses = new ArrayList<Student>();
        for (int j = 0;j < faculties.length;j++){
            for (int i = 0;i < students.size();i++){
                if (students.get(i).faculty == faculties[j]){
                    listOfFaculties.add(students.get(i));
                }
            }
        }
        for (int j = 0;j <= 5;j++) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).course == j) {
                    listOfCourses.add(students.get(i));
                }
            }
        }
        System.out.println("Факультеты");
        System.out.println(listOfFaculties);

        System.out.println("Курсы");
        System.out.println(listOfCourses);
    }

    public static void afterYear(int year){
        ArrayList<Student> listOfAfterYear = new ArrayList<Student>();
        for (int i = 0;i < students.size();i++) {
            int stYear;
            stYear = Integer.parseInt(students.get(i).dateOfBirth.substring(0,4));
            if (stYear > year) {
                listOfAfterYear.add(students.get(i));
            }
        }
        System.out.println(listOfAfterYear);
    }
    public static void listOfgroup(){
        ArrayList<Student> listOfGroup = new ArrayList<Student>();
        for (int i = 0;i < students.size();i++){
            for (int j = i + 1;j < students.size() - 1;j++){
                if (students.get(i).group.equals(students.get(j).group)) {
                    listOfGroup.add(students.get(i));
                    listOfGroup.add(students.get(j));
                }
            }
        }
        System.out.println(listOfGroup);
    }
}

