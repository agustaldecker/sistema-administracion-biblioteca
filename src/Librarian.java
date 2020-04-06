public class Librarian {
    private int id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String city;
    private String contact;

    public Librarian(){

    }

    public Librarian(String name, String password, String email, String address, String city, String contact){
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.city = city;
        this.contact = contact;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }

    public void setCity(String city){
        this.city = city;
    }
    public String getCity(){
        return city;
    }

    public void setContact(String contact){
        this.contact = contact;
    }
    public String getContact(){
        return contact;
    }

}
