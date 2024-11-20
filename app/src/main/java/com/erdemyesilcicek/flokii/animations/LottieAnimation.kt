package com.erdemyesilcicek.flokii.animations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*

@Composable
fun LottieAnimation(animation: Int) {

    // Lottie animasyonunuzu yüklemek için bir LottieComposition oluşturun
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animation))

    // Animasyonun oynatılma durumunu kontrol etmek için bir progress animatable'si oluşturun
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever // Animasyonu sonsuz döngüde oynatır
    )
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Animasyonu Compose UI içinde göster
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier,
            contentScale = ContentScale.Fit // İsteğe bağlı: ölçeklendirme
        )
    }
}