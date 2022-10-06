package com.bobocode.repository;

import com.bobocode.entity.Reminder;
import com.bobocode.entity.dto.ReminderDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.stream.Stream;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    @QueryHints(
            @QueryHint(name = org.hibernate.jpa.QueryHints.HINT_FETCH_SIZE, value = "1")
    )
    @Query("select new com.bobocode.entity.dto.ReminderDto(r.id, r.todo) from Reminder r")
    Stream<ReminderDto> streamAllBy();
}
