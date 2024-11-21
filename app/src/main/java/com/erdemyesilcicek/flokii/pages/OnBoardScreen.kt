import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import androidx.compose.ui.res.painterResource
import com.erdemyesilcicek.flokii.lists.onBoardPages
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardScreen(onFinish: () -> Unit) {
    val pagerState = rememberPagerState() // PagerState oluşturuldu
    val coroutineScope = rememberCoroutineScope() // CoroutineScope oluşturuldu

    Column(modifier = Modifier.fillMaxSize()) {
        // Sayfaları göstermek için HorizontalPager
        HorizontalPager(
            count = onBoardPages.size,
            state = pagerState,
            modifier = Modifier.weight(1f) // Üst kısmın ağırlığını belirler
        ) { page ->
            val onBoardPage = onBoardPages[page]
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = onBoardPage.imageRes),
                    contentDescription = null,
                    modifier = Modifier.size(200.dp)
                )
                Text(
                    text = onBoardPage.title,
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = onBoardPage.description,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }

        // İleri ve Tamamla Butonları
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val isLastPage = pagerState.currentPage == onBoardPages.lastIndex // Son sayfa kontrolü
            TextButton(onClick = {
                if (isLastPage) {
                    onFinish() // Ana sayfaya geçiş
                } else {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1) // Sonraki sayfaya geçiş
                    }
                }
            }) {
                Text(text = if (isLastPage) "Başla" else "İleri")
            }
        }
    }
}
