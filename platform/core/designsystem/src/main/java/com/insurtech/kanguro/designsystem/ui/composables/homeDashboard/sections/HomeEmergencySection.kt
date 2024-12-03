package com.insurtech.kanguro.designsystem.ui.composables.homeDashboard.sections

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.insurtech.kanguro.designsystem.R
import com.insurtech.kanguro.designsystem.ui.composables.commumComponents.actions.ActionCardLiveVet
import com.insurtech.kanguro.designsystem.ui.composables.homeDashboard.model.HomeDashboardEvent
import com.insurtech.kanguro.designsystem.ui.theme.MobaCaptionBold
import com.insurtech.kanguro.designsystem.ui.theme.NeutralBackground
import com.insurtech.kanguro.designsystem.ui.theme.SecondaryDark
import com.insurtech.kanguro.designsystem.ui.theme.spacingXxxs

@Composable
fun HomeEmergencySection(
    modifier: Modifier = Modifier,
    onEvent: (HomeDashboardEvent) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.emergency).uppercase(),
            style = MobaCaptionBold.copy(color = SecondaryDark)
        )
        Column(
            modifier = Modifier.padding(top = spacingXxxs),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            ActionCardLiveVet(
                onClick = { onEvent(HomeDashboardEvent.OnLiveVetPressed) }
            )
        }
    }
}

@Preview
@Composable
private fun HomeEmergencySectionPreview() {
    Surface(
        color = NeutralBackground
    ) {
        HomeEmergencySection {
        }
    }
}