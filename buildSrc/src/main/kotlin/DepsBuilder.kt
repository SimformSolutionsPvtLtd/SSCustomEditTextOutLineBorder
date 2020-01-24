import org.gradle.kotlin.dsl.DependencyHandlerScope

/**
 * Helper class for building dependency extension
 * */
class DepsBuilder {
    internal val list = ArrayList<String>()

    /**
     * overrides unary operator to add string dependencies into array directly
     * */
    operator fun String.unaryPlus() = list.add(this)
}

/**
 * Extension function for implementation type of dependencies
 *
 * @param func is a lambda receiver of [DepsBuilder] class which provides a block to add dependencies
 * */
fun DependencyHandlerScope.`implementation`(func: DepsBuilder.() -> Unit) =
    DepsBuilder().apply {
        func()
        list.forEach { dep ->
            dependencies.add("implementation", dep)
        }
    }
