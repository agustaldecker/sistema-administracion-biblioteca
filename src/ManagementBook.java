
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.Iterator;
import java.util.List;

public class ManagementBook {

    private static SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public boolean addBook(int callNo, String name, String author, String publisher, int quantity){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        boolean result = false;
        Book book = new Book(callNo, name, author, publisher, quantity);
        session.save(book);
        tx.commit();
        result = true;
        session.close();

        return result;
    }

    public Object[][] viewBook(){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List books = session.createQuery("FROM Book").list();
        Object[][] data = new Object[books.size()][8];
        for (Iterator iterator = books.iterator(); iterator.hasNext();) {
            for (int i = 0; i < books.size(); i++) {
                Book book = (Book) iterator.next();
                data[i][0] = book.getId();
                data[i][1] = book.getCallNo();
                data[i][2] = book.getName();
                data[i][3] = book.getAuthor();
                data[i][4] = book.getPublisher();
                data[i][5] = book.getQuantity();
                data[i][6] = book.getIssued();
                data[i][7] = book.getAddedDate();
            }
        }
        tx.commit();
        session.close();
        return data;
    }

    public void issueBook(int id){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Book book = (Book) session.get(Book.class, id);
        int newQ = book.getQuantity() - 1;
        int newI = book.getIssued() + 1;
        book.setQuantity(newQ);
        book.setIssued(newI);
        session.update(book);
        tx.commit();
        session.close();

    }

    public void returnBook(int id){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Book book = (Book) session.get(Book.class, id);
        int newQ = book.getQuantity() + 1;
        int newI = book.getIssued() - 1;
        book.setQuantity(newQ);
        book.setIssued(newI);
        session.update(book);
        tx.commit();
        session.close();

    }

}
