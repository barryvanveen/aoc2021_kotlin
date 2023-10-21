import java.io.File
import java.nio.file.Paths

class Input {
    fun readFile(fileName: String): List<String>
        = this.getRelativePath(fileName).useLines { it.toList() }

    private fun getRelativePath(fileName: String): File {
        return Paths.get("src/main/kotlin/").toAbsolutePath().resolve(fileName).toFile()
    }

    fun convertStringToInt(input: List<String>): List<Int>
        = input.map { i -> i.toInt() };
}