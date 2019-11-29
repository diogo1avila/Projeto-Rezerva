/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author 12141000517
 */
public class Dao <T>{
    private final Class<T> classe;

    public Dao(Class<T> Classe) {
        this.classe = Classe;
    }
    
    public List<T> buscaTodos(){
        String jpql = "select s from "+ classe.getName() +" s";
        
        EntityManager em = JPAUtils.getEntityManager();
        
        Query query = em.createQuery(jpql);
        List<T> lista = query.getResultList();
        em.close();
        
        return lista;
    }
    
    public T buscaPorId(int id){
        EntityManager em = JPAUtils.getEntityManager();
        T t = em.find(classe, id);
        
        em.close();
        return t;
    }
    
    public void adiciona(T t){
        EntityManager em = JPAUtils.getEntityManager();
        
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void atualiza(T t){
        EntityManager em = JPAUtils.getEntityManager();
        
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
        
        em.close();
    }
    
    public void remove(int id){
        EntityManager em = JPAUtils.getEntityManager();
        
        em.getTransaction().begin();
        
        T t = em.find(classe, id);
        em.remove(t);
        em.getTransaction().commit();
        
        em.close();
    }
}
