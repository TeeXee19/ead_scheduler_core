package com.interra.ead_scheduler_core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_id")
    private int id;

    @Column(name = "title")
    @NotEmpty(message = "*Please provide  the Title for this task")
    private String title;

    @Column(name ="description")
    @NotEmpty(message = "*Please provide the task description")
    private String description;

    @Column(name = "start_date")
    @NotEmpty(message = "*Please provide the start cdate")
    private Date start_date;

    @Column(name = "end_date")
    @NotEmpty(message = "*Please provide the end date")
    private Date end_date;

    @Column(name = "approval_status")
    private Boolean approvalStatus;

    @Column(name = "duration")
    private int duration;

    @Column(name = "progress")
    private int progress;

    @Column(name = "uncomp_task")
    private String uncompletedTask;

    @Column(name = "comp_task")
    private String completedTask;
}
