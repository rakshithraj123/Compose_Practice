import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopAppBar(
    title: String,
    showBackButton: Boolean = false,
    onBackClick: (() -> Unit) = {},
    actions: @Composable (RowScope.() -> Unit) = {}
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (showBackButton ) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
            } else null
        },
        actions = actions
    )
}
