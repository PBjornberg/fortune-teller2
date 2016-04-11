/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author administrator
 */
public class TranslatorTest {
    
    @Test
    public void testGetNoun(){
        Translator translator = new Translator();
        assertEquals("en fotboja",translator.getNoun(2));
    }
    
    @Test
    public void testGetVerb(){
        Translator translator = new Translator();
        assertEquals("resa",translator.getVerb(9));
    }
    
    @Test
    public void testGetAdjective(){
        Translator translator = new Translator();
        assertEquals("snabb",translator.getAdjective(6));
    }
}
