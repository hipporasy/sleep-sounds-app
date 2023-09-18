package codes.hipporasy.sleepsounds.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private enum class DiscoverHeaderItemState {
    All,
    Instrumental,
    Nature,
    ASMR,
    Music,
    ;
}

@Composable
fun DiscoverScreen(
    paddingValues: PaddingValues,
) {

    var selectedItem by remember { mutableStateOf(DiscoverHeaderItemState.All) }
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(
                bottom = paddingValues.calculateBottomPadding(),
                top = paddingValues.calculateTopPadding()
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(0.dp))
        DiscoverScreenHeader(selectedItem) { selectedItem = it}
    }
}

@Composable
private fun DiscoverScreenHeader(
    selectedItem: DiscoverHeaderItemState,
    setSelectedItem: (DiscoverHeaderItemState) -> Unit
) {
    val states = DiscoverHeaderItemState.values()
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Spacer(
                modifier = Modifier.width(8.dp)
            )
        }
        items(states.size) {
            DiscoverHeaderItem(
                item = states[it],
                selected = selectedItem == states[it],
                onClick = { setSelectedItem(states[it]) }
            )
        }
        item {
            Spacer(
                modifier = Modifier.width(8.dp)
            )
        }
    }
}

@Composable
private fun DiscoverHeaderItem(
    item: DiscoverHeaderItemState,
    selected: Boolean,
    onClick: () -> Unit
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val secondaryColor = MaterialTheme.colorScheme.secondary

    val backgroundColor = remember(selected) {
        primaryColor.takeIf { selected } ?: secondaryColor
    }
    Row(
        modifier = Modifier
            .selectable(
                selected = selected,
                onClick = onClick
            )
            .background(backgroundColor, MaterialTheme.shapes.large)
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            item.name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun DiscoverScreenBody() {

}
@Composable
private fun SoundItem() {

    Box() {


    }

}