package Link;

/**
 * Esta solo es una clase de prueba , se utiliza en los métodos de
 * testeo, nótese la implementación del método toStrin e equals.
 */
class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "" + getName() + ":" + getAge() + "";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Person person = (Person) obj;

        if (!person.getName().equals(this.getName())) {
            return false;
        }

        if (person.getAge() != this.getAge()) {
            return false;
        }

        return true;
    }

    @Override
    public int compareTo(Person o) {
        if (o.getAge() > this.getAge()) {
            return -1;
        } else {
            return 1;
        }
    }

}

/**
 * LinkedListTest
 */
class LinkedListTest {
    public static Person teo = new Person("Teo", 19);
    public static Person ana = new Person("ana", 29);
    public static Person luis = new Person("luis", 31);
    public static Person soto = new Person("soto", 27);
    public static Person juan = new Person("Juan", 32);

    public static void main(String[] args) {

        // punto 1
        // checkGetFirstGetLast();

        // punto 2
        // checkGetlength();

        // punto 3
        // checkInsertAfter();

        // punto 4
        // checkInsertBefore();

        // punto 5
        // checkInsertInOrder();

        // punto 6
        checkDeleteByData();

        // punto 7
        // checkDelete();

        // punto 8
        // checkClear();

        // punto 9
        // checkFindIndex();

        // punto 10
        // checkReplace();
    }

    public static void checkGetFirstGetLast() {
        System.out.println("checking getFirst & getLast");
        LinkList<Person> lista = new LinkList<>();

        lista.insertFirst(teo);
        lista.insertFirst(juan);
        lista.insertFirst(ana);
        lista.displayList();

        System.out.println(lista.getFirst());
        System.out.println(lista.getLast());
    }

    public static void checkGetlength() {
        System.out.println("checking get length");
        LinkList<Person> lista = new LinkList<>();
        lista.insertFirst(teo);
        lista.insertFirst(juan);
        lista.insertFirst(ana);

        System.out.println(lista.length());

    }

    public static void checkInsertAfter() {
        System.out.println("checking insertAfter");
        LinkList<Person> lista = new LinkList<>();

        lista.insertFirst(teo);
        lista.insertFirst(juan);
        lista.insertFirst(ana);
        lista.displayList();

        lista.insertAfter(teo, soto);
        lista.displayList();

        lista.insertAfter(ana, luis);
        lista.displayList();
    }

    public static void checkInsertBefore() {
        System.out.println("checking insertBefore");
        LinkList<Person> lista = new LinkList<>();

        lista.insertFirst(teo);
        lista.insertFirst(juan);
        lista.insertFirst(ana);
        lista.displayList();

        lista.insertBefore(teo, soto);
        lista.insertBefore(ana, luis);
        lista.displayList();
    }

    public static void checkInsertInOrder() {
        System.out.println("checking insert in order");
        LinkList<Person> lista = new LinkList<>();

        lista.insertFirst(teo);
        lista.displayList();

        lista.insertInOrder(juan, false);
        lista.displayList();

        lista.insertInOrder(ana, false);
        lista.displayList();

        lista.insertInOrder(soto, false);
        lista.displayList();

        lista.insertInOrder(luis, false);
        lista.displayList();
    }

    public static void checkDelete() {
        System.out.println("checking delete with index");
        LinkList<Person> lista = new LinkList<>();

        lista.insertFirst(teo);
        lista.insertFirst(juan);
        lista.insertFirst(ana);
        lista.displayList();

        lista.deleteByIndex(3);
        lista.displayList();

        lista.deleteByIndex(5);
        lista.displayList();

        lista.deleteByIndex(-3);
        lista.displayList();

        lista.deleteByIndex(1);
        lista.displayList();

        lista.deleteByIndex(0);
        lista.displayList();
    }

    public static void checkDeleteByData() {
        System.out.println("checking delete with index");
        LinkList<Person> lista = new LinkList<>();

        lista.insertFirst(teo);
        lista.insertFirst(juan);
        lista.insertFirst(ana);
        lista.insertFirst(soto);
        lista.insertFirst(luis);
        lista.displayList();

        lista.deleteByData(soto);
        lista.displayList();

        lista.deleteByData(teo);
        lista.displayList();

        lista.deleteByData(ana);
        lista.displayList();

        lista.deleteByData(juan);
        lista.displayList();

        lista.deleteByData(luis);
        lista.displayList();
    }

    public static void checkClear() {
        System.out.println("checking clear");
        LinkList<Person> lista = new LinkList<>();

        lista.insertFirst(teo);
        lista.insertFirst(juan);
        lista.insertFirst(ana);
        lista.displayList();

        lista.clear();
        lista.displayList();
    }

    public static void checkFindIndex() {
        System.out.println("checking find index");
        LinkList<Person> lista = new LinkList<>();

        lista.insertFirst(teo);
        lista.insertFirst(juan);
        lista.insertFirst(ana);
        lista.displayList();

        System.out.println(lista.findIndex(teo));
        System.out.println(lista.findIndex(juan));
        System.out.println(lista.findIndex(ana));
        System.out.println(lista.findIndex(soto));
    }

    public static void checkReplace() {
        System.out.println("checking replace");
        LinkList<Person> lista = new LinkList<>();

        lista.insertFirst(teo);
        lista.insertFirst(juan);
        lista.displayList();

        lista.replace(1, luis);
        lista.displayList();

        lista.replace(0, soto);
        lista.displayList();
    }
}
