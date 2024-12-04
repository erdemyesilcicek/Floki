package com.erdemyesilcicek.flokii.datas.dataclass

data class MainCharacter(
    val language: String, // Örneğin: "English", "Turkish"
    val name: String,     // Ana karakterin ismi
    val age: Int,         // Ana karakterin yaşı
    val gender: String,   // "Male", "Female", "Other"
    val dadName: String?,
    val momName: String?,
    val sisName: String?
)