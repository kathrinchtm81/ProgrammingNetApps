import ua.kpi.its.lab.rest.entity.Enterprise

interface Container<T> {
    fun add(element: T)

    fun remove(index: Int)

    fun update(index: Int, element: T)

    fun get(index: Int): T
    fun getAll(): List<T>
}

class TrainContainer : Container<Enterprise> {
    private val enterprises: MutableList<Enterprise> = mutableListOf()

    override fun add(element: Enterprise) {
        enterprises.add(element)
    }

    override fun remove(index: Int) {
        enterprises.removeAt(index)
    }

    override fun update(index: Int, element: Enterprise) {
        enterprises[index] = element
    }

    override fun get(index: Int): Enterprise {
        return enterprises[index]
    }

    override fun getAll(): List<Enterprise> {
        return enterprises
    }
}