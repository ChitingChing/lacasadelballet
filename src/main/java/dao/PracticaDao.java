/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Pojos.Categoria;
import datos.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Seeting
 */
public class PracticaDao {

    public List<Categoria> obtenerCategorias() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        List<Categoria> categorias = null;
        factory.openSession();
        try(Session session = factory.openSession()) {
            String hql = "from Categoria c";
            Query query = session.createQuery(hql);
            categorias = (List<Categoria>) query.list();
        }

        return categorias;
    }

}
