import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.*;

public class ManagementLibrarian {

    private static SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public boolean addLibrarian(String name, String password, String email, String address, String city, String contact){
        Session session = this.sessionFactory.openSession();
        boolean result = false;

        Transaction tx = session.beginTransaction();
        Librarian librarian = new Librarian(name, password, email, address, city, contact);
        session.save(librarian);
        tx.commit();
        result = true;
        session.close();
        return result;
    }

    public Object[][] viewLibrarian(){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List librarians = session.createQuery("FROM Librarian").list();
        Object[][] data = new Object[librarians.size()][7];
        for (Iterator iterator = librarians.iterator(); iterator.hasNext();) {
            for(int i = 0; i < librarians.size(); i++) {
                Librarian librarian = (Librarian) iterator.next();
                data[i][0] = librarian.getId();
                data[i][1] = librarian.getName();
                data[i][2] = librarian.getPassword();
                data[i][3] = librarian.getEmail();
                data[i][4] = librarian.getAddress();
                data[i][5] = librarian.getCity();
                data[i][6] = librarian.getContact();
            }
        }
        tx.commit();
        session.close();



        return data;
    }

    public void deleteLibrarian(String id){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Librarian librarian = (Librarian) session.get(Librarian.class, Integer.valueOf(id));
        session.delete(librarian);
        tx.commit();
        session.close();

    }

    public boolean checkLibrarianPassword(String name, String password){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        boolean result = false;

        List librarians = session.createQuery("FROM Librarian").list();
        for (Iterator iterator = librarians.iterator(); iterator.hasNext();) {
            Librarian librarian = (Librarian) iterator.next();
            if (name.equalsIgnoreCase(librarian.getName()) && password.equals(librarian.getPassword())) {
                result = true;
            } else {
                result = false;
            }
        }
        session.close();

        return result;
    }


}
