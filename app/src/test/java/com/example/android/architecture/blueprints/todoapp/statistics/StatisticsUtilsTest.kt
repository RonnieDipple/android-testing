package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest{
    //If there' no completed tasks and one active task,
    // then there 100% percent active tasks and 0% completed tasks

    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsZeroHundred(){

        //Setup
        val tasks = listOf<Task>(

                Task("Title", "Description", isCompleted = false)


        )

        //Execution
        val result = getActiveAndCompletedStats(tasks)

        //result
        assertEquals(0f, result.completedTasksPercent)
        assertEquals(100f, result.activeTasksPercent)
    }

    //If there's 2 completed tasks and 3 active tasks,
    // then there are 40% completed tasks and 60% active tasks

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty(){

        //Setup
        val tasks = listOf<Task>(

                Task("Title", "Description", isCompleted = true),

                Task("Title", "Description", isCompleted = true),
                Task("Title", "Description", isCompleted = false),
                Task("Title", "Description", isCompleted = false),
                Task("Title", "Description", isCompleted = false)


        )

        //Execution
        val result = getActiveAndCompletedStats(tasks)

        //result
        assertEquals(40f, result.completedTasksPercent)
        assertEquals(60f, result.activeTasksPercent)
    }
}