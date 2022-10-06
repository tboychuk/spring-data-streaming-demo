package com.bobocode.service;

import com.bobocode.entity.dto.ReminderDto;
import com.bobocode.repository.ReminderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReminderService {

    private final ReminderRepository reminderRepository;

    @Transactional(readOnly = true)
    @EventListener(ContextRefreshedEvent.class)
    public void processReminders() {
        reminderRepository.streamAllBy()
                .forEach(this::processReminder);
    }

    private void processReminder(ReminderDto reminder) {
        System.out.println(reminder);
    }
}
