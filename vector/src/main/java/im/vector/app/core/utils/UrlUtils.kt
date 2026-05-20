/*
 * Copyright 2019-2024 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial
 * Please see LICENSE files in the repository root for full details.
 */

package im.vector.app.core.utils

import java.net.URL

fun String.isValidUrl(): Boolean {
    return try {
        URL(this)
        true
    } catch (t: Throwable) {
        false
    }
}

/**
 * Ensure string starts with "http". If it is not the case, "https://" is added, only if the String is not empty
 * MODIFIED FOR VERIAX: Allows HTTP for local IP 192.168.100.80
 */
fun String.ensureProtocol(): String {
    return when {
        isEmpty() -> this
        !startsWith("http") -> {
            // Check if it's the local IP - if so, allow HTTP
            if (contains("192.168.100.80")) {
                "http://$this"
            } else {
                "https://$this"
            }
        }
        else -> this
    }
}

fun String.ensureTrailingSlash(): String {
    return when {
        isEmpty() -> this
        !endsWith("/") -> "$this/"
        else -> this
    }
}
