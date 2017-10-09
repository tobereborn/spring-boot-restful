package com.github.tbr.spring;

import com.github.tbr.spring.config.CDPlayerConfig;
import com.github.tbr.spring.soundsystem.CompactDisc;
import com.github.tbr.spring.soundsystem.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

//    @Rule
//    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CompactDisc cd;

    @Qualifier("cd2Player")
    @Autowired
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void play() {
        player.play();
//        assertEquals(
//                "Playing Sgt. Pepper's Lonely Hearts Club Band" +
//                        " by The Beatles\n",
//                log.getLog());
    }
}