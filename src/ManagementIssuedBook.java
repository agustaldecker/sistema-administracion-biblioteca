
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.Iterator;
import java.util.List;

public class ManagementIssuedBook {

    private static SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public boolean addIssuedBook(int id, int callNo, int studentId, String name, String contact){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        boolean result = false;
        IssuedBook issuedBook = new IssuedBook(id, callNo, studentId, name, contact);
        session.save(issuedBook);
        tx.commit();
        result = true;
        session.close();

        return result;
    }

    public Object[][] viewIssuedBook(){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List issuedBooks = session.createQuery("FROM IssuedBook").list();
        Object[][] data = new Object[issuedBooks.size()][5];
        for (Iterator iterator = issuedBooks.iterator(); iterator.hasNext();) {
            for (int i = 0; i < issuedBooks.size(); i++) {
                IssuedBook issuedBook = (IssuedBook) iterator.next();
                data[i][0] = issuedBook.getId();
                data[i][1] = issuedBook.getCallNo();
                data[i][2] = issuedBook.getStudentId();
                data[i][3] = issuedBook.getName();
                data[i][4] = issuedBook.getContact();
            }
        }
        tx.commit();
        session.close();
        return data;
    }

    public boolean deleteIssuedBook(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        IssuedBook issuedBook = (IssuedBook) session.get(IssuedBook.class, id);
        session.delete(issuedBook);
        tx.commit();
        session.close();

        return true;
    }

}
