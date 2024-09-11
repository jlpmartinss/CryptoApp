package com.example.cryptoapp.presentation.coin_list.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.cryptoapp.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(10.dp)
            .clip(RoundedCornerShape(40))
            .border(2.dp, Color.Gray, RoundedCornerShape(40))
            .height(70.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(8f)
                .padding(16.dp)
            ,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.Monospace
            )
            Text(
                text = if (coin.isActive) "active" else "inactive",
                color = if (coin.isActive) Color.Green else Color.Red,
                fontStyle = MaterialTheme.typography.bodyMedium.fontStyle,
                fontFamily = FontFamily.Monospace,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .align(CenterVertically)
            )
        }

    }

}