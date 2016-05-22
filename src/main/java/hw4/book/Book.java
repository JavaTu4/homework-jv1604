package hw4.book;

/**
 * Created by root.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private String publishingHouse;
    private int yearOfEdition;
    private int numberOfPages;
    private int price;
    private String typeOfCover;

    public static Book[]books;

    static String[] surnames = {"Смирнов", "Иванов", "Кузнецов", "Соколов", "Попов", "Лебедев", "Козлов", "Новиков", "Морозов", "Петров", "Волков", "Соловьёв", "Васильев", "Зайцев", "Павлов", "Семёнов", "Голубев", "Виноградов", "Богданов", "Воробьёв"};
    static String[] names = {"Абрам", "Август", "Авдей", "Аверкий", "Авксентий", "Авраам", "Автоном", "Агап", "Агафон", "Аггей", "Агей", "Адам", "Адриан", "Азарий", " Аким", " Александр", " Алексей", " Амвросий", " Амос", " Ананий", " Анатолий", " Андрей"};
    static String[] middleNames = {"Ааронович", "Абрамович", "Августович", "Авдеевич", "Аверьянович", "Адамович", "Адрианович", "Аксёнович", "Александрович", "Алексеевич", "Анатольевич", "Андреевич", "Анисимович", "Антипович", "Антонович", "Ануфриевич",};
    static String[] authors = autoNameAuthor();
    static String[] autoNameAuthor(){
        String[] autoAuthor = new String [10];
        for (int i = 0;i < autoAuthor.length;i++){
            autoAuthor[i] = surnames[random(0,(surnames.length - 1))]+" "+names[random(0,(names.length - 1))]+" "+middleNames[random(0,(middleNames.length - 1))];
        }
        return autoAuthor;
    }
    static String[] titles = {"О всё видавшем", "Книга Иова", "Тысяча и одна ночь", "Сага о Ньяле", "Божественная комедия", "Сказки", "И пришло разрушение", "Отец Горио", "Декамерон", "Вымыслы", "Грозовой перевал", "Рамаяна", "Энеида", "Миссис Дэллоуэй", "На маяк", "Махабхарата", "Голод", "Цыганское романсеро", "Сто лет одиночества", "Любовь во время чумы", "Фауст", "Тропы по большому сертану", "Мёртвые души", "Илиада", "Одиссея", "Жестяной барабан", "Берлин Александрплац", "Улисс", "Жак-фаталист и его хозяин", "Большие надежды", "Преступление и наказание", "Идиот", "Бесы", "Братья Карамазовы", "Медея", "Самопознание Дзено", "Кукольный дом", "Стон горы", "Невероятные похождения Алексиса Зорбаса", "Шакунтала", "Посторонний", "Рассказы", "Процесс", "За́мок", "Ностромо", "Самостоятельные люди", "Стихи", "Золотая тетрадь", "Пеппи Длинный чулок", "Сыновья и любовники", "Записки сумасшедшего", "Будденброки", "Волшебная гора", "Предания нашей улицы", "Моби Дик", "Опыты", "История", "Возлюбленная", "Человек без свойств", "Лолита", "Метаморфозы", "Книга непокоя", "Рассказы", "В поисках утраченного времени", "Гаргантюа и Пантагрюэль", "Педро Парамо", "Маснави", "Дети полуночи", "Гордость и предубеждение", "Бустан", "Сезон паломничества на Север", "Слепота", "Путешествия Гулливера", "Путешествие на край ночи", "Хитроумный идальго Дон Кихот Ламанчский", "Повесть о блистательном принце Гэндзи", "Эдип-царь", "Красное и чёрное", "Приключения Гекльберри Финна", "Война и мир", "Анна Каренина", "Смерть Ивана Ильича", "Листья травы", "Госпожа Бовари", "Воспитание чувств", "Шум и ярость", "Старик и море", "Стихотворения", "Рассказы", "Кентерберийские рассказы", "Гамлет", "Король Лир", "Отелло", "Мидлмарч", "Человек-невидимка", "Воспоминания Адриана"};
    static String[] publishingHouses = {"Айрис-пресс", "Академия", "Академкнига/Учебник", "АСТ", "Баласс", "БИНОМ.Лаборатори язнаний", "БХВ-Петербург", "Вако", "Вентана-Граф", "Вита-Пресс", "Владос"};
    static String[] covers = {"Твердый переплет", "Переплет 7БЦ", "Переплет 7Б", " Мягкий переплет", "Скрепление скобой", "Скрепление на пружину"};

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }
    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYearOfEdition() {
        return yearOfEdition;
    }
    public void setYearOfEdition(int yearOfEdition) {
        this.yearOfEdition = yearOfEdition;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeOfCover() {
        return typeOfCover;
    }
    public void setTypeOfCover(String typeOfCover) {
        this.typeOfCover = typeOfCover;
    }

    public Book(int id, String title, String author, String publishingHouse, int yearOfEdition, int numberOfPages, int price, String typeOfCover) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.yearOfEdition = yearOfEdition;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.typeOfCover = typeOfCover;
    }

    public Book(int id){
        this.id = id;
        this.title = titles[random(0,(titles.length - 1))];
        this.author = authors[random(0,(authors.length - 1))];
        this.publishingHouse = publishingHouses[random(0,(publishingHouses.length - 1))];
        this.yearOfEdition = random(1900,2000);
        this.numberOfPages = random(100,400);
        this.price = random(100,500);
        this.typeOfCover = covers[random(0,(covers.length - 1))];
    }

    @Override
    public String toString() {
        return "["+id+" \""+title+"\" "+author+" \""+publishingHouse+"\" "+yearOfEdition+" г. "+numberOfPages+" c. "+price+" грн. "+typeOfCover+"]";
    }

    public static int random(int first, int last){
        return (first) + (int) (Math.random() * (((last) - (first)) + 1));
    }



}
