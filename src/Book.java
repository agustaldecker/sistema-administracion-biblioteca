public class Book {

    private int id;
    private int callNo;
    private String name;
    private String author;
    private String publisher;
    private int quantity;
    private int issued;
    private String addedDate;

    public Book(){

    }

    public Book(int callNo, String name, String author, String publisher, int quantity){
        this.callNo = callNo;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setCallNo(int callNo){
        this.callNo = callNo;
    }

    public int getCallNo(){
        return callNo;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public String getPublisher(){
        return publisher;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setIssued(int issued){
        this.issued = issued;
    }

    public int getIssued(){
        return issued;
    }

    public void setAddedDate(String addedDate){
        this.addedDate = addedDate;
    }

    public String getAddedDate(){
        return addedDate;
    }

}
