/*
 * Copyright 2022 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

@file:Suppress("IllegalIdentifier")

package com.icerock.library

import BaseUnitTest
import com.icerockdev.library.MR
import com.icerockdev.library.Testing
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import dev.icerock.moko.resources.download
import getString
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals

class StringResourceTests : BaseUnitTest() {

    @Test
    fun checkRuString() = runTest {
        MR.strings.download()

        StringDesc.localeType = StringDesc.LocaleType.Custom("ru")

        assertEquals(
            expected = "Тестовый проект",
            actual = MR.strings.common_name.desc().getString()
        )
    }

    @Test
    fun checkEnString() = runTest {
        MR.strings.download()

        StringDesc.localeType = StringDesc.LocaleType.Custom("en")

        assertEquals(
            expected = "Test Project",
            actual = MR.strings.common_name.desc().getString()
        )
    }

    @Test
    fun checkRuPlural() = runTest {
        MR.plurals.download()

        StringDesc.localeType = StringDesc.LocaleType.Custom("ru")

        assertEquals(
            expected = "ноль",
            actual = MR.plurals.test_plural.desc(0).getString()
        )
        assertEquals(
            expected = "один",
            actual = MR.plurals.test_plural.desc(1).getString()
        )
        assertEquals(
            expected = "два",
            actual = MR.plurals.test_plural.desc(2).getString()
        )
        assertEquals(
            expected = "несколько",
            actual = MR.plurals.test_plural.desc(3).getString()
        )
        assertEquals(
            expected = "много",
            actual = MR.plurals.test_plural.desc(40).getString()
        )
        assertEquals(
            expected = "несколько",
            actual = MR.plurals.test_plural.desc(22).getString()
        )
    }

    @Test
    fun checkEnPlural() = runTest {
        MR.plurals.download()

        StringDesc.localeType = StringDesc.LocaleType.Custom("en")

        assertEquals(
            expected = "zero",
            actual = MR.plurals.test_plural.desc(0).getString()
        )
        assertEquals(
            expected = "one",
            actual = MR.plurals.test_plural.desc(1).getString()
        )
        assertEquals(
            expected = "two",
            actual = MR.plurals.test_plural.desc(2).getString()
        )
        assertEquals(
            expected = "other",
            actual = MR.plurals.test_plural.desc(3).getString()
        )
        assertEquals(
            expected = "other",
            actual = MR.plurals.test_plural.desc(40).getString()
        )
        assertEquals(
            expected = "other",
            actual = MR.plurals.test_plural.desc(22).getString()
        )
    }

    @Ignore
    @Test
    fun checkRuStrings() = runTest {
        MR.strings.download()
        MR.plurals.download()

        StringDesc.localeType = StringDesc.LocaleType.Custom("ru")
        val rawString: String = Testing.getStringDesc().getString()

        assertEquals(
            expected = "тест\nтест\nТестовые данные 9\nмного\nмного\n10 элементов\n10 элементов\n" +
                    "raw string\nraw string\nтестraw string\nВыберите портфель и сумму\n" +
                    "вторая строка str первое число 9",
            actual = rawString
        )
    }

    @Ignore
    @Test
    fun checkEnStrings() = runTest {
        MR.strings.download()
        MR.plurals.download()

        StringDesc.localeType = StringDesc.LocaleType.Custom("en")
        val rawString: String = Testing.getStringDesc().getString()

        assertEquals(
            expected = "test\ntest\nTest data 9\nother\nother\n10 items\n10 items\nraw string\n" +
                    "raw string\ntestraw string\nCHOOSE PORTFOLIO & AMOUNT\n" +
                    "second string str first decimal 9",
            actual = rawString
        )
    }

    @Ignore
    @Test
    fun checkRuStringsList() {
        StringDesc.localeType = StringDesc.LocaleType.Custom("ru")
        val rawString: String = Testing.getStrings().joinToString("\n") { it.getString() }

        assertEquals(
            expected = "тест\nтест 2\nтест 3\nТестовый проект\nsome raw string\nодин\n" +
                    "несколько\nнесколько\nпервая строка\nвторая строка\nтретья строка.\n" +
                    "Alex009 сказал \"привет мир\" & \"пишите тесты\".\nтест вложенный\nмного\n" +
                    "plurals-interop: один\nplurals-interop: несколько\nplurals-interop: много",
            actual = rawString
        )
    }

    @Ignore
    @Test
    fun checkEnStringsList() {
        StringDesc.localeType = StringDesc.LocaleType.Custom("en")
        val rawString: String = Testing.getStrings().joinToString("\n") { it.getString() }

        assertEquals(
            expected = "test\ntest 2\ntest 3\nTest Project\nsome raw string\none\nother\n" +
                    "other\nfirst line\nsecond line\nthird line.\n" +
                    "Alex009 said \"hello world\" & \"write tests\".\nnested test\nother\n" +
                    "plurals-interop: one\nplurals-interop: other\nplurals-interop: other",
            actual = rawString
        )
    }

    @Ignore
    @Test
    fun checkRuPlurals() {
        StringDesc.localeType = StringDesc.LocaleType.Custom("ru")
        val rawString: String = Testing.getPlurals().getString()

        assertEquals(
            expected = """
                1 элемент
                2 элемента
                3 элемента
                4 элемента
                5 элементов
                6 элементов
                7 элементов
                8 элементов
                9 элементов
                10 элементов
                11 элементов
                12 элементов
                13 элементов
                14 элементов
                15 элементов
                16 элементов
                17 элементов
                18 элементов
                19 элементов
                20 элементов
                21 элемент
                22 элемента
                23 элемента
                24 элемента
                25 элементов
                26 элементов
            """.trimIndent(),
            actual = rawString
        )
    }

    @Ignore
    @Test
    fun checkEnPlurals() {
        StringDesc.localeType = StringDesc.LocaleType.Custom("en")
        val rawString: String = Testing.getPlurals().getString()

        assertEquals(
            expected = """
                1 item
                2 items
                3 items
                4 items
                5 items
                6 items
                7 items
                8 items
                9 items
                10 items
                11 items
                12 items
                13 items
                14 items
                15 items
                16 items
                17 items
                18 items
                19 items
                20 items
                21 items
                22 items
                23 items
                24 items
                25 items
                26 items
            """.trimIndent(),
            actual = rawString
        )
    }
}
