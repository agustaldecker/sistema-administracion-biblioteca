public class IssuedBook {

    private int id;
    private int callNo;
    private int studentId;
    private String name;
    private String contact;

    public IssuedBook(){}

    public IssuedBook(int id, int callNo, int studentId, String name, String contact){
        this.id = id;
        this.callNo = callNo;
        this.studentId = studentId;
        this.name = name;
        this.contact = contact;
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

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
    public int getStudentId(){
        return studentId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public String getContact(){
        return contact;
    }
}
