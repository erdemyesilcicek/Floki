
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.erdemyesilcicek.flokii.onboard.onBoardPages
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
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
