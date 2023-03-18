package watermark

import java.io.File
import java.awt.image.BufferedImage
import javax.imageio.ImageIO


class UserImage(private val userImageFilename: File) {
    private val userImage: BufferedImage = ImageIO.read(userImageFilename)
    // and something to make my life easier.
    private val transparencyNames = listOf("", "OPAQUE", "BITMASK", "TRANSLUCENT")

    fun printImageDetails() {
        println("Image file: $userImageFilename")
        println("Width: ${this.userImage.width}")
        println("Height: ${this.userImage.height}")
        println("Number of components: ${this.userImage.colorModel.numComponents}")
        println("Number of color components: ${this.userImage.colorModel.numColorComponents}")
        println("Bits per pixel: ${this.userImage.colorModel.pixelSize}")
        println("Transparency: ${transparencyNames[this.userImage.transparency]}")
    }
}


fun main() {
    println("Input the image filename:")
    val inputFilename = readln()
    val inputFile = File(inputFilename)

    if (inputFile.exists()) {
        val userImage = UserImage(inputFile)
        userImage.printImageDetails()
    } else {
        println("The file $inputFilename doesn't exist.")
    }
}
