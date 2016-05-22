package hw4.stud;

import java.util.Comparator;

/**Created by root*/

public class Student implements Comparable<Student>, Comparator<Student> {

    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String dateOfBirth;
    private String address;
    private String phoneNumber;
    private String faculty;
    private int course;
    private String group;

    public static Student[] students;

    static String[] surnames = {"Смирнов", "Иванов", "Кузнецов", "Соколов", "Попов", "Лебедев", "Козлов", "Новиков", "Морозов", "Петров", "Волков", "Соловьёв", "Васильев", "Зайцев", "Павлов", "Семёнов", "Голубев", "Виноградов", "Богданов", "Воробьёв", "Фёдоров", "Михайлов", "Беляев", "Тарасов", "Белов", "Комаров", "Орлов", "Киселёв", "Макаров", "Андреев", "Ковалёв", "Ильин", "Гусев", "Титов", "Кузьмин", "Кудрявцев", "Баранов", "Куликов", "Алексеев", "Степанов", "Яковлев", "Сорокин", "Сергеев", "Романов", "Захаров", "Борисов", "Королёв", "Герасимов", "Пономарёв", "Григорьев", "Лазарев", "Медведев", "Ершов", "Никитин", "Соболев", "Рябов", "Поляков", "Цветков", "Данилов", "Жуков", "Фролов", "Журавлёв", "Николаев", "Крылов", "Максимов", "Сидоров", "Осипов", "Белоусов", "Федотов", "Дорофеев", "Егоров", "Матвеев", "Бобров", "Дмитриев", "Калинин", "Анисимов", "Петухов", "Антонов", "Тимофеев", "Никифоров", "Веселов", "Филиппов", "Марков", "Большаков", "Суханов", "Миронов", "Ширяев", "Александров", "Коновалов", "Шестаков", "Казаков", "Ефимов", "Денисов", "Громов", "Фомин", "Давыдов", "Мельников", "Щербаков", "Блинов", "Колесников", "Карпов", "Афанасьев", "Власов", "Маслов", "Исаков", "Тихонов", "Аксёнов", "Гаврилов", "Родионов", "Котов", "Горбунов", "Кудряшов", "Быков", "Зуев", "Третьяков", "Савельев", "Панов", "Рыбаков", "Суворов", "Абрамов", "Воронов", "Мухин", "Архипов", "Трофимов", "Мартынов", "Емельянов", "Горшков", "Чернов", "Овчинников", "Селезнёв", "Панфилов", "Копылов", "Михеев", "Галкин", "Назаров", "Лобанов"};
    static String[] names = {"Абрам", "Август", "Авдей", "Аверкий", "Авксентий", "Авраам", "Автоном", "Агап", "Агафон", "Аггей", "Агей", "Адам", "Адриан", "Азарий", " Аким", " Александр", " Алексей", " Амвросий", " Амос", " Ананий", " Анатолий", " Андрей", " Андриан", " Андрон", " Андроник", " Аникей", " Аникита", " Анисим", " Онисим", " Антип", " Антон", " Антонин", " Аполлинарий", " Аполлон", " Арефий", " Аристарх", " Аркадий", " Арсен", " Арсений", " Артем", " Артём", " Артемий", " Архип", " Аскольд", " Афанасий", " Афиноген", " Бажен", " Богдан", " Болеслав", " Борис", " Борислав", " Боян", " Бронислав", " Будимир", " Вадим", " Валентин", " Валерий", " Валерьян", " Варлаам", " Варлам", " Варфоломей", " Василий", " Василиск", " Велимир", " Венедикт", " Вениамин", " Викентий", " Виктор", " Викторин", " Виссарион", " Виталий", " Владилен", " Владлен", " Владимир", " Владислав", " Влас", " Всеволод", " Всемил", " Всеслав", " Вышеслав", " Вячеслав", " Вадим", " Валентин", " Валерий", " Валерьян", " Варлаам", " Варлам", " Варфоломей", " Василий", " Василиск", " Велимир", " Венедикт", " Вениамин", " Викентий", " Виктор", " Викторин", " Виссарион", " Виталий", " Владилен", " Владлен", " Владимир", " Владислав", " Влас", " Всеволод", " Всемил", " Всеслав", " Вышеслав", " Вячеслав", " Гавриил", " Гаврила", " Галактион", " Гедеон", " Геннадий", " Георгий", " Егор", " Герасим", " Герман", " Глеб", " Гордей", " Гостомысл", " Гремислав", " Григорий", " Гурий", " Давыд", " Давид", " Даниил", " Даниил", " Данила", " Дементий", " Демид", " Демьян", " Денис", " Дмитрий", " Добромысл", " Доброслав", " Дорофей "};
    static String[] middleNames = {"Ааронович", "Абрамович", "Августович", "Авдеевич", "Аверьянович", "Адамович", "Адрианович", "Аксёнович", "Александрович", "Алексеевич", "Анатольевич", "Андреевич", "Анисимович", "Антипович", "Антонович", "Ануфриевич", "Арсенович", "Арсеньевич", "Артёмович", "Артемьевич", "Артурович", "Архипович", "Афанасьевич", "Бенедиктович", "Богданович", "Бориславич", "Бориславович", "Борисович", "Брониславович", "Вадимович", "Валентинович", "Валерианович", "Валерьевич", "Валерьянович", "Васильевич", "Венедиктович", "Вениаминович", "Викентьевич", "Викторович", "Виленович", "Вилорович", "Витальевич", "Владиленович", "Владимирович", "Владиславович", "Владленович", "Власович", "Всеволодович", "Вячеславович", "Гавриилович", "Гаврилович", "Геннадиевич", "Георгиевич", "Герасимович", "Германович", "Гертрудович", "Глебович", "Гордеевич", "Григорьевич", "Гурьевич", "Давидович", "Давыдович", "Даниилович", "Данилович", "Демидович", "Демьянович", "Денисович", "Димитриевич", "Дмитриевич", "Дорофеевич", "Евсеевич", "Евстигнеевич", "Егорович", "Елизарович", "Елисеевич", "Еремеевич", "Ермилович", "Ермолаевич", "Ерофеевич", "Ефимович", "Ефимьевич", "Ефремович", "Ефстафьевич", "Жанович", "Жоресович", "Захарьевич", "Зиновьевич", "Игнатович", "Игнатьевич", "Игоревич", "Измаилович", "Изотович", "Иларионович", "Ильич", "Ильясович", "Иосипович", "Иосифович", "Исидорович", "Марсович", "Матвеевич", "Михайлович", "Петрович", "Семёнович", "Сидорович", "Тарасович", "Теймуразович", "Терентьевич", "Тимурович", "Тихонович", "Трифонович", "Трофимович", "Устинович", "Фадеевич", "Фёдорович", "Федосеевич", "Федосьевич", "Федотович", "Феликсович", "Феодосьевич", "Феоктистович", "Феофанович", "Филатович", "Филимонович", "Филиппович", "Фокич", "Фомич", "Фролович", "Харитонович", "Харламович", "Харлампович", "Харлампьевич", "Чеславович", "Эдгардович", "Эдгарович", "Эдуардович", "Юлианович"};
    static String[] cities = {"Киев", "Харьков", "Одесса", "Днепропетровск", "Донецк", "Запорожье", "Львов", "Кривой Рог", "Николаев", "Мариуполь", "Луганск", "Севастополь", "Винница", "Макеевка", "Симферополь", "Херсон", "Полтава", "Чернигов", "Черкассы", "Житомир", "Сумы", "Хмельницкий", "Горловка", "Ровно", "Кировоград", "Днепродзержинск", "Черновцы", "Кременчуг", "Ивано-Франковск", "Тернополь", "Белая Церковь", "Луцк", "Краматорск", "Мелитополь", "Керчь", "Никополь", "Северодонецк", "Славянск", "Бердянск", "Ужгород", "Алчевск", "Павлоград", "Евпатория", "Лисичанск", "Каменец-Подольский"};
    static String[] operatorCodes = {"93", "66", "95", "67", "97", "98", "99", "63", "73", "68"};
    static String[] faculties = {"Электроэнэргетический", "Машиностроительный", "Компьютерных технологий", "Органическая химия", "Физико-математический"};
    static int[]groups = { 11, 21, 31};

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

