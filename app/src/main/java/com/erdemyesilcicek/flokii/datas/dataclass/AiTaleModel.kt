package com.erdemyesilcicek.flokii.datas.dataclass

data class AiTaleModel(
    val genre: String,             // Örneğin: "Adventure", "Fantastic"
    val season: String,            // Örneğin: "Winter", "Summer"
    val animals: List<String>,     // Örneğin: ["Fox", "Lion"]
    val characters: List<String>,  // Örneğin: ["Wizard", "Elf"]
    val family: List<String>,      // Örneğin: ["Dad", "Mom"]
    val mainCharacter: MainCharacter // Ana karakter bilgileri
)