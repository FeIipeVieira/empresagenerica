package com.example.es2_colabore

import junit.framework.Assert.assertEquals
import org.junit.Test
class functionTest {
    @Test
    fun helloWorlReturnsPersonalizeMessage() {
        assertEquals("Hello, Molly!", helloWorld("Molly"))
    }
    @Test fun helloWorldReturnsGenericMessage() {
        assertEquals("Hello, World!", helloWorld())
    }
}
