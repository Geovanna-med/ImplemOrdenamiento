package Link;
public class LinkList<T extends Comparable<T>>{
    protected Link<T> first;
    private int listLength = 0;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void displayList() {
        System.out.print("List (first--> ");
        Link<T> current = this.first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
        }
        System.out.println("<--last)");
    }

    public void insertFirst(T dd) {
        Link<T> newLink = new Link<>(dd);
        newLink.setNext(this.first);
        first = newLink;
        listLength++;
    }

    public T deleteFirst() {
        Link<T> temp = null;
        if (!isEmpty()) {
            temp = this.first;
            first = first.getNext();
        }
        listLength--;
        return temp.getData();
    }

    public void insertLast(T dd) {
        Link<T> newLink = new Link<>(dd);
        Link<T> aux = first;
        while (aux != null) {
            if (aux.getNext() == null) {
                break;
            }
            aux = aux.getNext();
        }
        aux.setNext(newLink);
        listLength++;
    }

    public T deleteLast() {
        Link<T> aux = first;

        if (isEmpty()) {
            return null;
        }

        if (aux.getNext() == null) {
            Link<T> save = aux;
            aux = null;
            return save.getData();
        }

        while (aux.getNext().getNext() != null) {
            aux = aux.getNext();
        }

        Link<T> save = aux;
        aux.setNext(null);
        listLength--;
        return save.getData();
    }

    /* Aquí comienzan los métodos solicitados en el ADA */

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return first.getData();
    }

    public T getLast() {
        if (isEmpty())
            return null;

        Link<T> aux = first;
        while (aux.getNext() != null) {
            aux = aux.getNext();
        }

        return aux.getData();
    }

    public int length() {
        return listLength;
    }

    public void insertAfter(T lookedObj, T obj) {
        if (isEmpty())
            return;

        Link<T> aux = first;
        boolean objFound = false;

        while (aux != null) {
            if (aux.getData().equals(lookedObj)) {
                objFound = true;
                break;
            }
            aux = aux.getNext();
        }

        if (objFound) {
            Link<T> objToInsert = new Link<T>(obj);
            objToInsert.setNext(aux.getNext());
            aux.setNext(objToInsert);
            listLength++;
        }
    }

    public void insertBefore(T lookedObj, T obj) {
        if (isEmpty())
            return;

        Link<T> aux = first;

        if (aux.getData().equals(lookedObj)) {
            Link<T> objToInsert = new Link<T>(obj);
            first = objToInsert;
            first.setNext(aux);
            return;
        }

        boolean objFound = false;
        Link<T> beforeObj = null;

        while (aux != null) {
            if (aux.getData().equals(lookedObj)) {
                objFound = true;
                break;
            }
            beforeObj = aux;
            aux = beforeObj.getNext();
        }

        if (objFound) {
            Link<T> objToInsert = new Link<T>(obj);
            beforeObj.setNext(objToInsert);
            beforeObj.getNext().setNext(aux);
            listLength++;
        }
    }

    public void insertInOrder(T obj, boolean ascendant) {
        if (isEmpty()) {
            insertFirst(obj);
            return;
        }

        Link<T> aux = first;

        while (aux != null) {
            if (ascendant) {
                if (obj.compareTo(aux.getData()) > 0) {
                    insertAfter(aux.getData(), obj);
                    return;
                }
            } else {
                if (obj.compareTo(aux.getData()) > 0) {
                    insertBefore(aux.getData(), obj);
                    return;
                }
            }
            aux = aux.getNext();
        }
    }

    public boolean deleteByData(T data) {
        if (isEmpty()) {
            return false;
        }

        if (first.getData().equals(data)) {
            first = first.getNext();
            return true;
        }

        Link<T> aux = first.getNext();
        Link<T> beforeObj = first;
        while (aux != null) {
            if (aux.getData().equals(data)) {
                beforeObj.setNext(aux.getNext());
                return true;
            }
            beforeObj = aux;
            aux = beforeObj.getNext();
        }

        return false;
    }

    public void deleteByIndex(int index) {
        if (index > listLength - 1 || index < 0)
            return;

        Link<T> aux = first;
        if (index == 0) {
            first = aux.getNext();
            return;
        }

        int i = 1;
        Link<T> prevNode = first;
        while (i <= index) {
            prevNode = aux;
            aux = prevNode.getNext();
            i++;
        }

        prevNode.setNext(aux.getNext());
    }

    public void clear() {
        first = null;
        listLength = 0;
    }

    public int findIndex(T obj) {
        Link<T> aux = first;

        int i = 0;
        while (aux != null) {
            if (aux.getData().equals(obj))
                return i;
            aux = aux.getNext();
            i++;
        }
        return -1;
    }

    /**
     * Returns boolean value, true if the replace was succesful, false
     * otherwise
     * 
     * @param index
     * @param obj
     * @return boolean value
     */
    public boolean replace(int index, T obj) {
        if (isEmpty())
            return false;

        if (index > listLength - 1)
            return false;

        if (index == 0) {
            Link<T> objToInsert = new Link<>(obj);
            objToInsert.setNext(first.getNext());
            first = objToInsert;
            return true;
        }

        int i = 1;
        Link<T> aux = first.getNext();
        Link<T> beforeObj = first;
        while (aux != null) {
            if (i == index) {
                Link<T> objToInsert = new Link<>(obj);
                beforeObj.setNext(objToInsert);
                beforeObj.getNext().setNext(aux.getNext());
                return true;
            }
            beforeObj = aux;
            aux = beforeObj.getNext();
            i++;
        }
        return false;
    }

    public T[] toArray(){
        T[] array = (T[]) new Object[length()];
        
        int index = 0;
        Link<T> current = this.first;
        while (current != null) {
            array[index] = current.getData();
            index++;
            current = current.getNext();
        }
        return array;
    }
}
