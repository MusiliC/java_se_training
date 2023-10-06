package com.systechafrica.part3.jdbc;

import java.time.LocalDate;

public class Task {
    private int task_id;
    private String title;
    private LocalDate startDate;
    private LocalDate dueDate;

    private int priority;
    private String description;

    public Task() {
    }

    public Task(int task_id, String title, LocalDate startDate, LocalDate dueDate,  int priority,
            String description) {
        this.task_id = task_id;
        this.title = title;
        this.startDate = startDate;
        this.dueDate = dueDate;
   
        this.priority = priority;
        this.description = description;
    }

    public Task(String title, LocalDate startDate, LocalDate dueDate,  int priority, String description) {
        this.title = title;
        this.startDate = startDate;
        this.dueDate = dueDate;
   
        this.priority = priority;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }




    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "task [task_id=" + task_id + ", title=" + title + ", startDate=" + startDate + ", dueDate=" + dueDate
                 + ", priority=" + priority + ", description=" + description + "]";
    }

}
