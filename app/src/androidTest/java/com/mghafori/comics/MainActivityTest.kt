package com.mghafori.comics

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.mghafori.comics.presentation.MainActivity
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun simpleTest() {
        composeTestRule.onNodeWithText("Type a number, see its comic").assertIsDisplayed()
    }

}
