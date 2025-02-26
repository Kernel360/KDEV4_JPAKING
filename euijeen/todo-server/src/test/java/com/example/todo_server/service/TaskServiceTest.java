package com.example.todo_server.service;

import com.example.todo_server.constants.TaskStatus;
import com.example.todo_server.persist.TaskRepository;
import com.example.todo_server.persist.entity.TaskEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks //해당 클래스에 인스턴스 생상하면서 목 객체 포함 모든 것을 주입해줌
    private TaskService taskService;


    @Test
    @DisplayName("할 일 추가 기능 테스트")
    void add() {
        var title = "test";
        var description = "test";
        var dueDate = Date.valueOf(LocalDate.now());

        when(taskRepository.save(any(TaskEntity.class)))
                .thenAnswer(invocation -> {
                    var e = (TaskEntity) invocation.getArgument(0);
                    e.setId(1L);
                    e.setCreatedAt(new Timestamp(System.currentTimeMillis()));
                    e.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
                    return e;
                });

        var actual = taskService.add(title, description, dueDate.toLocalDate());

        verify(taskRepository, times(1)).save(any());

        assertEquals(1L, actual.getId());
        assertEquals(title, actual.getTitle());
        assertEquals(description, actual.getDescription());
        assertEquals(dueDate.toString(), actual.getDueDate());
        assertEquals(TaskStatus.TODO, actual.getStatus());
        assertNotNull(actual.getCreatedAt());
        assertNotNull(actual.getUpdatedAt());
    }
}