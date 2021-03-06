package com.mitocode.ejb;

import com.mitocode.model.Nota;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;


@Stateless
public class NotaFacade extends AbstractFacade<Nota> implements NotaFacadeLocal{

    @PersistenceContext(unitName = "primePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotaFacade() {
        super(Nota.class);
    }

    @Override
    public List<Nota> buscar(int codigoPersona, int codigoCategoria, Date fechaConsulta) throws Exception{
       List<Nota> lista = null;
           System.out.println("NotaFacade-buscar()-inicio-codigoPersona: "+ codigoPersona);
           System.out.println("NotaFacade-buscar()-inicio-codigoCategoria: "+ codigoCategoria);
           //System.out.println("NotaFacade-buscar()-inicio-fechaConsulta: "+ fechaConsulta);
       try {
           String jpql = "FROM Nota n WHERE n.persona.codigo = ?1 AND n.categoria.codigo = ?2 AND n.fecha BETWEEN ?3 AND ?4 ";
           Query query = em.createQuery(jpql);
           
           //query.setParameter(1, 3);
           query.setParameter(1, codigoPersona);
           query.setParameter(2, codigoCategoria);
           query.setParameter(3, fechaConsulta, TemporalType.DATE);
           
           Calendar cal = Calendar.getInstance();
           cal.setTime(fechaConsulta);
           cal.add(Calendar.DATE,1);
           
           query.setParameter(4, cal, TemporalType.DATE);
           
           lista = query.getResultList();
           System.out.println("NotaFacade-buscar()-registros"+lista.size());
       } catch (Exception e) {
           throw e;
       }
       
       return lista;
    }
    
        
}
