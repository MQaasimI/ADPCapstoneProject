/* IRepository.java
IRepository class
Author: Lyle Solomons (230123872)
Date: 26 March 2026
*/

package za.ac.cput.repository;

import java.util.List;

public interface IRepository<T, ID> {

    //CRUD
    T create(T t);

    T read(ID id);

    T update(T t);

    boolean delete(ID id);

    List<T> getAll();
}
