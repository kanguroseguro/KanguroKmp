package com.insurtech.kanguro.designsystem.ui.composables.commumComponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.insurtech.kanguro.designsystem.R
import com.insurtech.kanguro.designsystem.ui.theme.MobaHeadline
import com.insurtech.kanguro.designsystem.ui.theme.MobaSubheadRegular

@Composable
fun ErrorComponent(
    modifier: Modifier = Modifier,
    onTryAgainPressed: () -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = modifier
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.gear),
                contentDescription = ""
            )
            Text(
                modifier = Modifier.padding(top = 24.dp),
                text = stringResource(id = R.string.something_went_wrong),
                textAlign = TextAlign.Center,
                style = MobaHeadline
            )
            StyledClickableText(
                modifier = Modifier.padding(top = 4.dp),
                text = stringResource(id = R.string.try_again_message),
                styledText = stringResource(id = R.string.try_again),
                baseStyle = MobaSubheadRegular.copy(textAlign = TextAlign.Center),
                onClick = onTryAgainPressed
            )
        }
    }
}

@Preview
@Composable
private fun ErrorComponentPreview() {
    Surface {
        ErrorComponent {
        }
    }
}

@Preview(locale = "es")
@Composable
private fun ErrorComponentLocalizedPreview() {
    Surface {
        ErrorComponent {
        }
    }
}
