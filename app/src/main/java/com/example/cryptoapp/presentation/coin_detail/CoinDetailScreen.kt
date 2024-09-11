package com.example.cryptoapp.presentation.coin_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.cryptoapp.presentation.coin_detail.components.CoinTag
import com.example.cryptoapp.presentation.coin_detail.components.TeamListItem
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        state.coin?.let { coin ->

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Logo Image
                    Image(
                        painter = rememberAsyncImagePainter(coin.logo),
                        contentDescription = "${coin.name} Logo",
                        modifier = Modifier
                            .size(80.dp)
                            .align(CenterVertically)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.weight(7f)
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name}",
                            style = MaterialTheme.typography.headlineMedium,
                            fontFamily = FontFamily.Monospace
                        )
                        Text(
                            text = "[${coin.symbol}]",
                            style = MaterialTheme.typography.bodyMedium,
                            fontFamily = FontFamily.Monospace,
                            color = Color.Gray
                        )
                    }

                    Text(
                        text = if (coin.isActive) "active" else "inactive",
                        color = if (coin.isActive) Color.Green else Color.Red,
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.Monospace,
                        textAlign = TextAlign.End,
                        modifier = Modifier
                            .align(CenterVertically)
                            .weight(2f)
                    )
                }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.bodyMedium,
                        fontFamily = FontFamily.Monospace
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.headlineSmall,
                        fontFamily = FontFamily.Monospace
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "Team members",
                        style = MaterialTheme.typography.headlineSmall,
                        fontFamily = FontFamily.Monospace
                    )
                }

                items(coin.team) { teamMember ->
                    TeamListItem(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )
                    HorizontalDivider()
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
