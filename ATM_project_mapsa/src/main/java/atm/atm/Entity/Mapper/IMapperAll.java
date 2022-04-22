package atm.atm.Entity.Mapper;

import java.util.List;

public interface IMapperAll<E,D> {
    public E toEntity(D d);
    public D toDTO(E e);

    public List<E> listEntity(List<D> listDTO);
    public List<D> listDTO(List<E> listEntity);

}
