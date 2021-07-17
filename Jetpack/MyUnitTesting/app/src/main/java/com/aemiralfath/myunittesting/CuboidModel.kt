package com.aemiralfath.myunittesting

class CuboidModel {
    private var width = 0.0
    private var length = 0.0
    private var heigth = 0.0

    fun getVolume(): Double = width * length * heigth

    fun getSurfaceArea(): Double {
        val wl = width * length
        val wh = width * heigth
        val lh = length * heigth
        return 2 * (wl + wh + lh)
    }

    fun getCircumference(): Double = 4 * (width+length+heigth)

    fun save(width: Double, length: Double, height: Double){
        this.width = width
        this.length = length
        this.heigth = height
    }


}