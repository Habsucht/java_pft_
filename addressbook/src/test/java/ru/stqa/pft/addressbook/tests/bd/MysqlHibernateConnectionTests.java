package ru.stqa.pft.addressbook.tests.bd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.data.ContactData;
import ru.stqa.pft.addressbook.data.GroupData;

import java.util.List;

public class MysqlHibernateConnectionTests {
    private SessionFactory sessionFactory;

    @BeforeMethod
    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory so destroy it manually.
            StandardServiceRegistryBuilder
                    .destroy(registry);
        }
    }

    @Test()
    public void testDbConnectionForHibernate() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        //List<GroupData> resultGroup = session.createQuery("from GroupData").list();
        //for ( GroupData group : resultGroup ) { System.out.println(group); }

        List<ContactData> resultContact = session.createQuery("from ContactData where deprecated = '0000-00-00'").list();
        for ( ContactData contact : resultContact ) { System.out.println(contact); }

        session.getTransaction().commit();
        session.close();
    }
}
