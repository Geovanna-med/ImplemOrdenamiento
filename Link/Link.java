package Link;

public class Link<T> {
    private T dData;
    private Link<T> next; 

    public Link(T dd) {
        dData = dd;
        next = null;
    }

    public void displayLink() {        
        System.out.print("{" + dData + "} ");
    }

    public Link<T> getNext(){
        return next;
    }

    public void setNext(Link<T> next){
        this.next = next;
    }

    public T getData() {
        return dData;
    }
}
