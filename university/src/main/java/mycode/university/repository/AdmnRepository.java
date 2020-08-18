package mycode.university.repository;

import mycode.university.model.Timetable;
import org.springframework.data.repository.CrudRepository;

public interface AdmnRepository extends CrudRepository<Timetable,Long> {
    Iterable<Timetable> findAll();
}
