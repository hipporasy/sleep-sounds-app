package codes.hipporasy.sleepsounds.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.navigate
import com.arkivanov.decompose.router.stack.push
import io.ktor.http.headers
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

private enum class DiscoverHeaderItemState {
    All,
    Instrumental,
    Ambient,
    ASMR,
    Music,
    ;

    val icon: String
        get() = when (this) {
            All -> "ic_all.xml"
            Instrumental -> "ic_composer.xml"
            Ambient -> "ic_meditation.xml"
            ASMR -> "ic_all.xml"
            Music -> "ic_all.xml"
        }
}

@Composable
fun DiscoverScreen(
    paddingValues: PaddingValues,
) {

    var selectedItem by remember { mutableStateOf(DiscoverHeaderItemState.All) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().padding(
            bottom = paddingValues.calculateBottomPadding(),
            top = paddingValues.calculateTopPadding()
        ),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 8.dp,
            end = 8.dp,
            bottom = 4.dp
        ),
    ) {
        item(span = { GridItemSpan(2) }) {
            DiscoverScreenHeader(selectedItem, setSelectedItem = { selectedItem = it })
        }
        items(10) {
            SoundItem()
        }
    }

}

@Composable
private fun DiscoverScreenHeader(
    selectedItem: DiscoverHeaderItemState,
    setSelectedItem: (DiscoverHeaderItemState) -> Unit
) {
    val states = DiscoverHeaderItemState.values()
    LazyRow(
        modifier = Modifier.fillMaxWidth().padding(
            vertical = 8.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(states.size) {
            DiscoverHeaderItem(
                item = states[it],
                selected = selectedItem == states[it],
                onClick = { setSelectedItem(states[it]) }
            )
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
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
    val onSurfaceVariant = MaterialTheme.colorScheme.onSurfaceVariant
    val onPrimary = MaterialTheme.colorScheme.onPrimary
    val selectedTintColor = remember(selected) {
        onPrimary.takeIf { selected } ?: onSurfaceVariant
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
        Icon(
            painter = painterResource(item.icon),
            contentDescription = null,
            tint = selectedTintColor,
            modifier = Modifier.size(24.dp)
        )
        Text(
            item.name,
            style = MaterialTheme.typography.titleMedium,
            color = selectedTintColor
        )
    }
}

@Composable
private fun DiscoverScreenBody() {

}
sealed class DiscoverScreenRoute {
    object A : DiscoverScreenRoute()
    object B : DiscoverScreenRoute()
    object C : DiscoverScreenRoute()
    object D : DiscoverScreenRoute()
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun SoundItem() {
    val stackNavigation = StackNavigation<DiscoverScreenRoute>()
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        stackNavigation.push(DiscoverScreenRoute.A)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(180.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painterResource("sleep1.png"),
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
                contentDescription = null,
            )
            Box(
                modifier = Modifier
                    .padding(top = 8.dp, end = 12.dp)
                    .size(32.dp)
                    .background(
                        color = Color(0x66000000),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painterResource("ic_play.xml"),
                    modifier = Modifier.size(28.dp),
                    contentDescription = null,
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Guitar Camp",
            modifier = Modifier.padding(horizontal = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Start,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            "7 Songs • Instrumental",
            color = Color(0xFFFFFFFF),
            modifier = Modifier.padding(horizontal = 8.dp),
            fontSize = 12.sp,
            textAlign = TextAlign.Start,
        )
        Spacer(modifier = Modifier.height(8.dp))
    }

}