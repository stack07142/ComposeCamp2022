package com.codelabs.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun changeTaskChecked(item: WellnessTask, checked: Boolean) =
        tasks.find { it.id == item.id }?.let { task ->
            task.checked = checked
        }

    fun changeTaskName(item: WellnessTask, newTaskName: String) =
        tasks.find { it.id == item.id }?.let { task ->
            task.label = newTaskName
        }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }