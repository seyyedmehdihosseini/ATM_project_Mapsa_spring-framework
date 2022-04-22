package atm.atm.Service;

import java.util.List;

public interface CRUD<E,P> {
    //public E created(E e); // hidden created because any entity it's created in one state.
    public E update(E e);
    public E findByUnique(P id);
    public void deleteByUnique(P id);
    public List<E> findAll();

}
