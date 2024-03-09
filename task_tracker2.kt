import java.util.Scanner

data class Task(val name: String, var isCompleted: Boolean = false)

class TaskTracker {
    private val tasks = mutableListOf<Task>()
    private val scanner = Scanner(System.`in`)

    fun addTask() {
        print("Enter task name: ")
        val taskName = scanner.nextLine()
        tasks.add(Task(taskName))
        println("Task added successfully!\n")
    }

    fun markTaskAsCompleted() {
        print("Enter task name to mark as completed: ")
        val taskName = scanner.nextLine()
        val task = tasks.find { it.name == taskName }

        if (task != null) {
            task.isCompleted = true
            println("Task marked as completed!\n")
        } else {
            println("Task not found!\n")
        }
    }

    fun viewTasks() {
        if (tasks.isEmpty()) {
            println("No tasks available.\n")
        } else {
            tasks.forEachIndexed { index, task ->
                val status = if (task.isCompleted) "Completed" else "Pending"
                println("${index + 1}. ${task.name} - $status")
            }
            println()
        }
    }
}

fun main() {
    val taskTracker = TaskTracker()
    var choice: Int

    do {
        println("1. Add Task")
        println("2. Mark Task as Completed")
        println("3. View Tasks")
        println("4. Exit")
        print("Enter your choice: ")
        choice = readLine()?.toIntOrNull() ?: 0

        when (choice) {
            1 -> taskTracker.addTask()
            2 -> taskTracker.markTaskAsCompleted()
            3 -> taskTracker.viewTasks()
            4 -> println("Exiting...")
            else -> println("Invalid choice. Please try again.\n")
        }
    } while (choice != 4)
}
