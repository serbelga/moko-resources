/*
 * Copyright 2022 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

/*
 * Copyright 2022 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.ui.main.defaultUIKitMain
import androidx.compose.ui.window.Application
import com.icerockdev.library.MR
import dev.icerock.moko.resources.compose.stringResource

fun main() {
    defaultUIKitMain(
        "Moko Resources Sample App",
        Application("Moko Resources Sample App") {
            Column {
                Text(text = stringResource(MR.strings.common_name))
            }
        }
    )
}
