package ru.kpfu.itis.univer2016.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.univer2016.entity.Group;

/**
 * Created by ma on 14.04.2016.
 */
@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {

    Group findByName(String name);

}