    public Student(int id, String surname, String name, String middleName, String dateOfBirth, String address, String phoneNumber, String faculty, int course, String group){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.group = group;
    }
    public Student(int id){
        this.id = id;
        this.surname = autoSurname();
        this.name = autoName();
        this.middleName = autoMiddleName();
        this.dateOfBirth = autoDateOfBirth();
        this.address = autoAddress();
        this.phoneNumber = autoPhoneNumber();
        this.faculty = autoFaculty();
        this.course = autoCourse();
        this.group = autoGroup(this.faculty);
    }

    @Override
    public String toString() {
        return "["+id+" "+surname+" "+name+" "+middleName+" "+dateOfBirth+" "+"г."+address+" "+phoneNumber+" "+faculty+" "+course+" "+group+"]";
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
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
        return cities[random(0, cities.length - 1)];
    }

    public static String autoPhoneNumber(){
        return "+38(0"+ operatorCodes[random(0, operatorCodes.length - 1)]+")"+random(1111111, 9999999);
    }

    public static String autoFaculty(){
        return faculties[random(0, (faculties.length - 1))];
    }

    public static int autoCourse(){
        return random(1,5);
    }

    public static String autoGroup(String faculty){
        String group = Character.toString(faculty.charAt(0))+"-"+groups[random(0,(groups.length - 1))];
        return group;
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }
    @Override
    public int compare(Student o1, Student o2) {
        return o1.group.compareTo(o2.group);
    }
}

