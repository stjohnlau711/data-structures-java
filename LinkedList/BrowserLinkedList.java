class WebPage{ //webpage is the content of HistoryState
    String url;
    String content;
    WebPage(String url, String content){
        this.url = url;
        this.content = content;
    }
    public void display(){
        System.out.println("URL: " + url);
        System.out.println("Content <html>" + content + "<html>\n");
    }
}

//Doubly Linked List Node, HistoryState functions exactly the same as a regular node
class HistoryState{ 
    WebPage page;
    HistoryState prev;
    HistoryState next;

    HistoryState(WebPage p){
        page = p;
    }
}

class BrowserHistory{
    HistoryState current;
    WebPage errorPage;

    BrowserHistory() {
        current = null;
        errorPage = new WebPage(null, "404 Not Found");
    }
    public WebPage navigate(String url, String content){

        WebPage newPage = new WebPage(url, content); //new webpage
        HistoryState newState = new HistoryState(newPage); //new history state

        if(current == null){
            current = newState; //new state is the only node
            current.prev = new HistoryState(errorPage);
            current.next = new HistoryState(errorPage);
        } else {
            current.next = newState; //current's next will be newState
            newState.prev = current; //newState's previous will be current
            current = newState; //Can declare current as newState
            current.next = null; //newState's next is now null
        }

        return current.page;
    }
    public WebPage back(){
        if(current == null){
            System.out.println("No valid current page!");
            return errorPage;
        } else if (current.prev == null){ //seems like this isn't working completely correctly, not sure why :(
            System.out.println("No valid page to go back to! Staying on page:");
            return current.page;
        } else {
            HistoryState next = current; //makes sure current.next is the page before going back, then makes current -> current.prev
            current = current.prev;
            current.next = next;
            return current.page;
        }


    }
    public WebPage forward(){
        if(current.next == null){
            System.out.println("No valid page to go forward to! Staying on page:");
            return current.page;
        } else {
            HistoryState previous = current; //makes sure current.prev is the page before going forward, then makes current -> current.next
            current = current.next;
            current.prev = previous;
            return current.page;
        }
    }
}



public class BrowserLinkedList { //driver method for testing
    public static void main(String[] args){
        BrowserHistory history = new BrowserHistory();

        history.back().display();

        history.navigate("www.nyu.edu", "we love purple").display();
        history.navigate("www.google.com", "search for stuff").display();
        history.navigate("www.yahoo.com", "did you get lost looking for google?").display();
        history.navigate("www.amazon.com", "buy stuff").display();

        history.forward().display();

        history.back().display();
        history.back().display();

        history.navigate("www.facebook.com", "search for friends").display();
        history.forward().display();

        history.back().display();
        history.back().display();
        history.back().display();

        history.forward().display();
        history.forward().display();
    }
}














